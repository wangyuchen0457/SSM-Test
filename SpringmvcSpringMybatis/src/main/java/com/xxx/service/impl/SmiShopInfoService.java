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

	@Override
	public SmiShopInfo getShopById(Integer id) throws Exception {
	
		return shopInfoMapper.getById(id);
	}

	@Override
	public void addShopInfo(SmiShopInfo smiShopInfo) throws Exception {
		String shopNo=smiShopInfo.getShopNo();
		String shopName=smiShopInfo.getShopName();
		String shopType=smiShopInfo.getShopType();
		String shopPassword=smiShopInfo.getShopPassword();
		String note=smiShopInfo.getNote();
		shopInfoMapper.addShop(shopNo, shopName, shopPassword, shopType, note);
	}

	@Override
	public List<SmiShopInfo> showAll() throws Exception {
		
		return shopInfoMapper.selectAll();
	}

	@Override
	public void delById(Integer id) throws Exception {
		
		shopInfoMapper.delShopById(id);
	}

	@Override
	public void delByIds(Integer[] ids) throws Exception {
		
		shopInfoMapper.delShopByIds(ids);
	}

	@Override
	public void updateById(SmiShopInfo smiShopInfo) throws Exception {
		Integer id=smiShopInfo.getId();
		String shopNo=smiShopInfo.getShopNo();
		String shopName=smiShopInfo.getShopName();
		String shopType=smiShopInfo.getShopType();
		String shopPassword=smiShopInfo.getShopPassword();
		String note=smiShopInfo.getNote();
		shopInfoMapper.updateById(id, shopNo, shopName, shopPassword, shopType, note);
		
	}

}
