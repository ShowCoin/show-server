namespace java one.show.manage.thrift.iface

include "AdminFuncView.thrift"
include "AdminRoleFuncView.thrift"
include "AdminRoleView.thrift"
include "AdminUserListView.thrift"
include "AdminUserRoleView.thrift"
include "AdminUserView.thrift"
include "AdminRoleListView.thrift"
include "OperateLogView.thrift"

service AdminSystemServiceProxy{
		
	list<AdminFuncView.AdminFuncView> findFuncList(1:i32 status);
	
	AdminFuncView.AdminFuncView findFuncById(1:string funcId);
	
	string saveFunc(1:AdminFuncView.AdminFuncView adminFuncView);
	
	void updateFunc(1:AdminFuncView.AdminFuncView adminFuncView);
	
	void deleteFunc(1:string funcId);
	
	
	AdminUserView.AdminUserView findUser(1:string userName);
	
	list<AdminUserRoleView.AdminUserRoleView> findUserRole(1:string userName) 
	
	AdminRoleView.AdminRoleView findRoleById(1:i32 roleId)
	
	list<AdminRoleFuncView.AdminRoleFuncView> findFuncListByRoleId(1:i32 roleId)
	
	AdminRoleListView.AdminRoleListView findRoleList(1:i32 status, 2:i32 start, 3:i32 count)
	
	
	void saveUser(1:AdminUserView.AdminUserView adminUserView);
	
	void updateUser(1:AdminUserView.AdminUserView adminUserView);
	
	void deleteUser(1:string userName);
	
	AdminUserListView.AdminUserListView findUserList(1:i32 status, 2:i32 start, 3:i32 count)
	
	void updatePwd(1:string userName, 2:string password)
	
	void saveRole(1:AdminRoleView.AdminRoleView adminRoleView);
	
	void updateRole(1:AdminRoleView.AdminRoleView adminRoleView);
	
	void deleteRole(1:i32 roleId);
	
	
	void saveOperateLog(1:OperateLogView.OperateLogView operateLogView);
	
	
}

