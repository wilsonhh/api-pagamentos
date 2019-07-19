package br.com.firstdatacorp.apipagamentos.resource;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.firstdatacorp.apipagamentos.model.ApiPagamentos;
import br.com.firstdatacorp.apipagamentos.service.ApiPagamentosService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/resources/v1")
public class ApiPagamentosResource {
	
	@Autowired
	ApiPagamentosService service;
	
	private static final Logger LOGGER = Logger.getLogger(ApiPagamentosResource.class.getName());
	
	
	@ApiResponses({@ApiResponse(code = 200, message = "Success", response = ApiPagamentos.class)})
	@RequestMapping(value="/{numeroInstituicao}/{merchantId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByParametro1AndParametro2(
			@ApiParam(value="numeroInstituica1", name="numeroInstituicao", required=true) @PathVariable("numeroInstituicao") String numeroInstituicao,
			@ApiParam(value="merchantId", name="merchantId", required=true) @PathVariable(value="merchantId") String merchantId) {
		
		ApiPagamentos api = null;
		
		LOGGER.log(Level.INFO, "Inicio Consulta por Instituicao 1 e merchant");
		
		try {
			
			api = service.findByParametro1AndParametro2(merchantId, numeroInstituicao);
			
			LOGGER.log(Level.INFO, "Inicio Consulta por Parametro 1 e parametro 2");
			
			return new ResponseEntity<ApiPagamentos>(api, HttpStatus.OK); 
			
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	
	}
}
