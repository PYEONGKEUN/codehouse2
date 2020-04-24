package org.itbuddy.codehouse.DTO;

public class Article {
	Integer art_no;
	String art_title;
	String art_content;
	String art_create_time;
	String art_modify_time;
	String mem_id;
	public Integer getArt_no() {
		return art_no;
	}
	public void setArt_no(Integer art_no) {
		this.art_no = art_no;
	}
	public String getArt_title() {
		return art_title;
	}
	public void setArt_title(String art_title) {
		this.art_title = art_title;
	}
	public String getArt_content() {
		return art_content;
	}
	public void setArt_content(String art_content) {
		this.art_content = art_content;
	}
	public String getArt_create_time() {
		return art_create_time;
	}
	public void setArt_create_time(String art_create_time) {
		this.art_create_time = art_create_time;
	}
	public String getArt_modify_time() {
		return art_modify_time;
	}
	public void setArt_modify_time(String art_modify_time) {
		this.art_modify_time = art_modify_time;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public String toString() {
		return "Article [art_no=" + art_no + ", art_title=" + art_title + ", art_content=" + art_content
				+ ", art_create_time=" + art_create_time + ", art_modify_time=" + art_modify_time + ", mem_id=" + mem_id
				+ "]";
	}

	
}
