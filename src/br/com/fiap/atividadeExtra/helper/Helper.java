package br.com.fiap.atividadeExtra.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.atividadeExtra.entity.Clientes;
import br.com.fiap.atividadeExtra.entity.Pedidos;

public class Helper {
	private EntityManager em;

	public Helper(EntityManager em){
		this.em = em;
	}

	public void salvar(Object obj) throws Exception { 
		try {
			em.getTransaction().begin(); 
			em.persist(obj); 
			em.getTransaction().commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Clientes> listarClientes(){		
		TypedQuery<Clientes> tQuery = em.createQuery("select c from Clientes c", Clientes.class); 
		return tQuery.getResultList();
	}
	
	public List<Pedidos> listarPedidos(){		
		TypedQuery<Pedidos> tQuery = em.createQuery("select p from Pedidos p", Pedidos.class); 
		return tQuery.getResultList();
	}

	public Clientes buscarClientes(String idcliente){
		TypedQuery<Clientes> tQuery = em.createQuery("select c from Clientes c where idcliente = :idcliente", Clientes.class);
		tQuery.setParameter("idcliente", idcliente); 
		return tQuery.getSingleResult(); 
		
	}

	public Pedidos buscarPedidos(String idPedido){
		TypedQuery<Pedidos> tQuery = em.createQuery("select p from Pedidos p where idPedido = :idPedido", Pedidos.class);
		tQuery.setParameter("idPedido", idPedido); 
		return tQuery.getSingleResult(); 
		
	}
}