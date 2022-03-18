package presencial.modelo;

public class Odontologo {
    private String nombre;
    private String apellido;
    private Integer numeroMatricula;
    private Integer id;

    public Odontologo(String nombre, String apellido, Integer numeroMatricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroMatricula = numeroMatricula;
    }

    public Odontologo(String nombre, String apellido, Integer numeroMatricula, Integer id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroMatricula = numeroMatricula;
        this.id = id;
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

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroMatricula=" + numeroMatricula +
                ", id=" + id +
                '}';
    }
}
