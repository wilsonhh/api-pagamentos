package br.com.firstdatacorp.apipagamentos.service;

import java.util.Date;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.firstdatacorp.apipagamentos.model.ApiPagamentos;

@Service
public class ApiPagamentosService {
	

	
	
	public ApiPagamentos findByParametro1AndParametro2(String parametro1, String parametro2) {
		ApiPagamentos api = new ApiPagamentos();
		api.setId(1L);
		api.setMerchantId("99999");
		api.setNumeroInstituicao("00000003");
		api.setRecordDate(new Date());
		api.setStatus(true);
	
		return api;
	}
}
		

