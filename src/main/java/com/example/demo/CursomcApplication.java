package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Produto;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.CidadeRepository;
import com.example.demo.repository.EstadoRepository;
import com.example.demo.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository repo;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
 
	@Override
 public void run(String... args) throws Exception{
	 Categoria cat1 = new Categoria(null, "informatica");
	 Categoria cat2 = new Categoria(null, "escritorio");
	 
	 Produto p1 = new Produto(null, "computador", 2000.00);
	 Produto p2 = new Produto(null, "impressora", 800.00);
	 Produto p3 = new Produto(null, "mouse", 20.00);
	 
	 cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
	 cat2.getProdutos().addAll(Arrays.asList(p2));
	 
	 p1.getCategorias().addAll(Arrays.asList(cat1));
	 p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
	 p3.getCategorias().addAll(Arrays.asList(cat1));
	 
	 repo.saveAll(Arrays.asList(cat1, cat2));
	 produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	 
	 Estado est1 = new Estado(null, "Minas Gerais");
	 Estado est2 = new Estado(null, "São paulo");
	 
	 Cidade c1 = new Cidade(null, "Uberlandia", est1);
	 Cidade c2 = new Cidade(null,"São Paulo", est2);
	 Cidade c3 = new Cidade(null, "Campinas", est2);
	 
	 est1.getCidades().addAll(Arrays.asList(c1)); 
	 est2.getCidades().addAll(Arrays.asList(c2,c3)); 
	 
	 estadoRepository.saveAll(Arrays.asList(est1, est2));
	 cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
	
}
}