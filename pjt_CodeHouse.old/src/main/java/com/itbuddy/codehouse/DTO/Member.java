package com.itbuddy.codehouse.DTO;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author skvud
 *
 */
public class Member {
	
	String mem_id;
	String mem_pw;
	String mem_nickname;
	String mem_email;
	String mem_img;
	boolean mem_enabled;
	Collection<? extends GrantedAuthority> mem_typ_type;
	
	public boolean isMem_enabled() {
		return mem_enabled;
	}
	public void setMem_enabled(boolean mem_enabled) {
		this.mem_enabled = mem_enabled;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_img() {
		return mem_img;
	}
	public void setMem_img(String mem_img) {
		this.mem_img = mem_img;
	}
	public Collection<? extends GrantedAuthority> getMem_typ_type() {
		return mem_typ_type;
	}
	public void setMem_typ_type(Collection<? extends GrantedAuthority> mem_typ_type) {
		this.mem_typ_type = mem_typ_type;
	}
	@Override
	public String toString() {
		return "Member [mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", mem_nickname=" + mem_nickname + ", mem_email="
				+ mem_email + ", mem_img=" + mem_img + ", mem_enabled=" + mem_enabled + ", mem_typ_type=" + mem_typ_type
				+ "]";
	}

	
	


}
