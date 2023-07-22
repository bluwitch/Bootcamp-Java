import java.util.ArrayList;

public class ProjectTest {
    public static void main(String[] args) {
        Project proyecto1 = new Project();
        proyecto1.setNombre("Proyecto 1");
        proyecto1.setCost(2.5);
        proyecto1.setDescripcion("Hola");

        Project proyecto2 = new Project();
        proyecto2.setNombre("Proyecto 2");
        proyecto2.setCost(4.5);
        proyecto2.setDescripcion("Diablo");

        Portfolio portfolio = new Portfolio();
        portfolio.getProjects().add(proyecto1);
        portfolio.getProjects().add(proyecto2);

        ArrayList<Project> proyectos = portfolio.getProjects();

        for (Project proyecto : proyectos) {
            System.out.println(proyecto.elevatorPitch());
        }
    }
}