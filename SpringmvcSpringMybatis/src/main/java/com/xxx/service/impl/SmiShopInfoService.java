package com.xxx.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.dao.SmiShopInfoMapper;
import com.xxx.model.SmiShopInfo;
import com.xxx.service.ISmiShopInfoService;

/**
 * ӰԺ������Ϣ�ӿڷ���ʵ��
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
			logger.warn("�ŵ����Ϊnull��գ����飡");
			throw new Exception("�ŵ����Ϊ��");
		}

		return shopInfoMapper.getByNoAndPwd(password, shopNo);
	}

}
