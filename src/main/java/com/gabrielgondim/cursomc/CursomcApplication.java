package com.gabrielgondim.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabrielgondim.cursomc.domain.Categoria;
import com.gabrielgondim.cursomc.domain.Cidade;
import com.gabrielgondim.cursomc.domain.Cliente;
import com.gabrielgondim.cursomc.domain.Endereco;
import com.gabrielgondim.cursomc.domain.Estado;
import com.gabrielgondim.cursomc.domain.Produto;
import com.gabrielgondim.cursomc.domain.enums.TipoCliente;
import com.gabrielgondim.cursomc.repositories.CategoriaRepository;
import com.gabrielgondim.cursomc.repositories.CidadeRepository;
import com.gabrielgondim.cursomc.repositories.ClienteRepository;
import com.gabrielgondim.cursomc.repositories.EnderecoRepository;
import com.gabrielgondim.cursomc.repositories.EstadoRepository;
import com.gabrielgondim.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado e1 = new Estado(null,"Pernambuco");
		Estado e2 = new Estado(null,"Paraiba");
		
		
		Cidade c1 = new Cidade(null,"Recife",e1);
		Cidade c2 = new Cidade(null,"Olinda",e1);
		Cidade c3 = new Cidade(null,"Joao Pessoa",e2);
		
		e1.getCidades().addAll(Arrays.asList(c1,c2));
		e2.getCidades().addAll(Arrays.asList(c3));
		
		estadoRepository.saveAll(Arrays.asList(e1,e2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "3637453432", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("38345421","30904567"));
		
		Endereco end1 = new Endereco(null, "Rua Flores","300","Apt 303", "Jardim", "3455643", cli1, c1);
		Endereco end2 = new Endereco(null, "Avenida Matos","290","Apt 101", "Floresta", "35423", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		
	}
}
