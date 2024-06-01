package com.ntrovao.vendas.online.usercase;


import org.springframework.stereotype.Service;

import com.ntrovao.vendas.online.domain.Produto;
import com.ntrovao.vendas.online.domain.Produto.Status;
import com.ntrovao.vendas.online.exceptions.EntityNotFoundException;
import com.ntrovao.vendas.online.repository.IProdutoRepository;

import jakarta.validation.Valid;

@Service
public class CadastroProduto {
	
	private IProdutoRepository produtoRepository;
	
	public CadastroProduto(IProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Produto cadastrar(@Valid Produto produto) {
		produto.setStatus(Status.ATIVO);
		return this.produtoRepository.insert(produto);
	}

	public Produto atualizar(@Valid Produto produto) {
		return this.produtoRepository.save(produto);
	}

	public void remover(String id) {
		Produto prod = produtoRepository.findById(id)
		.orElseThrow(() -> new EntityNotFoundException(Produto.class, "id", id));
		prod.setStatus(Status.INATIVO);
		this.produtoRepository.save(prod);
		//this.produtoRepository.deleteById(id);
	}

}