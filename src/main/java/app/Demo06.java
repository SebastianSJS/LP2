package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

// GUI

public class Demo06 {
	// Listado de todos los Usuarios
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios --> Lista
		String jpql = "select u from Usuario u";
		List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).getResultList();
		
		// motrar el contenido del resultado
		for (Usuario u : lstUsuarios) {
			System.out.println("Codigo.....: " + u.getCod_usua());
			System.out.println("Nombre.....: " + u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo.....: " + u.getIdtipo() + "-" + u.getObjTipo().getDescripcion());
			System.out.println("-----------------------------");

		}
		
		em.close();
		
	}
	
}
