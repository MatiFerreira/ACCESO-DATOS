package HIBERNATE.Modelos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "matricula")
public class MATRICULA implements Serializable {
    /**
     * CREAMOS UNA CLASE  DONDE SE ENCUENTRA LOS ATRIBUTOS
     * EN ELLA LO RELACIONAMOS CON ANOTACIONES'@' CUAL HIBERNATE SE ENCARGARA DE RELA
     * -CIONAR CADA ATRIBUTO CON CADA COLUMNA DE LA TABLA CON '@COLUMN'
     * EN NUESTRA ANOTACION @ID INDICA LA PK Y ADEMAS CON @GENERATEDVALUE INDICAMOS EL
     * TIPO DE GENERACION DE ID 1,2,3...
     * */
    @Id
    @Column( name = "id_matricula")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id_matricula;
    /**
     * @Column indica o apunta a la columna  que podemos hacer aqui ,por ejemplo señalamos a que columna hace referencia
     */
    @Column (name = "universidad")
    private String universidad;
    @Column (name = "precio_matricula")
    private double precio_matricula;
    @Column (name = "Curso_imparte")
    private String curso_imparte;

    public MATRICULA(){

    }
    /**
     * CONSTRUCTOR DONDE SE LE PASA LOS VALORES AL INTACIAR E HIBERNATE SE ENCARGA DE ENVIAR  ESTOS DATOS A NUESTRO
     * MySQL
     * */
    public MATRICULA(String universidad,String curso_imparte,double precio_matricula){
        this.curso_imparte = curso_imparte;
        this.precio_matricula = precio_matricula;
        this.universidad = universidad;
    }
    /**
     * CREAMOS GETTER Y SETTER PARA DEVOLVER LOS DATOS O INSERTAR DATOS NUEVOS ESTO NOS SERVIRA POR SI QUEREMOS
     * OBTENER ALGUN DATO O MODIFICAR UN DATO DE NUESTRA CLASE
     * */
    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public double getPrecio_matricula() {
        return precio_matricula;
    }

    public void setPrecio_matricula(double precio_matricula) {
        this.precio_matricula = precio_matricula;
    }

    public String getCurso_imparte() {
        return curso_imparte;
    }

    public void setCurso_imparte(String curso_imparte) {
        this.curso_imparte = curso_imparte;
    }
    @JoinColumn (name = "id_alumno")
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE})
    public ALUMNOS alumnosMatriculados;

    public void setAlumnosMatriculados(ALUMNOS alumnosMatriculados) {
        this.alumnosMatriculados = alumnosMatriculados;
    }


}
