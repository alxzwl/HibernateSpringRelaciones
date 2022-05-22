package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)

				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			Cliente cliente1 = new Cliente("Sandra", "Delgado", "Golla");
			DetallesCliente detalleCliente1 = new DetallesCliente("ElXinoby.com", "5566778899",
					"Soy el mejor programador en Java");

			// Asociar los objetos
			cliente1.setDetallesCliente(detalleCliente1);

			miSession.beginTransaction();
			miSession.save(cliente1);
			miSession.getTransaction().commit();
			System.out.println("Registro incertado de forma exitosa en la BBDD");

			miSession.close();
		} finally {
			miFactory.close();
		}
	}

}
