package one.show.manage.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.SendExchange;

/**
 * 
 * @author hank
 *
 */
public interface SendExchangeService {
	
	public void saveSendExchange(SendExchange sendExchange) throws ServiceException;
	
	public List<SendExchange> findSendExchangeByUid(Long uid,int sendType,int start,int count) throws ServiceException;
	
	public Integer findSendExchangeCountByUid(Long uid,int sendType) throws ServiceException;
	
}
