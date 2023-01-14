package HIBERNATE.Modelos;

import javax.persistence.*;

@Entity
@Table (name = "nomina")
public class NOMINA {
    /**
     * CREAMOS UNA CLASE  DONDE SE ENCUENTRA LOS ATRIBUTOS
     * EN ELLA LO RELACIONAMOS CON ANOTACIONES'@' CUAL HIBERNATE SE ENCARGARA DE RELA
     * -CIONAR CADA ATRIBUTO CON CADA COLUMNA DE LA TABLA CON '@COLUMN'
     * EN NUESTRA ANOTACION @ID INDICA LA PK Y ADEMAS CON @GENERATEDVALUE INDICAMOS EL
     * TIPO DE GENERACION DE ID 1,2,3...
     * */
    @Id
    @Column (name = "id_nomina")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id_nomina;
    /**
     * @Column indica o apunta a la columna  que podemos hacer aqui ,por ejemplo señalamos a que columna hace referencia
     */
    @Column (name = "salario")
    private double salario;
    @Column (name = "seguridad_social")
    private String seguridad_social;

    public NOMINA(){

    }
    /**
     * CONSTRUCTOR DONDE SE LE PASA LOS VALORES AL INTACIAR E HIBERNATE SE ENCARGA DE ENVIAR  ESTOS DATOS A NUESTRO
     * MySQL
     * */
    public NOMINA(double salario,String seguridad_social){
        this.salario = salario;
        this.seguridad_social = seguridad_social;
    }
    /**
     * CREAMOS GETTER Y SETTER PARA DEVOLVER LOS DATOS O INSERTAR DATOS NUEVOS ESTO NOS SERVIRA POR SI QUEREMOS
     * OBTENER ALGUN DATO O MODIFICAR UN DATO DE NUESTRA CLASE
     * */
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSeguridad_social() {
        return seguridad_social;
    }

    public void setSeguridad_social(String seguridad_social) {
        this.seguridad_social = seguridad_social;
    }

    public Integer getId_nomina() {
        return id_nomina;
    }

    @JoinColumn (name = "id_profesor")
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE})
    private PROFESOR profesor;

    public void setProfesor(PROFESOR profesor) {
        this.profesor = profesor;
    }
}
