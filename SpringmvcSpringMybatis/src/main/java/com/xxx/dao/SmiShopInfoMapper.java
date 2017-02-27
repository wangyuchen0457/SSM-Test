package com.xxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.model.SmiShopInfo;

/**
 * 影院店铺信息映射关系 数据实例化接口
 * 
 * @author author
 * @date 2016/02/16
 */
public interface SmiShopInfoMapper {

	/**
	 * 根据门店编码和密码获取门店信息
	 * 
	 * @param password
	 *            门店密码
	 * @param shopNo
	 *            门店编码
	 */
	public SmiShopInfo getByNoAndPwd(
			@Param("password") String password, 
			@Param("shopNo") String shopNo);
	
	public void addShop(
			@Param("shopNo") String shopNo,
			@Param("shopName") String shopName,
			@Param("shopPassword") String shopPassword,
			@Param("shopType") String shopType,
			@Param("note") String note);
	
	public List<SmiShopInfo> selectAll();
	
	public void delShopById(@Param("id") Integer id);
	public void delShopByIds(@Param("ids") Integer[] ids);
}
