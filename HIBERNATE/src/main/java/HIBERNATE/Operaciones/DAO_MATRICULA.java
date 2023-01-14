package HIBERNATE.Operaciones;

public interface DAO_MATRICULA {
    public void UpdatePrecioMatricula(Integer id,double new_Precio);
    public void UpdateCurso(Integer id,String new_Curso);
    public void UpdateNameUni(Integer id,String new_NameUni);
}
