package one.show.video.service;

import java.util.List;

import one.show.video.domain.LiveRecord;

import org.apache.ibatis.annotations.Param;

public interface LiveRecordService {

	/**
	 * 根据ID获得直播记录
	 * 
	 * @param id
	 * @return
	 */
	public LiveRecord findById(long id);

	/**
	 * 根据处理ID获得直播记录列表
	 * 
	 * @param persistentId
	 * @return
	 */
	public List<LiveRecord> findByPersistentId(String persistentId);

	/**
	 * 根据直播ID获得直播记录列表
	 * 
	 * @param liveid
	 * @return
	 */
	public List<LiveRecord> findByLiveid(long liveid);

	/**
	 * 根据直播状态获得直播记录列表
	 * 
	 * @param status
	 * @return
	 */
	public List<LiveRecord> findByStatus(int status);

	/**
	 * 保存直播记录
	 * 
	 * @param record
	 * @return
	 */
	public int save(LiveRecord record);

	/**
	 * 根据直播ID更新直播状态
	 * 
	 * @param liveid
	 * @param status
	 */
	void updateStatusByLiveId(long liveid, int status);

	/**
	 * 根据直播ID更新格式、处理ID、状态
	 * 
	 * @param liveid
	 * @param format
	 * @param persistentId
	 * @param status
	 */
	void updatePersistentIdByLiveId(long liveid, int format, String persistentId, int status);

	/**
	 * 根据ID删除直播记录
	 * 
	 * @param id
	 */
	void deleteLiveRecord(long id);

	public List<LiveRecord> findByTime(long curtime);

}
