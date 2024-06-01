package com.ntrovao.vendas.online.usercase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ntrovao.vendas.online.domain.Produto;
import com.ntrovao.vendas.online.exceptions.EntityNotFoundException;
import com.ntrovao.vendas.online.repository.IProdutoRepository;


@Service
public class BuscaProduto {

	private IProdutoRepository produtoRepository;
	
	public BuscaProduto(IProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Page<Produto> buscar(Pageable pageable) {
		return produtoRepository.findAll(pageable);
	}
	
	public Page<Produto> buscar(Pageable pageable, com.ntrovao.vendas.online.domain.Produto.Status status) {
		return produtoRepository.findAllByStatus(pageable, status);
	}

	public Produto buscarPorCodigo(String codigo) {
		return produtoRepository.findByCodigo(codigo)
				.orElseThrow(() -> new EntityNotFoundException(Produto.class, "codigo", codigo));
	}

	
}