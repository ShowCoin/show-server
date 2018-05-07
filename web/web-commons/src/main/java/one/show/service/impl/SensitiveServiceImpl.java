package one.show.service.impl;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.service.SensitiveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.manage.thrift.iface.SensitiveServiceProxy;
import one.show.manage.thrift.view.AppView;
import one.show.manage.thrift.view.WordListView;
import one.show.manage.thrift.view.WordView;

@Component("sensitiveService")
public class SensitiveServiceImpl implements SensitiveService {

	@Autowired
	private SensitiveServiceProxy.Iface sensitiveServiceClientProxy;

	public String filter(String word, int appId) throws ServiceException {
		try {

			return sensitiveServiceClientProxy.filter(word, appId);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.SensitiveService#findListByAppId(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public WordListView findListByAppId(Integer appId, String word, Integer start,
			Integer count) throws ServiceException {
		
		try {

			return sensitiveServiceClientProxy.findListByAppId(appId, word, start, count);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	/* (non-Javadoc)
	 * @see one.show.service.SensitiveService#save(one.show.sensitive.thrift.view.WordView)
	 */
	@Override
	public void save(WordView wordView) throws ServiceException {
		try {

			sensitiveServiceClientProxy.save(wordView);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	/* (non-Javadoc)
	 * @see one.show.service.SensitiveService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) throws ServiceException {

		try {

			sensitiveServiceClientProxy.deleteWord(id);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.SensitiveService#update(java.lang.Integer, java.lang.String)
	 */
	@Override
	public void update(Integer id, String word) throws ServiceException {

		try {

			sensitiveServiceClientProxy.update(id, word);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/* (non-Javadoc)
	 * @see one.show.service.SensitiveService#findAppList()
	 */
	@Override
	public List<AppView> findAppList() throws ServiceException {
		try {

			return sensitiveServiceClientProxy.findAppList();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
}