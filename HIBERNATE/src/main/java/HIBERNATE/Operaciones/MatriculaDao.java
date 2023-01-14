package HIBERNATE.Operaciones;

import HIBERNATE.Modelos.MATRICULA;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MatriculaDao implements DAO_MATRICULA {
    Session session;

    public MatriculaDao() {

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
    public void UpdatePrecioMatricula(Integer id, double new_Precio) {
        try {
            FactoryStarter();
            session.beginTransaction();
            MATRICULA matricula = (MATRICULA) session.get(MATRICULA.class, id);
            matricula.setPrecio_matricula(new_Precio);
            session.update(matricula);
            session.getTransaction().commit();
            session.close();
            System.out.println("TRANSACCION CORRECTAMENTE ACTUALIZADO");
        } catch (Exception e) {
            System.out.println("ERROR EN LA BBDD");
        }
    }

    @Override
    public void UpdateCurso(Integer id, String new_Curso) {
        try {
            FactoryStarter();
            session.beginTransaction();
            MATRICULA matricula = (MATRICULA) session.get(MATRICULA.class, id);
            matricula.setCurso_imparte(new_Curso);
            session.update(matricula);
            session.getTransaction().commit();
            session.close();
            System.out.println("TRANSACCION CORRECTAMENTE ACTUALIZADO");
        } catch (Exception e) {
            System.out.println("ERROR EN LA BBDD");
        }
    }

    @Override
    public void UpdateNameUni(Integer id, String new_NameUni) {
        try {
            FactoryStarter();
            session.beginTransaction();
            MATRICULA matricula = (MATRICULA) session.get(MATRICULA.class, id);
            matricula.setUniversidad(new_NameUni);
            session.update(matricula);
            session.getTransaction().commit();
            session.close();
            System.out.println("TRANSACCION CORRECTAMENTE ACTUALIZADO");
        } catch (Exception e) {
            System.out.println("ERROR EN LA BBDD");
        }
    }
}
