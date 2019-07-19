package br.com.firstdatacorp.apipagamentos.vo;

import java.io.Serializable;
import java.util.Date;

import br.com.firstdatacorp.apipagamentos.model.ApiPagamentos;

public class ApiPagamentosVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ApiPagamentosVO (ApiPagamentos entity) {
		super();
		this.numeroInstituicao = entity.getNumeroInstituicao();
		this.merchantId = entity.getMerchantId();
		this.recordDate = entity.getRecordDate();
		this.status = entity.getStatus();
	}
	
	public ApiPagamentosVO () {
		super();
	}
	
	private Date recordDate;
	
	private String numeroInstituicao;
	
	private String merchantId;
	
	private Boolean status;
	
	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getNumeroInstituicao() {
		return numeroInstituicao;
	}

	public void setNumeroInstituicao(String numeroInstituicao) {
		this.numeroInstituicao = numeroInstituicao;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
