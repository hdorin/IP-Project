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
import java.util.ArrayList;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author tda_m
 */
public class SoftwareEvolution_GUI {
    
    private MyToolbar toolb;
    private ArrayList<String> selectedLangs;
    private ArrayList<String> tags;

    public ArrayList<String> description()
    {
    	ArrayList<String> tags = new ArrayList<String>();
    	String desc = toolb.getTa().getText();
    	String words[] = desc.split(" ");
    	for(int i=0;i<words.length;i++)
    	{
    		tags.add(words[i]);
    	}
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
            
            JButton searchButton = new SearchButton(this);
            /*aici e cand apesi butonul*/
            searchButton.addActionListener (new ActionListener() {
            	public void actionPerformed(ActionEvent e) {

            		tags = description();
            		//taoolb.getStores()[1].id;
            		System.out.println("Tags:");
            		for(int i=0;i<tags.size();i++)
            		{
            			System.out.println(tags.get(i));
            		}
            		selectedLangs=new ArrayList<String>();
            		System.out.println("Languages:");
            		for(int i=0;i<toolb.getStores().length;i++) {
            			if(toolb.getStores()[i].state==true) {
            				selectedLangs.add(toolb.getStores()[i].id);
            			}
            		}
            		int i;
            		for(i=0;i<selectedLangs.size();i++) {
            			System.out.println(selectedLangs.get(i));
            		}

            		ArrayList<String> test = description();
            		for(i=0;i<test.size();i++)
            		{
            			System.out.println(test.get(i));

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

