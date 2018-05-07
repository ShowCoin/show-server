
package one.show.user.service;

import java.util.List;
import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.user.domain.Family;
import one.show.user.domain.FamilyMember;
import one.show.user.domain.ReturnList;

/**
 * @author kevin  
 *
 * 
 */

public interface FamilyService {

	//----------------家族
	public Family findFamilyById(long familyId) throws ServiceException;
	
	public List<Family> findByIds(List<Long> ids) throws ServiceException;
	
	public long insertFamily(Family family) throws ServiceException;
	
	public void updateFamilyById(long familyId, Map<String, String> updateContent) throws ServiceException;
	
	public ReturnList<Family> findFamilyList(Map<String, String> condition, int start, int count) throws ServiceException;
	
	//--------------家族关系
	public FamilyMember findFamilyMemberById(long familyId, long userId)throws ServiceException;
	
	public ReturnList<FamilyMember> findFamilyMemberListByFamilyId(long familyId, int start, int count)throws ServiceException;
	
	public void insertFamilyMember(FamilyMember member)throws ServiceException;
	
	public void deleteFamilyMemberById(long familyId,long userId)throws ServiceException;
}


