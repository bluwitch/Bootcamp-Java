import java.util.ArrayList;

public class Portfolio {

    private ArrayList<Project> projects;

    public Portfolio() {
        projects = new ArrayList<Project>();
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}
