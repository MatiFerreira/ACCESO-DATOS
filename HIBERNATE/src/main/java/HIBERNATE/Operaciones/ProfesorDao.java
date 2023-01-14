package HIBERNATE.Operaciones;

import HIBERNATE.Modelos.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfesorDao implements DAO_PROFESOR {
    Session session;
    Scanner scanner = new Scanner(System.in);
    final String PURPLE = "\u001B[35m";//color purpura lo utilizo para los findall..
    public static final String BLUE = "\u001B[34m";//poner los sout de color azul
    List<UNIVERSIDAD> listaObjetosUni = new ArrayList<UNIVERSIDAD>();

    public ProfesorDao() {

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
    public void UpdateNameProfesor(Integer id, String New_Name) {
        try {
            FactoryStarter();
            session.beginTransaction();
            PROFESOR profesorname = (PROFESOR) session.get(PROFESOR.class, id);
            profesorname.setNombre(New_Name);
            session.update(profesorname);
            session.getTransaction().commit();
            session.close();
            System.out.println("TRANSACCION CORRECTAMENTE ACTUALIZADO");
        } catch (Exception e) {
            System.out.println("ERROR EN LA BBDD");
        }
    }

    @Override
    public void UpdatesurNameProfesor(Integer id, String New_Surname) {
        try {
            FactoryStarter();
            session.beginTransaction();
            PROFESOR profesorname = (PROFESOR) session.get(PROFESOR.class, id);
            profesorname.setApellido(New_Surname);
            session.update(profesorname);
            session.getTransaction().commit();
            session.close();
            System.out.println("TRANSACCION CORRECTAMENTE ACTUALIZADO");
        } catch (Exception e) {
            System.out.println("ERROR EN LA BBDD");
        }
    }

    @Override
    public void UpdateCursoImparteProfesor(Integer id, String New_Curso_Imparte) {
        try {
            FactoryStarter();
            session.beginTransaction();
            PROFESOR profesorname = (PROFESOR) session.get(PROFESOR.class, id);
            profesorname.setAsignatura_imparte(New_Curso_Imparte);
            session.update(profesorname);
            session.getTransaction().commit();
            session.close();
            System.out.println("TRANSACCION CORRECTAMENTE ACTUALIZADO");
        } catch (Exception e) {
            System.out.println("ERROR EN LA BBDD");
        }
    }

    @Override
    public void InsertValuesProfesor(String nombre, String Apellido) {
        try {
            FactoryStarter();
            session.beginTransaction();
            System.out.print("ASIGNATURA QUE IMPARTE?= ");
            String asignatura = scanner.next();
            PROFESOR profesor = new PROFESOR(nombre, Apellido, asignatura);
            System.out.println(BLUE + "INTRODUCE LOS DATOS DE TU NOMINA---->" + BLUE);
            System.out.print(BLUE + "SALARIO MENSUAL: " + BLUE);
            double salario = scanner.nextDouble();
            System.out.print(BLUE + "NUMERO SEGURIDAD SOCIAL (4DIGITOS + 1LETRA): " + BLUE);
            String seguiridad = scanner.next();
            System.out.print("INDIQUE DIRECCION UNIVERSIDAD: ");
            String direccion = scanner.next();
            System.out.print(BLUE + "INDIQUE NOMBRE DE UNIVERSIDAD QUE TRABJA: ");
            String uni = scanner.next();
            UNIVERSIDAD universidadinsertprf = new UNIVERSIDAD(direccion, uni);
            NOMINA nomina = new NOMINA(salario, seguiridad);
            nomina.setProfesor(profesor);
            listaObjetosUni.add(universidadinsertprf);
            profesor.setUniversidadListProfesores(listaObjetosUni);
            profesor.setNomina(nomina);
            universidadinsertprf.setProfesorUni(profesor);
            session.save(profesor);
            System.out.println(BLUE + "SE HA COMPLETADO CORRECTAMENTE LA OPERACION :)" + BLUE);
            session.getTransaction().commit();
            System.out.println("HA SIDO INSERTADO EN LA BASE DE DATOS");
            session.close();
        } catch (Exception e) {
            System.out.println("ERROR EN LA BBDD");
        }
    }

    @Override
    public void DeleteValuesProfesor(Integer id) {
        FactoryStarter();
        session.beginTransaction();
        PROFESOR profeborrar = session.get(PROFESOR.class, id);
        if (profeborrar != null) {
            session.delete(profeborrar);
            System.out.println("Registro borrado en PROFESOR y su NOMINA");
        } else {
            System.out.println("No existe el profesor con id: " + id);
        }
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public void FindAllProfesores() {
        FactoryStarter();
        session.beginTransaction();
        List<PROFESOR> FindAlumnos = session.createQuery("FROM PROFESOR").getResultList();
        for (PROFESOR profesor :
                FindAlumnos) {
            System.out.println(PURPLE + "----------------------------------------------------------------------------------------------------");
            System.out.println(PURPLE + "PROFESOR CON ID: " + profesor.getIdPROFESORES()
                    + " ||NOMBRE: " + profesor.getNombre()
                    + " ||APELLIDO: " + profesor.getApellido()
                    + " ||ASIGNATURA IMPARTE: " + profesor.getAsignatura_imparte());
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
        session.close();
    }

}
