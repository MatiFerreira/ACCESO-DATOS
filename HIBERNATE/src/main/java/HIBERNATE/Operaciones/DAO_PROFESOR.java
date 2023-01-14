package HIBERNATE.Operaciones;

public interface DAO_PROFESOR {
    public void UpdateNameProfesor(Integer id, String New_Name);

    public void UpdatesurNameProfesor(Integer id, String New_Surname);

    public void UpdateCursoImparteProfesor(Integer id, String New_Curso_Imparte);

    public void InsertValuesProfesor(String nombre, String Apellido);

    public void DeleteValuesProfesor(Integer id);

    public void FindAllProfesores();
}
