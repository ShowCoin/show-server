package one.show.video.service;

import java.util.List;

import one.show.video.domain.LiveRecord;

import org.apache.ibatis.annotations.Param;

public interface LiveRecordService {

	public LiveRecord findById(long id);

	public List<LiveRecord> findByPersistentId(String persistentId);
	
	public List<LiveRecord> findByLiveid(long liveid);
	
	public List<LiveRecord> findByStatus( int status);

	public int save(LiveRecord record);

	void updateStatusByLiveId(long liveid, int status);
	
	void updatePersistentIdByLiveId(long liveid, int format,String persistentId, int status);
	
	void deleteLiveRecord(long id);

}
