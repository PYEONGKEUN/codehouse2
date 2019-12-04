package com.itbuddy.codehouse.DTO;

public class Cmt_file {
	Integer cmt_fil_no;
	String cmt_fil_url;
	Integer cmt_no;
	public Integer getCmt_fil_no() {
		return cmt_fil_no;
	}
	public void setCmt_fil_no(Integer cmt_fil_no) {
		this.cmt_fil_no = cmt_fil_no;
	}
	public String getCmt_fil_url() {
		return cmt_fil_url;
	}
	public void setCmt_fil_url(String cmt_fil_url) {
		this.cmt_fil_url = cmt_fil_url;
	}
	public Integer getCmt_no() {
		return cmt_no;
	}
	public void setCmt_no(Integer cmt_no) {
		this.cmt_no = cmt_no;
	}
	@Override
	public String toString() {
		return "Cmt_file [cmt_fil_no=" + cmt_fil_no + ", cmt_fil_url=" + cmt_fil_url + ", cmt_no=" + cmt_no + "]";
	}

}
