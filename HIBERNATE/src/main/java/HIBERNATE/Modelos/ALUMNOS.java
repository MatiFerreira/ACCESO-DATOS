package HIBERNATE.Modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "alumnos")
public class ALUMNOS implements Serializable {
    /**
     * CREAMOS UNA CLASE  DONDE SE ENCUENTRA LOS ATRIBUTOS
     * EN ELLA LO RELACIONAMOS CON ANOTACIONES'@' CUAL HIBERNATE SE ENCARGARA DE RELA
     * -CIONAR CADA ATRIBUTO CON CADA COLUMNA DE LA TABLA CON '@COLUMN'
     * EN NUESTRA ANOTACION @ID INDICA LA PK Y ADEMAS CON @GENERATEDVALUE INDICAMOS EL
     * TIPO DE GENERACION DE ID 1,2,3...
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @Basic(optional = false) //ESTO HACE QUE AL SELECCIONAR NO SE VEA EL VALOR ID LO OCULTA
    private Integer ID;
    /**
     * @Column indica o apunta a la columna  que podemos hacer aqui ,por ejemplo señalamos a que columna hace referencia
     */
    @Column(name = "NOMBRE")
    private String NOMBRE;
    @Column(name = "APELLIDO")
    private String APELLIDO;
    @Column(name = "EDAD")
    private Integer EDAD;

    public ALUMNOS() {

    }
/**
 * CONSTRUCTOR DONDE SE LE PASA LOS VALORES AL INTACIAR E HIBERNATE SE ENCARGA DE ENVIAR  ESTOS DATOS A NUESTRO
 * MySQL
 * */
    public ALUMNOS(String NOMBRE, String APELLIDO, Integer EDAD) {
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
        this.EDAD = EDAD;
    }
/**
 * CREAMOS GETTER Y SETTER PARA DEVOLVER LOS DATOS O INSERTAR DATOS NUEVOS ESTO NOS SERVIRA POR SI QUEREMOS
 * OBTENER ALGUN DATO O MODIFICAR UN DATO DE NUESTRA CLASE
 * */
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public Integer getEDAD() {
        return EDAD;
    }

    public void setEDAD(Integer EDAD) {
        this.EDAD = EDAD;
    }

    /**
     * HACEMOS UNA RELACION @ONETOONE 1-1 EN ELLA UTILIZAMOS MAPPEDBY QUE MAPEA O RELACIONA
     * EN NUESTRA OTRA CLASE QUE ESTE UNIDA A ESTA,EN ELLA CREAMOS LA CLASE INDICANDO CON QUE
     * CLASE ESTA RELACIONADO Y ESTABLECEMOS UN SETTER POR SI QUEREMOS METER NUEVO DATOS
     * A NUESTRA CLASE QUE ESTA UNIDA A ESTA.
     * */

    @OneToOne(mappedBy = "alumnosMatriculados", cascade={CascadeType.ALL})
    public MATRICULA matriculaAlumno;

    public void setMatriculaAlumno(MATRICULA matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }
/**
 * EN ESTA RELACION @ONETOMANY 1-N NO ENCARGAMOS DE MAPEAR CON LA CLASE QUE ESTE UNIDO
 * Y EN ELLA CREAMOS UNA LISTA YA QUE TIENE ESTE TIPO DE RELACION TIENE VARIOS DATOS DE UN
 * MISMO TIPO ,METEMOS TAMBIEN UN SETTER PARA ESTABLECER NUESTRA TABLA RELACIONADA
 * CascadeType.ALL: se aplican todos los tipos de cascada.
 * */


    @OneToMany(mappedBy = "alumnosUni",cascade = {CascadeType.ALL})
    public List<UNIVERSIDAD> universidadListAlumno;

    public void setUniversidadListAlumno(List<UNIVERSIDAD> universidadListAlumno) {
        this.universidadListAlumno = universidadListAlumno;
    }
}
