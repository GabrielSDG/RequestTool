package br.edu.fnr.request.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.stereotype.Controller;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.edu.fnr.request.config.RequestConfig;
import br.edu.fnr.request.entity.Produto;
import br.edu.fnr.request.exception.PedidoException;

@Controller
public class Pedido {

	private List<Produto> produtos = new ArrayList<Produto>();
	
	@Inject
	private Logger logger;
	
	@Inject
	private ResourceBundle bundle;
	
	@Inject
	private RequestConfig config;
	
	public void adicionarProduto(Produto produto, int quantidade){
		if ( estaProduto(produto) || produtos.size() ==  config.getCapacidadePedido() ) {
			throw new PedidoException();
		}
		produtos.add(produto);
		logger.info(bundle.getString("adicionarProduto.sucesso", produto.getProduto()));
	}
	
	public boolean estaProduto(Produto produto){
		return produtos.contains(produto);
	}
	
	@ExceptionHandler
	public void tratar(PedidoException e){
		logger.warn(bundle.getString("adicionarProduto.erro"));
		throw e;
	}

}