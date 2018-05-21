package one.show.user.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.user.domain.WhiteList;

/**
 * Created by kevin on 15/8/19.
 */
public interface WhiteListService {
	
	
	/**
	 * 保存白名单
	 * 白名单中的用户直播不需要审核
	 * @param uid
	 * @param time
	 * @throws ServiceException
	 */
    void save(long uid, int time) throws ServiceException;

    /**
     * 把用户从白名单中删除
     * @param uid
     * @throws ServiceException
     */
    void remove(long uid) throws ServiceException;

    /**
     * 获取白名单列表
     * @param cursor 开始行号
     * @param count	总行数
     * @return
     * @throws ServiceException
     */
    List<WhiteList> findWhiteList(int cursor, int count) throws ServiceException;

    /**
     * 根据uid获取白名单数据
     * @param uid
     * @return
     * @throws ServiceException
     */
    WhiteList findWhiteListByUid(long uid) throws ServiceException;
    
   

}
