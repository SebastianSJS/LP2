package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

// GUI

public class Demo07 {
	// Listado de todos los Usuarios
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios --> Lista
		String jpql = "select p from Producto p";
		List<Producto> lstProductos = em.createQuery(jpql, Producto.class).getResultList();
		
		// motrar el contenido del resultado
		for (Producto p : lstProductos) {
			System.out.println("Codigo.....: " + p.getId_prod());
			System.out.println("Nombre.....: " + p.getDes_prod());
			System.out.println("Categoria.....: " + p.getObjCategoria().getDescripcion());
			System.out.println("proveedor.....: " + p.getObjProveedor().getNombre_rs());
			System.out.println("-----------------------------");

		}
		
		em.close();
		
	}
	
}
