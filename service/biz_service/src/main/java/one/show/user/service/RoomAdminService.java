package one.show.user.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.user.domain.RoomAdmin;

/**
 * Created by kevin on 15/8/19.
 */
public interface RoomAdminService {
	
    void save(long uid, long tid) throws ServiceException;

    void delete(long uid, long tid) throws ServiceException;


    List<Long> findListByUid(long uid, int cursor, int count) throws ServiceException;
    
    
    public Integer findCountByUid(long uid) throws ServiceException;
    
    public boolean isRoomAdmin(long uid, long tid) throws ServiceException;
    

}
