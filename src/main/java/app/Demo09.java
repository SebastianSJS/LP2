package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

// GUI

public class Demo09 {
	// Listado de los Usuarios segun un criterio (filtro)
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios --> Lista
		int xtipo = 2;
		String jpql = "select u from Usuario u where u.idtipo = :xtipo";
		List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).
				setParameter("xtipo", xtipo).getResultList();
		
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
