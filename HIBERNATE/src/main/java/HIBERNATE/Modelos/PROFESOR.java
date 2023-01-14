package HIBERNATE.Modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PROFESORES")
public class PROFESOR implements Serializable {
    /**
     * CREAMOS UNA CLASE  DONDE SE ENCUENTRA LOS ATRIBUTOS
     * EN ELLA LO RELACIONAMOS CON ANOTACIONES'@' CUAL HIBERNATE SE ENCARGARA DE RELA
     * -CIONAR CADA ATRIBUTO CON CADA COLUMNA DE LA TABLA CON '@COLUMN'
     * EN NUESTRA ANOTACION @ID INDICA LA PK Y ADEMAS CON @GENERATEDVALUE INDICAMOS EL
     * TIPO DE GENERACION DE ID 1,2,3...
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer idPROFESORES;
    /**
     * @Column indica o apunta a la columna  que podemos hacer aqui ,por ejemplo señalamos a que columna hace referencia
     */
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "ASIGNATURA_IMPARTE")
    private String Asignatura_imparte;

    public PROFESOR() {

    }
    /**
     * CONSTRUCTOR DONDE SE LE PASA LOS VALORES AL INTACIAR E HIBERNATE SE ENCARGA DE ENVIAR  ESTOS DATOS A NUESTRO
     * MySQL
     * */
    public PROFESOR(String nombre, String apellido, String Asignatura_imparte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.Asignatura_imparte = Asignatura_imparte;

    }
    /**
     * CREAMOS GETTER Y SETTER PARA DEVOLVER LOS DATOS O INSERTAR DATOS NUEVOS ESTO NOS SERVIRA POR SI QUEREMOS
     * OBTENER ALGUN DATO O MODIFICAR UN DATO DE NUESTRA CLASE
     * */
    public String getAsignatura_imparte() {
        return Asignatura_imparte;
    }

    public void setAsignatura_imparte(String asignatura_imparte) {
        Asignatura_imparte = asignatura_imparte;
    }

    public Integer getIdPROFESORES() {
        return idPROFESORES;
    }

    public void setIdPROFESORES(Integer idPROFESORES) {
        this.idPROFESORES = idPROFESORES;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    @Override
    public String toString() {
        return "PROFESORES{" +
                "id=" + idPROFESORES +
                '}';
    }
    /**
     * HACEMOS UNA RELACION @ONETOONE 1-1 EN ELLA UTILIZAMOS MAPPEDBY QUE MAPEA O RELACIONA
     * EN NUESTRA OTRA CLASE QUE ESTE UNIDA A ESTA,EN ELLA CREAMOS LA CLASE INDICANDO CON QUE
     * CLASE ESTA RELACIONADO Y ESTABLECEMOS UN SETTER POR SI QUEREMOS METER NUEVO DATOS
     * A NUESTRA CLASE QUE ESTA UNIDA A ESTA.
     * */
    @OneToOne(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    public NOMINA nomina;

    public void setNomina(NOMINA nomina) {
        this.nomina = nomina;
    }
    /**
     * CascadeType.ALL: se aplican todos los tipos de cascada.
     * CascadeType.REMOVE: las entidades relacionadas se eliminan de la base de datos cuando la entidad propietaria se elimine.
     * */
    @OneToMany(mappedBy = "profesorUni",cascade = {CascadeType.ALL,CascadeType.REMOVE})
    public List<UNIVERSIDAD> universidadListProfesores;

    public void setUniversidadListProfesores(List<UNIVERSIDAD> universidadListProfesores) {
        this.universidadListProfesores = universidadListProfesores;
    }
}
