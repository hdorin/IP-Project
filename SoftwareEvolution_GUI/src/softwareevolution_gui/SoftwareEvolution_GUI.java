/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareevolution_gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author tda_m
 */
public class SoftwareEvolution_GUI {
    
    private MyToolbar toolb;

    public String[] description()
    {
    	String desc = toolb.getTa().getText();
    	String tags[] = desc.split(" ");
    	return tags;
    	
    }

    public MyToolbar getToolb() {
        return toolb;
    }
   
    
    
    public SoftwareEvolution_GUI() {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Software Evolution");
            
            toolb = new MyToolbar(this);
            toolb.setBorder(new EmptyBorder(10, 10, 10, 10));
            
            JButton searchButton = new JButton("Search");
            searchButton.addActionListener (new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		String test[] = description();
            		for(int i=0;i<test.length;i++)
            		{
            			System.out.println(test[i]);
            		}
            	}
            });
            
            frame.add(toolb, BorderLayout.PAGE_START);
            frame.add(Box.createRigidArea(new Dimension(0, 20)));
            frame.add(searchButton, BorderLayout.PAGE_END);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            //frame.validate();
        });
        
    }
    
    public static void main(String args[]){
        new SoftwareEvolution_GUI();
    }
}

