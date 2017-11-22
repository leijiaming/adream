package com.dream.util;

import java.io.Serializable;

public class NoteResult implements Serializable{
	private static final long serialVersionUID = 1L;
	/**data
	 * 状态码 0-成功  2-失败
	 */
	private int status;
	/**
	 * 消息提示,如(成功)
	 */
	private Object msg;
	/**
	 * 设置要返回的具体数据
	 */
	private Object data;//返回的数据
	private Object info;//携带附加信息
	public NoteResult(){
		
	}
	public NoteResult(int status, Object msg, Object data, Object info) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
		this.info = info;
	}
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getMsg() {
		return msg;
	}
	public void setMsg(Object msg) {
		this.msg = msg;
	}
}
