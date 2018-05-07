/**
 * 
 */
package one.show.manage.domain;

/**
 * @author Haliaeetus leucocephalus 2018年1月14日 下午12:29:31
 * 
 */
public class Word {

	private Integer id;
	private Integer appId;
	private String word;
	private Integer createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

}
