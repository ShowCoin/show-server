
package one.show.manage.service;

import java.rmi.ServerException;
import java.util.List;

import one.show.common.Constant.ADMIN_STATUS;
import one.show.common.exception.ServiceException;
import one.show.manage.domain.AdminFunc;

/**
 * @author Haliaeetus leucocephalus
 */

public interface AdminFuncService {

    /**
     * 新增功能
     * 
     * @param af
     * @throws ServerException
     */
    public String add(AdminFunc af) throws ServiceException;

    /**
     * 根据状态获取功能列表
     * 
     * @param status 功能状态，null全部
     * @return
     * @throws ServiceException
     */
    public List<AdminFunc> getFuncList(ADMIN_STATUS status) throws ServiceException;

    /**
     * 获取funcId下面子节点
     * 
     * @param funcId
     * @param recursion false:获取一级子节点，true:获取所有子节点
     * @return
     */
    public List<AdminFunc> getChildList(String funcId, boolean recursion) throws ServiceException;

    /**
     * 根据id获取功能
     * 
     * @return
     * @throws ServiceException
     */
    public AdminFunc getById(String funcId) throws ServiceException;

    /**
     * 修改功能
     * 
     * @return
     * @throws ServiceException
     */
    public void update(AdminFunc af) throws ServiceException;

    /**
     * 删除功能
     * 
     * @return
     * @throws ServiceException
     */
    public void delete(String funcId) throws ServiceException;

}
