package com.itbuddy.codehouse.DTO;

public class Comment {
	Integer cmt_no;
	String cmt_title;
	String cmt_content;
	String cmt_create_time;
	String cmt_modify_time;
	String mem_id;
	public Integer getCmt_no() {
		return cmt_no;
	}
	public void setCmt_no(Integer cmt_no) {
		this.cmt_no = cmt_no;
	}
	public String getCmt_title() {
		return cmt_title;
	}
	public void setCmt_title(String cmt_title) {
		this.cmt_title = cmt_title;
	}
	public String getCmt_content() {
		return cmt_content;
	}
	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}
	public String getCmt_create_time() {
		return cmt_create_time;
	}
	public void setCmt_create_time(String cmt_create_time) {
		this.cmt_create_time = cmt_create_time;
	}
	public String getCmt_modify_time() {
		return cmt_modify_time;
	}
	public void setCmt_modify_time(String cmt_modify_time) {
		this.cmt_modify_time = cmt_modify_time;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public String toString() {
		return "Comment [cmt_no=" + cmt_no + ", cmt_title=" + cmt_title + ", cmt_content=" + cmt_content
				+ ", cmt_create_time=" + cmt_create_time + ", cmt_modify_time=" + cmt_modify_time + ", mem_id=" + mem_id
				+ "]";
	}

}
