package br.com.firstdatacorp.apipagamentos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.firstdatacorp.apipagamentos.vo.ApiPagamentosVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="apipagamentos")
@ApiModel
public class ApiPagamentos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ApiPagamentos(ApiPagamentosVO vo) {
		super();
		this.numeroInstituicao = vo.getNumeroInstituicao();
		this.merchantId = vo.getMerchantId();
		this.recordDate = vo.getRecordDate();
		this.status = vo.getStatus();
	}
	
	public ApiPagamentos() {
		super();
	}
	
	@Id
	@Column(name="ID")
	@ApiModelProperty(dataType="java.lang.Long", required=true, name="id", value="Id da entidade")
	private Long id;
	
	@Column(name="RECORD_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(dataType="java.util.Date", required=true, name="recordDate", value="Data de gravação do registro formato dd/MM/yyyy")
	private Date recordDate;
	
	@Column(name="NUMERO_INSTITUICAO")
	@ApiModelProperty(dataType="java.lang.String", required=true, name="numeroInstituicao", value="Número da instituição")
	private String numeroInstituicao;
	
	@Column(name="MERCHANT_ID")
	@ApiModelProperty(dataType="java.lang.String", required=true, name="merchantId", value="Número do merchant")
	private String merchantId;
	
	@Column(name="STATUS")
	@ApiModelProperty(dataType="java.lang.Boolean", required=true, name="status", value="Status do merchant")
	private Boolean status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
