package HIBERNATE.Modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "universidad")
public class UNIVERSIDAD implements Serializable {
    /**
     * CREAMOS UNA CLASE  DONDE SE ENCUENTRA LOS ATRIBUTOS
     * EN ELLA LO RELACIONAMOS CON ANOTACIONES'@' CUAL HIBERNATE SE ENCARGARA DE RELA
     * -CIONAR CADA ATRIBUTO CON CADA COLUMNA DE LA TABLA CON '@COLUMN'
     * EN NUESTRA ANOTACION @ID INDICA LA PK Y ADEMAS CON @GENERATEDVALUE INDICAMOS EL
     * TIPO DE GENERACION DE ID 1,2,3...
     * */

    @Id
    @Column(name = "id_universidad")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_universidad;
    /**
     * @Column indica o apunta a la columna  que podemos hacer aqui ,por ejemplo señalamos a que columna hace referencia
     */
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "nombre_universidad")
    private String nombre_universidad;

    public UNIVERSIDAD() {

    }
    /**
     * CONSTRUCTOR DONDE SE LE PASA LOS VALORES AL INTACIAR E HIBERNATE SE ENCARGA DE ENVIAR  ESTOS DATOS A NUESTRO
     * MySQL
     * */
    public UNIVERSIDAD(String direccion, String nombre_universidad) {
        this.direccion = direccion;
        this.nombre_universidad = nombre_universidad;
    }
    /**
     * CREAMOS GETTER Y SETTER PARA DEVOLVER LOS DATOS O INSERTAR DATOS NUEVOS ESTO NOS SERVIRA POR SI QUEREMOS
     * OBTENER ALGUN DATO O MODIFICAR UN DATO DE NUESTRA CLASE
     * */
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_universidad() {
        return nombre_universidad;
    }

    public void setNombre_universidad(String nombre_universidad) {
        this.nombre_universidad = nombre_universidad;
    }
    /**
     * CascadeType.ALL: se aplican todos los tipos de cascada.
     * */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_alumno")
    public ALUMNOS alumnosUni;

    public void setAlumnosUni(ALUMNOS alumnosUni) {
        this.alumnosUni = alumnosUni;
    }
    /**
     * CascadeType.ALL: se aplican todos los tipos de cascada.
     * */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_profesor")
    public PROFESOR profesorUni;

    public void setProfesorUni(PROFESOR profesorUni) {
        this.profesorUni = profesorUni;
    }
}
