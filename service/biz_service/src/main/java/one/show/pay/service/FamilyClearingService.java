
package one.show.pay.service;

import java.util.Map;

import one.show.common.exception.ServiceException;
import one.show.pay.domain.FamilyClearing;
import one.show.pay.domain.FamilyMemberClearing;
import one.show.pay.domain.ReturnList;

/**
 * @author hank
 *
 * 
 */

public interface FamilyClearingService {
	
	public void addFamilyClearing(FamilyClearing familyClearing) throws ServiceException;
	
	public void addFamilyMemberClearing(FamilyMemberClearing familyMemberClearing) throws ServiceException;

	
	public ReturnList<FamilyClearing> getFamilyClearingList(Map<String, String> paramMap,  Integer start,  Integer count) throws ServiceException;

	
	public ReturnList<FamilyMemberClearing> getFamilyMemberClearingListByCidAndFamilyId(Integer cid, Long familyId,  Integer start,  Integer count) throws ServiceException;

	public FamilyClearing getFamilyClearingById(long id);

	public void updateFamilyClearing(long id, Map<String, String> updateContent);
	
	public void updateLevelFamilys (long id);

	public Integer cleanNum(long id) throws ServiceException;
}


