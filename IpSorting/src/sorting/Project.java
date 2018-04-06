package sorting;

class Project {
    private int metric1;
    private int metric2;
    private String projectName;

    Project(int metric1, int metric2, String projectName){
        this.metric1 = metric1;
        this.metric2 = metric2;
        this.projectName = projectName;
    }


    @Override
    public String toString ( ) {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                '}';
    }
}
