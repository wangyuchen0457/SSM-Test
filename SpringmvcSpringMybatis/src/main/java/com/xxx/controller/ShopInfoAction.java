package com.xxx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.controller.valueobject.ShopInfoVO;
import com.xxx.model.SmiShopInfo;
import com.xxx.service.ISmiShopInfoService;

/**
 * 影院店铺信息action
 * 
 * @author author
 * @date 2016/02/16
 */
@Controller
public class ShopInfoAction {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ISmiShopInfoService smiShopInfoService;

	ShopInfoVO vo = new ShopInfoVO();

	/**
	 * 用户登录
	 * 
	 * @ResponseBody 设置该参数，指定response的type为比如json或xml，本文采用json序列化方式传输数据
	 * 
	 * @param request
	 * @param response
	 * @param shopNo
	 * @param password
	 * @return
	 * @throws Exception
	 */
	// 登录成功页面
	@RequestMapping(value = "/main.do")
	public String inputProduct(HttpServletRequest request) {
		request.setAttribute("vo", vo);
		logger.info("show！");
		return "redirect:/show.do";
	}

	// 登陆页面
	@RequestMapping(value = "/login.do")
	public @ResponseBody ShopInfoVO login(HttpServletRequest request, HttpServletResponse response, String shopNo,
			String password) throws Exception {

		SmiShopInfo shopInfo = smiShopInfoService.getShopByNoAndPwd(shopNo, password);
		if (null == shopInfo || "".equals(shopInfo)) {

			logger.warn(shopNo + "：登录失败，用户名或密码错误");
			return null;
		} else {
			vo.setId(shopInfo.getId());
			vo.setShopNo(shopInfo.getShopNo());
			vo.setShopName(shopInfo.getShopName());
			vo.setShopPassword("");// 密码不传输到页面
			vo.setShopType(shopInfo.getShopType());
			vo.setNote(shopInfo.getNote());

			logger.info(shopInfo.getShopName() + "[" + shopNo + "]：登录成功");
			return vo;
		}
	}

	// 增加商店信息
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String addShopInfoVO(ShopInfoVO shopInfoVO, HttpServletRequest request) throws Exception {
		logger.info("addShopInfoVO 被调用！");

		SmiShopInfo smiShopInfo = new SmiShopInfo();
		smiShopInfo.setNote(shopInfoVO.getNote());
		smiShopInfo.setShopName(shopInfoVO.getShopName());
		smiShopInfo.setShopNo(shopInfoVO.getShopNo());
		smiShopInfo.setShopPassword(shopInfoVO.getShopPassword());
		smiShopInfo.setShopType(shopInfoVO.getShopType());
		smiShopInfoService.addShopInfo(smiShopInfo);
		request.setAttribute("message", "The shopinfo was successfully added!");
		// redirectAttributes.addFlashAttribute("message", "The shopinfo was
		// successfully added!");
		return "redirect:/show.do";
	}

	// 查看所有信息
	@RequestMapping(value = "/show.do")
	public String showProduct(HttpServletRequest request) throws Exception {
		List<SmiShopInfo> voList = smiShopInfoService.showAll();
		request.setAttribute("voList", voList);
		/*
		 * ModelAndView mView=new ModelAndView("ProductList");
		 * mView.addObject(pList);
		 */
		return "main";
	}

	// 根据id删除产品
	@RequestMapping(value = "/delById.do")
	public String delProductById(@RequestParam Integer id, HttpServletRequest request) throws Exception {
		smiShopInfoService.delById(id);
		return "redirect:/show.do";
	}

	// 根据id删除产品
	@RequestMapping(value = "/delByIds.do")
	public String delProductByIds(@RequestParam("checked") Integer[] ids, HttpServletRequest request) throws Exception {
		smiShopInfoService.delByIds(ids);

		return "redirect:/show.do";
	}

	// 修改页面跳转
	@RequestMapping(value = "/updateOne.do")
	public String updateOne(@RequestParam Integer id, HttpServletRequest request) throws Exception {
		SmiShopInfo shopInfo = smiShopInfoService.getShopById(id);
		vo.setId(shopInfo.getId());
		vo.setShopNo(shopInfo.getShopNo());
		vo.setShopName(shopInfo.getShopName());
		vo.setShopType(shopInfo.getShopType());
		vo.setNote(shopInfo.getNote());
		request.setAttribute("vo", vo);
		return "update";
	}

	// 修改一条数据
	@RequestMapping(value = "/updateById.do")
	public @ResponseBody SmiShopInfo updateById(HttpServletRequest request, Integer id, String shopNo, String shopName,
			String shopType, String note) throws Exception {
		SmiShopInfo shopInfo = new SmiShopInfo();
		shopInfo.setId(id);
		shopInfo.setNote(note);
		shopInfo.setShopName(shopName);
		shopInfo.setShopNo(shopNo);
		shopInfo.setShopType(shopType);
		smiShopInfoService.updateById(shopInfo);
		logger.info(shopInfo.getShopName() + "[" + shopNo + "]：修改成功");
		return shopInfo;
	}
}
