package one.show.service.impl;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.service.SearchService;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import one.show.search.thrift.iface.SearchServiceProxy;
import one.show.search.thrift.view.UserSearchView;

/**
 * Created by Haliaeetus leucocephalus on 18/1/18.
 */
@Component("searchService")
public class SearchServiceImpl implements SearchService {
	private static final Logger log = LoggerFactory
			.getLogger(SearchServiceImpl.class);

	@Autowired
	SearchServiceProxy.Iface searchServiceClientProxy;

	@Override
	public List<Long> searchUser(String keyword, Integer cursor,
			Integer count) throws ServiceException {
		try {
			return searchServiceClientProxy.searchUser(keyword, cursor,
					count);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void insertUser(UserSearchView userSearchView) throws ServiceException {
		try {
			searchServiceClientProxy.insertUser(userSearchView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateUser(UserSearchView userSearchView) throws ServiceException {
		try {
			searchServiceClientProxy.updateUser(userSearchView);
		} catch (TException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteUser(Long uid) throws ServiceException {

		try {
			 searchServiceClientProxy.deleteUser(uid);
		} catch (TException e) {
			throw new ServiceException(e);
		}
		
	}



}