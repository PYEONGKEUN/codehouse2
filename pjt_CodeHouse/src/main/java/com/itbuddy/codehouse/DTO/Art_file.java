package com.itbuddy.codehouse.DTO;

public class Art_file {
	Integer art_fil_no;
	String art_fil_url;
	Integer art_no;
	

	public Integer getArt_fil_no() {
		return art_fil_no;
	}
	public void setArt_fil_no(Integer art_fil_no) {
		this.art_fil_no = art_fil_no;
	}
	public String getArt_fil_url() {
		return art_fil_url;
	}
	public void setArt_fil_url(String art_fil_url) {
		this.art_fil_url = art_fil_url;
	}
	public Integer getArt_no() {
		return art_no;
	}
	public void setArt_no(Integer art_no) {
		this.art_no = art_no;
	}
	@Override
	public String toString() {
		return "Art_file [art_fil_no=" + art_fil_no + ", art_fil_url=" + art_fil_url + ", art_no=" + art_no + "]";
	}

}
