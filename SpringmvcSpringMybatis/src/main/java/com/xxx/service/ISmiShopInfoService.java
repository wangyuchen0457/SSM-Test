package com.xxx.service;

import java.util.List;

import com.xxx.model.SmiShopInfo;

/**
 * 影院店铺信息接口服务
 * 
 * @author author
 * @date 2016/02/16
 */
public interface ISmiShopInfoService {

	/**
	 * 根据店铺的编码和密码查询店铺信息
	 * @param shopNo 店铺编码
	 * @param password 密码
	 * @return 店铺信息
	 * @throws Exception 
	 */
	public SmiShopInfo getShopByNoAndPwd(String shopNo, String password) throws Exception;
	public void addShopInfo(SmiShopInfo smiShopInfo) throws Exception;
	public List<SmiShopInfo> showAll() throws Exception;
	public void delById(Integer id) throws Exception;
	public void delByIds(Integer[] ids) throws Exception;
}
