package com.xxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.model.SmiShopInfo;

/**
 * ӰԺ������Ϣӳ���ϵ ����ʵ�����ӿ�
 * 
 * @author author
 * @date 2016/02/16
 */
public interface SmiShopInfoMapper {

	/**
	 * �����ŵ����������ȡ�ŵ���Ϣ
	 * 
	 * @param password
	 *            �ŵ�����
	 * @param shopNo
	 *            �ŵ����
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
