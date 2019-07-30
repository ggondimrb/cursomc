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
	

	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
	}
}
