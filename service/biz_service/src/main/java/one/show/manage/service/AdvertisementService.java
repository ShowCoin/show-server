package one.show.manage.service;

import java.util.List;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.Advertisement;

public interface AdvertisementService {
	public List<Advertisement> findAdvertisement()throws ServiceException;
}
