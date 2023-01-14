package HIBERNATE.Operaciones;

import HIBERNATE.Modelos.ALUMNOS;
import HIBERNATE.Modelos.MATRICULA;
import HIBERNATE.Modelos.UNIVERSIDAD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlumnoDao implements DAO_ALUMNOS {
    Session session;
    Scanner scanner = new Scanner(System.in);
    public static final String RED = "\u001B[31m"; //PONER SOUTS DE COLOR ROJO
    public static final String BLUE = "\u001B[34m";//poner los sout de color azul
    final String PURPLE = "\u001B[35m";//color purpura lo utilizo para los findall..
    List<UNIVERSIDAD> listaObjetosUni = new ArrayList<UNIVERSIDAD>();

    public AlumnoDao() {

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
    public void UpdateNameAlumno(Integer id, String New_Name) {
        try {


            FactoryStarter();
            session.beginTransaction();
            ALUMNOS alumnosname = (ALUMNOS) session.get(ALUMNOS.class, id);
            alumnosname.setNOMBRE(New_Name);
            session.update(alumnosname);
            session.getTransaction().commit();
            session.close();
            System.out.println("TRANSACCION CORRECTAMENTE ACTUALIZADO");
        } catch (Exception e) {
            System.out.println("ID NO EXISTE O ERROR EN LA BASE DE DATOS");
        }
    }

    @Override
    public void UpdatesurNameAlumno(Integer id, String New_Surname) {
        try {
            FactoryStarter();
            session.beginTransaction();
            ALUMNOS alumnosname = (ALUMNOS) session.get(ALUMNOS.class, id);
            alumnosname.setAPELLIDO(New_Surname);
            session.update(alumnosname);
            session.getTransaction().commit();
            session.close();
            System.out.println("TRANSACCION CORRECTAMENTE ACTUALIZADO");
        }catch (Exception e){
            System.out.println("Error en la BBDD");
        }
    }

    @Override
    public void UpdateEdadAlumno(Integer id, Integer new_edad) {
        try {
            FactoryStarter();
            session.beginTransaction();
            ALUMNOS alumnosname = (ALUMNOS) session.get(ALUMNOS.class, id);
            alumnosname.setEDAD(new_edad);
            session.update(alumnosname);
            session.getTransaction().commit();
            session.close();
            System.out.println("TRANSACCION CORRECTAMENTE ACTUALIZADO");
        } catch (Exception e) {
            System.out.println("ID NO EXISTE O ERROR EN LA BASE DE DATOS");
        }
    }

    @Override
    public void InsertValuesAlumnos(String nombre, String Apellido) {
        try {
            FactoryStarter();
            session.beginTransaction();
            System.out.print("EDAD? ");
            Integer edad = scanner.nextInt();
            ALUMNOS alumnoNew = new ALUMNOS(nombre, Apellido, edad);
            System.out.println("ALUMNO INSERTADO");
            System.out.println("AHORA INGRESE SUS DATOS DE MATRICULA PORFAVOR");
            System.out.print(RED + "CURSO QUE SE ENCUENTRA: " + RED);
            String curso = scanner.next();
            System.out.print(RED + "PRECIO MATRICULA: " + RED);
            double precio = scanner.nextDouble();
            System.out.print(RED + "INDIQUE NOMBRE UNIVERSIDAD: " + RED);
            String universidad = scanner.next();
            System.out.print(RED + "INDIQUE DIRECCION UNIVERSIDAD: ");
            String direccion = scanner.next();
            UNIVERSIDAD universidadinsert = new UNIVERSIDAD(direccion, universidad);
            MATRICULA matricula = new MATRICULA(universidad, curso, precio);
            matricula.setAlumnosMatriculados(alumnoNew);
            listaObjetosUni.add(universidadinsert);
            alumnoNew.setUniversidadListAlumno(listaObjetosUni);
            alumnoNew.setMatriculaAlumno(matricula);
            universidadinsert.setAlumnosUni(alumnoNew);
            session.save(alumnoNew);
            System.out.println("HA SIDO INSERTADO EN LA BASE DE DATOS");
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println("ERROR EN LA BBDD");
        }
    }

    @Override
    public void DeleteValuesAlumno(Integer id) {
        FactoryStarter();
        session.beginTransaction();
        ALUMNOS aluborrar = session.get(ALUMNOS.class, id);
        if (aluborrar != null) {
            session.delete(aluborrar);
            System.out.println("Registro borrado en cliente y su Matricula");
        } else {
            System.out.println("El cliente no existe");
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void FindAllAlumnos() {
        try {
            FactoryStarter();
            session.beginTransaction();
            List<ALUMNOS> FindAlumnos = session.createQuery("FROM ALUMNOS").getResultList();
            for (ALUMNOS alumnosMostrar :
                    FindAlumnos) {
                System.out.println(PURPLE + "ALUMNO CON ID: " + alumnosMostrar.getID()
                        + " ||NOMBRE: " + alumnosMostrar.getNOMBRE()
                        + " ||APELLIDO: " + alumnosMostrar.getAPELLIDO()
                        + " ||EDAD: " + alumnosMostrar.getEDAD());
            }
            session.close();
        }catch (Exception e){
            System.out.println("ERROR BBDD");
        }
    }

}
