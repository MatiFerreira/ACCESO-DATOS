package HIBERNATE.Operaciones;

public interface DAO_ALUMNOS {
    public void UpdateNameAlumno(Integer id, String New_Name);

    public void UpdatesurNameAlumno(Integer id, String New_Surname);

    public void UpdateEdadAlumno(Integer id, Integer new_edad);

    public void InsertValuesAlumnos(String nombre, String Apellido);

    public void DeleteValuesAlumno(Integer id);

    public void FindAllAlumnos();
}
