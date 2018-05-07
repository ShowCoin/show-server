package one.show.user.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.user.domain.BlackList;

/**
 * Created by kevin on 15/8/19.
 */
public interface BlackListService {
    int save(long currentUser, long target_userid) throws ServiceException;

    void remove(long currentUser, long target_userid) throws ServiceException;

    List<Long> findBlackList(long currentUser, int cursor, int count);

    List<BlackList> findBlackListByUid(long uid, int cursor, int count) throws ServiceException;
    
    List<BlackList> findBlackListByTid(long tid, int cursor, int count) throws ServiceException;
    
    public Integer findCountBlackListByUid(long uid) throws ServiceException;
    
    public Integer findCountBlackListByTid(long tid) throws ServiceException;

    public boolean isBlack(long uid, long tid) throws ServiceException;

}
