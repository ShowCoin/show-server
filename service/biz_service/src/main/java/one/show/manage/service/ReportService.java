package one.show.manage.service;

import one.show.common.exception.ServiceException;
import one.show.manage.domain.Report;

public interface ReportService {
	public void saveReport(Report report) throws ServiceException;
}