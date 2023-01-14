package HIBERNATE.Manager;

import HIBERNATE.Modelos.UNIVERSIDAD;
import HIBERNATE.Operaciones.*;

import java.util.Scanner;

public class PRUEBA {
    /**
     * MENU POR CONSOLA PARA NUESTRA BASE DE DATOS
     *
     * @author Mathias Ferreira Ferreira
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String BLUE = "\u001B[34m";//poner los sout de color azul
        final String RED = "\u001B[31m"; //PONER SOUTS DE COLOR ROJO
        int eleccion;
        int id;
        double newprecio;
        String newname, newdireccion, newsurname, newcursoimparte, nombre, apellido, newcurso, newseguridadsocial;
        ProfesorDao profesorDao = new ProfesorDao();
        AlumnoDao alumnoDao = new AlumnoDao();
        MatriculaDao matriculaDao = new MatriculaDao();
        NominaDao nominaDao = new NominaDao();
        UniversidadDao universidadDao = new UniversidadDao();
        try {
            do {
                System.out.println("==================================================================================================================================");
                System.out.println(BLUE + "|| BIENVENIDO AL SISTEMA DE BASE DE DATOS ||");
                System.out.println("==================================================================================================================================");
                System.out.println(BLUE + "QUE DESEA HACER :");
                System.out.println(BLUE + "1-TRABAJAR CON PROFESOR | 2-TRABAJAR CON ALUMNOS | 3-MODIFICAR MATRICULA | 4-MODIFICAR NOMINA | 5-MODIFICAR UNIVERSIDAD | 6-SALIR |");
                System.out.print(BLUE + "ELECCION: ");
                eleccion = scanner.nextInt();
                switch (eleccion) {
                    case 1:
                        System.out.println(RED + "AREA PROFESOR QUE DESEA HACER:");
                        System.out.println(RED + "1-ACTUALIZAR NOMBRE | 2-ACTUALIZAR APELLIDO" +
                                " | 3-ACTUALIZAR CURSO QUE IMPARTE | 4-CREAR UN PROFESOR |" +
                                " | 5-MOSTRAR TODOS LOS PROFESORES | 6-ELIMINAR PROFESOR |");
                        System.out.print(RED + "ELECCION: ");
                        int eleccion2 = scanner.nextInt();
                        switch (eleccion2) {
                            case 1:
                                System.out.print("DAME TU CODIGO IDENTIFICADOR: ");
                                id = scanner.nextInt();
                                System.out.print("ESCRIBE EL NUEVO NOMBRE: ");
                                newname = scanner.next();
                                profesorDao.UpdateNameProfesor(id, newname);
                                break;
                            case 2:
                                System.out.print("DAME TU CODIGO IDENTIFICADOR: ");
                                id = scanner.nextInt();
                                System.out.print("ESCRIBE EL NUEVO APELLIDO: ");
                                newsurname = scanner.next();
                                profesorDao.UpdatesurNameProfesor(id, newsurname);
                                break;
                            case 3:
                                System.out.print("DAME TU CODIGO IDENTIFICADOR: ");
                                id = scanner.nextInt();
                                System.out.println("ESCRIBE NUEVO CURSO QUE IMPARTIRA: ");
                                newcursoimparte = scanner.next();
                                profesorDao.UpdateCursoImparteProfesor(id, newcursoimparte);
                                break;
                            case 4:
                                System.out.print("DAME UN NOMBRE: ");
                                nombre = scanner.next();
                                System.out.print("DAME UN APELLIDO: ");
                                apellido = scanner.next();
                                profesorDao.InsertValuesProfesor(nombre, apellido);
                                break;
                            case 5:
                                profesorDao.FindAllProfesores();
                                break;
                            case 6:
                                System.out.print("DAME UN CODIGO IDENTIDICADOR PARA ELIMINAR: ");
                                id = scanner.nextInt();
                                profesorDao.DeleteValuesProfesor(id);
                                break;
                        }
                        break;
                    case 2:
                        System.out.println(RED + "AREA ALUMNO QUE DESEA HACER:");
                        System.out.println(RED + "1-ACTUALIZAR NOMBRE | 2-ACTUALIZAR APELLIDO" +
                                " | 3-ACTUALIZAR CURSO QUE IMPARTE | 4-CREAR UN ALUMNO |" +
                                " | 5-MOSTRAR TODOS LOS ALUMNOS | 6-ELIMINAR ALUMNO |");
                        System.out.print(RED + "ELECCION: ");
                        int elec = scanner.nextInt();
                        switch (elec) {
                            case 1:
                                System.out.print("DAME TU CODIGO IDENTIFICADOR: ");
                                id = scanner.nextInt();
                                System.out.print("ESCRIBE EL NUEVO NOMBRE: ");
                                newname = scanner.next();
                                alumnoDao.UpdateNameAlumno(id, newname);
                                break;
                            case 2:
                                System.out.print("DAME TU CODIGO IDENTIFICADOR: ");
                                id = scanner.nextInt();
                                System.out.print("ESCRIBE EL NUEVO APELLIDO: ");
                                newsurname = scanner.next();
                                alumnoDao.UpdatesurNameAlumno(id, newsurname);
                                break;
                            case 3:
                                System.out.print("DAME TU CODIGO IDENTIFICADOR: ");
                                id = scanner.nextInt();
                                System.out.println("DAME SU NUEVA EDAD ");
                                int newedad = scanner.nextInt();
                                alumnoDao.UpdateEdadAlumno(id, newedad);
                                break;
                            case 4:
                                System.out.print("DAME UN NOMBRE: ");
                                nombre = scanner.next();
                                System.out.print("DAME UN APELLIDO: ");
                                apellido = scanner.next();
                                alumnoDao.InsertValuesAlumnos(nombre, apellido);
                                break;
                            case 5:
                                alumnoDao.FindAllAlumnos();
                                break;
                            case 6:
                                System.out.print("DAME UN CODIGO IDENTIDICADOR PARA ELIMINAR: ");
                                id = scanner.nextInt();
                                alumnoDao.DeleteValuesAlumno(id);
                                break;
                        }
                        break;
                    case 3:
                        System.out.println(RED + "MODIFICAR MATRICULA");
                        System.out.println(RED + "1-ACTUALIZAR PRECIO MATRICULA | " +
                                " 2-ACTUALIZAR CURSO | 3-ACTUALIZAR NOMBRE UNIVERSIDAD |");
                        System.out.print("ELECCION: ");
                        eleccion = scanner.nextInt();
                        switch (eleccion) {
                            case 1:
                                System.out.print("DAME LA ID DE LA MATRICULA: ");
                                id = scanner.nextInt();
                                System.out.print("DAME EL NUEVO PRECIO: ");
                                newprecio = scanner.nextDouble();
                                matriculaDao.UpdatePrecioMatricula(id, newprecio);
                                break;
                            case 2:
                                System.out.print("DAME LA ID DE LA MATRICULA: ");
                                id = scanner.nextInt();
                                System.out.print("DAME EL NUEVO CURSO: ");
                                newcurso = scanner.next();
                                matriculaDao.UpdateCurso(id, newcurso);
                                break;
                            case 3:
                                System.out.print("DAME LA ID DE LA MATRICULA: ");
                                id = scanner.nextInt();
                                System.out.print("DAME EL NOMBRE DE LA NUEVA UNIVERSIDAD: ");
                                newname = scanner.next();
                                matriculaDao.UpdateNameUni(id, newname);
                                break;
                        }
                        break;
                    case 4:
                        System.out.println(RED + "MODIFICAR NOMINA");
                        System.out.println(RED + "1-ACTUALIZAR SALARIO | 2-ACTUALIZAR SEGUIRIDAD SOCIAL |" +
                                " 3-MOSTRAR UNA NOMINA ESPECIFICA |");
                        System.out.print("ELECCION: ");
                        eleccion = scanner.nextInt();
                        switch (eleccion) {
                            case 1:
                                System.out.print("DAME EL IDENTIFICADOR DE LA NOMINA: ");
                                id = scanner.nextInt();
                                System.out.print("DAME EL NUEVO SALARIO: ");
                                newprecio = scanner.nextDouble();
                                nominaDao.UpdateSalario(id, newprecio);
                                break;
                            case 2:
                                System.out.print("DAME EL IDENTIFICADOR DE LA NOMINA: ");
                                id = scanner.nextInt();
                                System.out.print("DAME NUEVA COMBINACION DE SEGURIDAD SOCIAL: ");
                                newseguridadsocial = scanner.next();
                                nominaDao.UpdateSeguridadsocial(id, newseguridadsocial);
                                break;
                            case 3:
                                System.out.print("DAME EL IDENTIFICADOR DE LA NOMINA: ");
                                id = scanner.nextInt();
                                nominaDao.FindAllNomina(id);
                        }
                        break;
                    case 5:
                        System.out.println(RED + "MODIFICAR UNIVERSIDAD");
                        System.out.println(RED + "1-ACTUALIZAR DIRECCION | 2-ACTUALIZAR NOMBRE UNIVERSIDAD |");
                        System.out.print("ELECCION: ");
                        eleccion = scanner.nextInt();
                        switch (eleccion) {
                            case 1:
                                System.out.print("DAME EL ID DE LA UNIVERSIDAD: ");
                                id = scanner.nextInt();
                                System.out.print("DAME LA NUEVA DIRECCION: ");
                                newdireccion = scanner.next();
                                universidadDao.UpdateDireccion(id, newdireccion);
                                break;
                            case 2:
                                System.out.print("DAME EL ID DE LA UNIVERSIDAD: ");
                                id = scanner.nextInt();
                                System.out.print("DAME EL NUEVO NOMBRE DE LA UNIVERSIDAD: ");
                                newname = scanner.next();
                                universidadDao.UpdateNameUniversidad(id, newname);
                                break;
                        }
                        break;
                }
            } while (eleccion != 6);

        } catch (Exception m) {
            System.out.println("_________________________________________________");
            System.out.println(BLUE+"ERROR EN LA BASE DE DATOS");
            System.out.println("_________________________________________________");
            System.out.print("MOTIVOS: ");
            System.out.println(BLUE+"1-ID NO EXISTE 2-TIPO DE VALOR NO VALIDO 3-SERVIDOR CAIDO");
            System.out.println("¡REINTENTALO DE NUEVO!");
        }
    }
}