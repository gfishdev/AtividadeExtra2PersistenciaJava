package br.com.fiap.atividadeExtra;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.atividadeExtra.entity.Clientes;
import br.com.fiap.atividadeExtra.entity.Pedidos;
import br.com.fiap.atividadeExtra.helper.Helper;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_Atividade");
		EntityManager em = emf.createEntityManager();
		
		incluirCliente(em);
		
	}
	
	private static void incluirCliente(EntityManager em){
		Pedidos pedido = new Pedidos();
		pedido.setDescricao("CIHCICHICH");
		pedido.setValor(9000.00);
		pedido.setData(new Date());
		
		Helper dao = new Helper(em);
		Clientes cliente = new Clientes();
		cliente.setNome("Chico Butico");
		cliente.setEmail("teste@atarde");
		cliente.getPedidos().add(pedido);
		pedido.setCliente(cliente);
		try {
			dao.salvar(cliente);
			System.out.println("Cliente OK");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
