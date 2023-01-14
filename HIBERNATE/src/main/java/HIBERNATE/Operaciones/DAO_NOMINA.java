package HIBERNATE.Operaciones;

public interface DAO_NOMINA {
    public void UpdateSalario(Integer id,double new_salario);
    public void UpdateSeguridadsocial(Integer id,String new_SeguridadSocial);

    public String FindAllNomina(Integer id);

}
