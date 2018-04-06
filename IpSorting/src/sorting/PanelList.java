package sorting;

import javax.swing.*;
import java.awt.*;

class PanelList extends JFrame {


    private JCheckBox box1 = new JCheckBox ( "Criterion 1" );
    private JCheckBox box2 = new JCheckBox ( "Criterion 2" );
    private JCheckBox box3 = new JCheckBox ( "Criterion 3" );
    private JCheckBox box4 = new JCheckBox ( "Criterion 4" );
    private JCheckBox box5 = new JCheckBox ( "Criterion 5" );



    private SortingFrame sortingFrame = new SortingFrame ();

    PanelList() {

        JPanel panelUp = new JPanel (  );
        panelUp.add (new JLabel ("this are the results") );
        this.add(panelUp, BorderLayout.NORTH);
        Project project1 = new Project ( 1,5,"project1" );
        Project project2 = new Project ( 2,4,"project2" );
        Project project3 = new Project ( 3,3,"project3" );
        Project project4 = new Project ( 4,2,"project4" );
        Project project5 = new Project ( 5,1,"project5" );
        sortingFrame.addProject ( project1 );
        sortingFrame.addProject ( project2 );
        sortingFrame.addProject ( project3 );
        sortingFrame.addProject ( project4 );
        sortingFrame.addProject ( project5 );


        JPanel panelLeft = new JPanel (  );
        JButton button = new JButton ( "Sort" );
        panelLeft.add(button);
        this.add ( panelLeft, BorderLayout.EAST );
        button.addActionListener ( e -> {
            System.out.println ("s1" );
            sortingFrame.printProjects ();

        } );


        JPanel panelRight = new JPanel (  );

        panelRight.setLayout ( new GridLayout (5,1) );
        panelRight.add(box1);
        panelRight.add(box2);
        panelRight.add(box3);
        panelRight.add(box4);
        panelRight.add(box5);
        this.add ( panelRight, BorderLayout.WEST );

        SortingFrame panelCenter = new SortingFrame ();


        this.add ( panelCenter, BorderLayout.CENTER );


    }
}
