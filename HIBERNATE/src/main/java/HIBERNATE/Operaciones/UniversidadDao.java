package HIBERNATE.Operaciones;

import HIBERNATE.Modelos.UNIVERSIDAD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UniversidadDao implements DAO_UNIVERSIDAD {
    Session session;

    public UniversidadDao() {

    }

    /**
     * CREAMOS LA FACTORIA PARA ABRIR SESION EN HIBERNATE CON MYSQL
     */
    private void FactoryStarter() {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml").buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Override
    public void UpdateDireccion(Integer id, String new_Direccion) {
        try {
            FactoryStarter();
            session.beginTransaction();
            UNIVERSIDAD universidad = (UNIVERSIDAD) session.get(UNIVERSIDAD.class, id);
            universidad.setDireccion(new_Direccion);
            session.update(universidad);
            session.getTransaction().commit();
            session.close();
            System.out.println("DIRECCION ACTUALIZADA");
        } catch (Exception e) {
            System.out.println("ERROR EN LA BBDD");
        }
    }

    @Override
    public void UpdateNameUniversidad(Integer id, String new_NameUni) {
        try {
            FactoryStarter();
            session.beginTransaction();
            UNIVERSIDAD universidad = (UNIVERSIDAD) session.get(UNIVERSIDAD.class, id);
            universidad.setNombre_universidad(new_NameUni);
            session.update(universidad);
            session.getTransaction().commit();
            session.close();
            System.out.println("NOMBRE UNIVERSIDAD ACTUALIZADA");
        } catch (Exception e) {
            System.out.println("ERROR EN LA BBDD");
        }
    }
}
