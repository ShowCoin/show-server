/**
 * 
 */
package one.show.user.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.user.domain.Contact;

/**
 * @author kevin 
 *
 */
public interface ContactService {
	
	public List<Contact> findListByUid(String uid);
	
	public void batchSave(List<Contact> contactList) throws ServiceException;
}


