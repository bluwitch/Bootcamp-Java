
public class Project {
    private String nombre;
    private String descripcion;
    private Double cost;

    public Project() {
    }

    public Project(String nombre) {
        this.nombre = nombre;
    }

    public Project(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Project(String nombre, Double cost, String descripcion) {
        this.nombre = nombre;
        this.cost = cost;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String elevatorPitch() {
        return nombre + "(" + cost + ")" + ":" + descripcion;
    }
}