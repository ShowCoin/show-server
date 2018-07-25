package one.show.view;

import java.io.Serializable;

/**
 * 返回结果
 *
 * @param <T>
 */
public class Result<T> implements Serializable{

	long Serializable = 1L;
	
	 private String code;

	 private String msg;
	 
	 private T data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	 
	 


}
