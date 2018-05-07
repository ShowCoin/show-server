package one.show.stat.service;

import java.util.List;

import one.show.stat.domain.VideoStat;

/**
 * @author hank 2018年1月14日 
 *
 */


public interface VideoStatService {

	public VideoStat findByVid(Long vid);
	
	public void save(VideoStat videoStat);
	
	public void update(VideoStat videoStat);

	List<VideoStat> findByVids(List<Long> vids);


}


