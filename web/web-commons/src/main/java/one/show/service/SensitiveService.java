package one.show.service;

import java.util.List;

import one.show.common.exception.ServiceException;

import one.show.manage.thrift.view.AppView;
import one.show.manage.thrift.view.WordListView;
import one.show.manage.thrift.view.WordView;
/**
 * 
 * @author hank
 *
 */
public interface SensitiveService {

	/**
	 * 敏感词转换
	 * @param word
	 * @param appId
	 * @return
	 * @throws ServiceException
	 */
	public String filter(String word,int appId) throws ServiceException;
	
	public WordListView findListByAppId(Integer appId, String word, Integer start, Integer count) throws ServiceException;

	public void save(WordView wordView) throws ServiceException;
	
	public void delete(Integer id) throws ServiceException;
	
	public void update(Integer id, String word) throws ServiceException;
	
	public List<AppView> findAppList() throws ServiceException;
}
