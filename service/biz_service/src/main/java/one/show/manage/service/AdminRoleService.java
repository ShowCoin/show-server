
package one.show.manage.service;

import java.rmi.ServerException;
import java.util.List;

import one.show.common.Constant.ADMIN_STATUS;
import one.show.common.exception.ServiceException;
import one.show.manage.domain.AdminRole;
import one.show.manage.domain.AdminRoleFunc;
import one.show.manage.domain.ReturnList;

/**
 *
 * @author Haliaeetus leucocephalus
 *
 */

public interface AdminRoleService {
    
    
    /**
     * 根据id获取角色
     * @param roleId
     * @return
     * @throws ServiceException
     *
     */
     AdminRole getRole(Integer roleId) throws ServiceException;
    
    
    /**
     * 获取角色列表
     * @param status 状态
     * @return
     * @throws ServiceException
     *
     */
     ReturnList<AdminRole> getRoleList(ADMIN_STATUS status, Integer start, Integer count) throws ServiceException;
    
    
    /**
     * 新增角色
     * @param ar
     * @param funcIds  角色对应的功能
     * @throws ServerException
     *
     */
     void addRole(AdminRole ar, List<String> funcIds) throws ServiceException;
    
    
    /**
     * 获取一个角色下功能列表
     * @param roleId
     * @return
     * @throws ServerException
     *
     */
     List<AdminRoleFunc> getRoleFunc(Integer roleId)  throws ServiceException;
    
    
    
    /**
     * 修改角色
     * @param ar
     * @param funcIds  角色对应的功能
     * @throws ServiceException
     */
     void updateRole(AdminRole ar, List<String> funcIds) throws ServiceException;
    
    
    /**
     * 删除角色
     * @param roleId
     * @throws ServiceException
     */
     void deleteRole(Integer roleId) throws ServiceException;
    

}


