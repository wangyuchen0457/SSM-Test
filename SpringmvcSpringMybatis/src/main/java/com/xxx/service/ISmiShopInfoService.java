package com.xxx.service;

import java.util.List;

import com.xxx.model.SmiShopInfo;

/**
 * ӰԺ������Ϣ�ӿڷ���
 * 
 * @author author
 * @date 2016/02/16
 */
public interface ISmiShopInfoService {

	/**
	 * ���ݵ��̵ı���������ѯ������Ϣ
	 * @param shopNo ���̱���
	 * @param password ����
	 * @return ������Ϣ
	 * @throws Exception 
	 */
	public SmiShopInfo getShopByNoAndPwd(String shopNo, String password) throws Exception;
	public void addShopInfo(SmiShopInfo smiShopInfo) throws Exception;
	public List<SmiShopInfo> showAll() throws Exception;
	public void delById(Integer id) throws Exception;
	public void delByIds(Integer[] ids) throws Exception;
}
