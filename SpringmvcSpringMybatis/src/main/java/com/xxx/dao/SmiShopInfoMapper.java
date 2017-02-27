package com.xxx.dao;

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

}
