package com.xxx.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.dao.SmiShopInfoMapper;
import com.xxx.model.SmiShopInfo;
import com.xxx.service.ISmiShopInfoService;

/**
 * 影院店铺信息接口服务实现
 * 
 * @author author
 * @date 2016/02/16
 */
@Service("smiShopInfoService")
public class SmiShopInfoService implements ISmiShopInfoService {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	public SmiShopInfoMapper shopInfoMapper;

	@Override
	public SmiShopInfo getShopByNoAndPwd(String shopNo, String password) throws Exception {
		if (null == shopNo || "".equals(shopNo)) {
			logger.warn("门店编码为null或空，请检查！");
			throw new Exception("门店编码为空");
		}

		return shopInfoMapper.getByNoAndPwd(password, shopNo);
	}
	//获取商店信息通过id
	@Override
	public SmiShopInfo getShopById(Integer id) throws Exception {
	
		return shopInfoMapper.getById(id);
	}
//增加商店信息
	@Override
	public void addShopInfo(SmiShopInfo smiShopInfo) throws Exception {
		String shopNo=smiShopInfo.getShopNo();
		String shopName=smiShopInfo.getShopName();
		String shopType=smiShopInfo.getShopType();
		String shopPassword=smiShopInfo.getShopPassword();
		String note=smiShopInfo.getNote();
		shopInfoMapper.addShop(shopNo, shopName, shopPassword, shopType, note);
	}
//获取所有信息
	@Override
	public List<SmiShopInfo> showAll() throws Exception {
		
		return shopInfoMapper.selectAll();
	}
//删除单个
	@Override
	public void delById(Integer id) throws Exception {
		
		shopInfoMapper.delShopById(id);
	}
//删除多个
	@Override
	public void delByIds(Integer[] ids) throws Exception {
		
		shopInfoMapper.delShopByIds(ids);
	}
//修改一个
	@Override
	public void updateById(SmiShopInfo smiShopInfo) throws Exception {
		Integer id=smiShopInfo.getId();
		String shopNo=smiShopInfo.getShopNo();
		String shopName=smiShopInfo.getShopName();
		String shopType=smiShopInfo.getShopType();
		String note=smiShopInfo.getNote();
		shopInfoMapper.updateById(id, shopNo, shopName, shopType, note);
		
	}
//修改多个
	@Override
	public void updateByIds(SmiShopInfo smiShopInfo) throws Exception {
		Integer[] upIds = smiShopInfo.getIds();
		String shopNo=smiShopInfo.getShopNo();
		String shopName=smiShopInfo.getShopName();
		String shopType=smiShopInfo.getShopType();
		String note=smiShopInfo.getNote();
		shopInfoMapper.updateByIds(upIds, shopNo, shopName, shopType, note);
		
	}
	

}
