package one.show.manage.service;

import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.Register;
import one.show.manage.domain.ReturnList;

public interface RegisterService {
	public void saveRegister(Register register) throws ServiceException;
	public Register getRegisterByUid(String uid) throws ServiceException;
	public void updateRegisterByUid(String uid,Map<String, String> paramMap) throws ServiceException;
	public ReturnList<Register> getRegisterList(Map<String,String> paramMap, Integer start, Integer count) throws ServiceException;
	public void updateRegister(Register register) throws ServiceException;

}
