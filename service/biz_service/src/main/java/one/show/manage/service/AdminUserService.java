
package one.show.manage.service;

import java.rmi.ServerException;
import java.util.List;

import one.show.common.Constant.ADMIN_STATUS;
import one.show.common.exception.ServiceException;
import one.show.manage.domain.AdminUser;
import one.show.manage.domain.AdminUserRole;
import one.show.manage.domain.ReturnList;

/**
 *
 * @author Haliaeetus leucocephalus
 *
 */

public interface AdminUserService {
    
    /**
     * 新增用户
     * @param au
     * @param roleIds    角色数据
     * @throws ServerException
     */
    public void addUser(AdminUser au, List<Integer> roleIds) throws ServiceException;
    
    
    /**
     * 根据用户名获取用户
     * @param aur
     * @throws ServerException
     */
    public AdminUser getUser(String userName) throws ServiceException;
    
    
    /**
     * 获取用户列表
     * @param status   用户状态
     * @param start
     * @param count
     * @return
     * @throws ServiceException
     */
    public ReturnList<AdminUser> getUserList(ADMIN_STATUS status, int start, int count) throws ServiceException;
    
    
    /**
     * 修改用户
     * @param au    
     * @param roleIds    角色数据
     * @throws ServiceException
     */
    public void updateUser(AdminUser au, List<Integer> roleIds) throws ServiceException;
    
    
    /**
     * 修改密码
     * @param userName
     * @param password
     * @throws ServiceException
     */
    public void updatePwd(String userName, String password)throws ServiceException;
    
  
    
    /**
     * 删除用户
     * @param passport
     * @throws ServerException
     */
    public void delelteUser(String userName) throws ServiceException;
    
    
    /**
     * 获取一个用户的角色列表
     * @param aur
     * @return
     * @throws ServerException
     */
    public List<AdminUserRole> getUserRole(String userName) throws ServiceException;

}


