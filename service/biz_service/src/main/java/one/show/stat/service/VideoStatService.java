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
	
	/**
	 * 获取直播流状态
	 * @param rtmp 直播流地址
	 * @return
	 * 
	 * {
    "streams": [
        {
            "index": 0,
            "codec_name": "h264",
            "codec_long_name": "H.264 / AVC / MPEG-4 AVC / MPEG-4 part 10",
            "profile": "High",
            "codec_type": "video",
            "codec_time_base": "1/30",
            "codec_tag_string": "[0][0][0][0]",
            "codec_tag": "0x0000",
            "width": 540,
            "height": 960,
            "coded_width": 540,
            "coded_height": 960,
            "has_b_frames": 2,
            "sample_aspect_ratio": "0:1",
            "display_aspect_ratio": "0:1",
            "pix_fmt": "yuv420p",
            "level": 31,
            "chroma_location": "left",
            "field_order": "progressive",
            "refs": 1,
            "is_avc": "true",
            "nal_length_size": "4",
            "r_frame_rate": "15/1",
            "avg_frame_rate": "15/1",
            "time_base": "1/1000",
            "start_pts": 133,
            "start_time": "0.133000",
            "bit_rate": "942603",
            "bits_per_raw_sample": "8",
            "disposition": {
                "default": 0,
                "dub": 0,
                "original": 0,
                "comment": 0,
                "lyrics": 0,
                "karaoke": 0,
                "forced": 0,
                "hearing_impaired": 0,
                "visual_impaired": 0,
                "clean_effects": 0,
                "attached_pic": 0,
                "timed_thumbnails": 0
            }
        },
        {
            "index": 1,
            "codec_name": "aac",
            "codec_long_name": "AAC (Advanced Audio Coding)",
            "profile": "LC",
            "codec_type": "audio",
            "codec_time_base": "1/44100",
            "codec_tag_string": "[0][0][0][0]",
            "codec_tag": "0x0000",
            "sample_fmt": "fltp",
            "sample_rate": "44100",
            "channels": 2,
            "channel_layout": "stereo",
            "bits_per_sample": 0,
            "r_frame_rate": "0/0",
            "avg_frame_rate": "0/0",
            "time_base": "1/1000",
            "start_pts": 1,
            "start_time": "0.001000",
            "bit_rate": "131984",
            "disposition": {
                "default": 0,
                "dub": 0,
                "original": 0,
                "comment": 0,
                "lyrics": 0,
                "karaoke": 0,
                "forced": 0,
                "hearing_impaired": 0,
                "visual_impaired": 0,
                "clean_effects": 0,
                "attached_pic": 0,
                "timed_thumbnails": 0
            }
        }
    ],
    "format": {
        "filename": "rtmp://pull.x.xx/show/xxxx",
        "nb_streams": 2,
        "nb_programs": 0,
        "format_name": "flv",
        "format_long_name": "FLV (Flash Video)",
        "start_time": "0.001000",
        "duration": "0.000000",
        "probe_score": 100,
        "tags": {
            "major_brand": "isom",
            "minor_version": "512",
            "compatible_brands": "isomiso2avc1mp41",
            "comment": "vid:707f793338db4677abddf146483ea95b",
            "encoder": "Lavf58.12.100"
        }
    }
}
	 */
	public String getStreamStatus(String rtmp);


}


