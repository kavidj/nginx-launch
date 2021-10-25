package com.nusyn.hrmate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tbl_user")

public class User {

	private Integer PkBintUserId;

	
	private String VchrUserName;

	
	private String VchrPassword;

	
	private char ChrStatus;

	@Column(name = "pk_bint_user_id")
	@Id
	@GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "sequence")

	})
	@GeneratedValue(generator = "sequence")
	public Integer getPkBintUserId() {
		return PkBintUserId;
	}

	public void setPkBintUserId(Integer pkBintUserId) {
		PkBintUserId = pkBintUserId;
	}
    
	@Column(name = "vchr_user_name")
	public String getVchrUserName() {
		return VchrUserName;
	}

	public void setVchrUserName(String vchrUserName) {
		VchrUserName = vchrUserName;
	}

	@Column(name = "vchr_password")
	public String getVchrPassword() {
		return VchrPassword;
	}

	public void setVchrPassword(String vchrPassword) {
		VchrPassword = vchrPassword;
	}

	@Column(name = "chr_status")
	public char getChrStatus() {
		return ChrStatus;
	}

	public void setChrStatus(char chrStatus) {
		ChrStatus = chrStatus;
	}

}
