/**
 * 
 */
package one.show.manage.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.App;
import one.show.manage.domain.ReturnList;
import one.show.manage.domain.Word;

/**
 * @author Haliaeetus leucocephalus 2018年1月13日 下午11:02:33
 *
 */


public interface SensitiveWordService {

	public String filter(String word, Integer appId) throws ServiceException;
	
	public ReturnList<Word> findListByAppId(Integer appId, String word, Integer start, Integer count) throws ServiceException;

	public void save(Word word) throws ServiceException;
	
	public void delete(Integer id) throws ServiceException;
	
	public void update(Integer id, String word) throws ServiceException;
	
	public List<App> findAppList() throws ServiceException;
	
	
}


