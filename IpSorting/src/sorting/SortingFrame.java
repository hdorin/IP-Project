package sorting;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

class SortingFrame extends JPanel {
    // Projects contains the list provided by the crawling and similarity check along with metrics

    private Vector<Project> projects=new Vector <Project> (  );

    SortingFrame(){
        this.setLayout(new GridLayout(5,1));
        this.add(new JLabel("Project 1"));
        this.add(new JLabel("Project 2"));
        this.add(new JLabel("Project 3"));
        this.add(new JLabel("Project 4"));
        this.add(new JLabel("Project 5"));
        projects.forEach ( project -> {
            System.out.println ( project );
            this.add ( new JLabel (String.valueOf(project)) );
//            this.add ( new JLabel ( "second project" ) );
        } );

        System.out.println ("all projects are printed" );
    }

   void addProject(Project project) {
       this.projects.add ( project );
       System.out.println ("project added" );
   }

    void printProjects(){

        projects.forEach ( project -> {
            System.out.println ( project );
            this.add ( new JLabel (String.valueOf(project)) );
//            this.add ( new JLabel ( "second project" ) );
        } );

        System.out.println ("all projects are printed" );
    }



}
