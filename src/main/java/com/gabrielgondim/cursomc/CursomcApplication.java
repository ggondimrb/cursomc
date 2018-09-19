package com.gabrielgondim.cursomc;

import java.text.SimpleDateFormat;
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
import com.gabrielgondim.cursomc.domain.ItemPedido;
import com.gabrielgondim.cursomc.domain.Pagamento;
import com.gabrielgondim.cursomc.domain.PagamentoComBoleto;
import com.gabrielgondim.cursomc.domain.PagamentoComCartao;
import com.gabrielgondim.cursomc.domain.Pedido;
import com.gabrielgondim.cursomc.domain.Produto;
import com.gabrielgondim.cursomc.domain.enums.EstadoPagamento;
import com.gabrielgondim.cursomc.domain.enums.TipoCliente;
import com.gabrielgondim.cursomc.repositories.CategoriaRepository;
import com.gabrielgondim.cursomc.repositories.CidadeRepository;
import com.gabrielgondim.cursomc.repositories.ClienteRepository;
import com.gabrielgondim.cursomc.repositories.EnderecoRepository;
import com.gabrielgondim.cursomc.repositories.EstadoRepository;
import com.gabrielgondim.cursomc.repositories.ItemPedidoRepository;
import com.gabrielgondim.cursomc.repositories.PagamentoRepository;
import com.gabrielgondim.cursomc.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritorio");
		Categoria cat3 = new Categoria(null,"Cama Mesa e banho");
		Categoria cat4 = new Categoria(null,"Jardinagem");
		Categoria cat5 = new Categoria(null,"Decoraçao");
		Categoria cat6 = new Categoria(null,"Perfumaria");
		Categoria cat7 = new Categoria(null,"Eletronico");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, end2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2,sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
	}
}
