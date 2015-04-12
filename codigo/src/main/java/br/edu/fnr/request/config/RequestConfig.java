package br.edu.fnr.request.config;

import br.gov.frameworkdemoiselle.annotation.Name;
import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(resource = "request")
public class RequestConfig {

	@Name("capacidade.produto")
	private int capacidadeProduto;
	
	public int getCapacidadePedido(){
		return capacidadeProduto;
	}

}
