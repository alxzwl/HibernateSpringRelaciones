package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class).buildSessionFactory();

		Session miSession = miFactory.openSession();
		try {
			// Asociar los objetos
			miSession.beginTransaction();

			Cliente miCliente = miSession.get(Cliente.class, 2);
			if (miCliente != null) {
				System.out.println("Voy a eliminar al cliente " + miCliente.getNombre());
				miSession.delete(miCliente);
			}
			miSession.getTransaction().commit();
			if (miCliente != null) {
				System.out.println("Registro eliminado de forma exitosa en la BBDD");
			} else {
				System.out.println("Cliente no encontrado en BBDD");
			}
			miSession.close();
		} finally {
			miFactory.close();
		}
	}

}
