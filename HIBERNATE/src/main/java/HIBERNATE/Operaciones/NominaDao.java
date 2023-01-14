package HIBERNATE.Operaciones;

import HIBERNATE.Modelos.NOMINA;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class NominaDao implements DAO_NOMINA {
    Session session;
    final String PURPLE = "\u001B[35m";//color purpura lo utilizo para los findall..
    public NominaDao() {

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
    public void UpdateSalario(Integer id, double new_salario) {
        try {
            FactoryStarter();
            session.beginTransaction();
            NOMINA nomina = (NOMINA) session.get(NOMINA.class, id);
            nomina.setSalario(new_salario);
            session.update(nomina);
            session.getTransaction().commit();
            session.close();
            System.out.println("NUEVO SALARIO ACTUALIZADO");
        } catch (Exception e) {
            System.out.println("ERROR EN LA BBDD");
        }
    }

    @Override
    public void UpdateSeguridadsocial(Integer id, String new_SeguridadSocial) {
        try {
            FactoryStarter();
            session.beginTransaction();
            NOMINA nomina = (NOMINA) session.get(NOMINA.class, id);
            nomina.setSeguridad_social(new_SeguridadSocial);
            session.update(nomina);
            session.getTransaction().commit();
            session.close();
            System.out.println("NUEVA SEGURIDAD SOCIAL ACTUALIZADO");
        } catch (Exception e) {
            System.out.println("ERROR EN LA BBDD");
        }
    }


    @Override
    public String FindAllNomina(Integer id) {
        FactoryStarter();
        session.beginTransaction();
        List<NOMINA> nominaList = session.createQuery("FROM NOMINA ").getResultList();
        for (NOMINA nominalista : nominaList) {
            if (nominalista.getId_nomina() == id) {
                System.out.println(PURPLE + "SALARIO: " + nominalista.getSalario()
                        + "€  SEGURIDAD SOCIAL: " + nominalista.getSeguridad_social());
            }

        }
        return null;
    }
}
