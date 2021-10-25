package com.nusyn.hrmate.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_financial_year")
public class FinancialYear {
	private Integer PkBintFinancialYear;
	private Date DatFinancialYearStart;
	private Date DatFinancialYearEnd;
	private char ChrStatus;

	@Id
	@Column(name="pk_bint_financial_year")
	public Integer getPkBintFinancialYear() {
		return PkBintFinancialYear;
	}

	
	public void setPkBintFinancialYear(int pkBintFinancialYear) {
		PkBintFinancialYear = pkBintFinancialYear;
	}

	@Column(name="dat_financial_year_start")
	public Date getDatFinancialYearStart() {
		return DatFinancialYearStart;
	}

	public void setDatFinancialYearStart(Date datFinancialYearStart) {
		DatFinancialYearStart = datFinancialYearStart;
	}

	@Column(name="dat_financial_year_end")
	public Date getDatFinancialYearEnd() {
		return DatFinancialYearEnd;
	}

	public void setDatFinancialYearEnd(Date datFinancialYearEnd) {
		DatFinancialYearEnd = datFinancialYearEnd;
	}

	
	@Column(name="chr_status")
	public char getChrStatus() {
		return ChrStatus;
	}

	public void setChrStatus(char chrStatus) {
		ChrStatus = chrStatus;
	}

}
