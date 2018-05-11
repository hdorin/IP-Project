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
public class SoftwareEvolution_GUI implements ActionListener {

    private MyToolbar toolb = null;
    private ArrayList<String> selectedLangs;
    private ArrayList<String> tags;
    private JFrame frame = null;

    public ArrayList<String> description() {
        ArrayList<String> tags = new ArrayList<String>();
        String desc = toolb.getTa().getText();
        if (toolb.getTa().getText().compareTo("Input description here...") == 0) {
            return null;
        }
        String words[] = desc.trim().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            tags.add(words[i]);
        }
        return tags;

    }

    public ArrayList<String> languages() {
        ArrayList<String> langs = new ArrayList<>();

        for (int i = 0; i < toolb.getStores().length; i++) {
            if (toolb.getStores()[i].state == true) {
                langs.add(toolb.getStores()[i].id);
            }
        }

        return langs;
    }

    public MyToolbar getToolb() {
        return toolb;
    }

    public boolean displayInfo(ArrayList<String> tags, ArrayList<String> selectedLangs) throws NullPointerException {
        try {
            if (!tags.isEmpty() && !selectedLangs.isEmpty()) {

                System.out.println("Tags:");
                for (int i = 0; i < tags.size(); i++) {
                    System.out.println(tags.get(i));
                }
                System.out.println("Languages:");
                for (int i = 0; i < selectedLangs.size(); i++) {
                    System.out.println(selectedLangs.get(i));

                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select at least 1 (one) language.");
                return false;
            }
        } catch (NullPointerException x) {
            if (selectedLangs.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please select at least 1 (one) language and input a description.");
                return false;

            } else {
                JOptionPane.showMessageDialog(frame, "Please input a description.");
                return false;

            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.tags = description();
        this.selectedLangs = languages();

        boolean displayInfo = displayInfo(this.tags, this.selectedLangs);
    }

    public SoftwareEvolution_GUI() {
        EventQueue.invokeLater(() -> {
            frame = new JFrame("Software Evolution");

            toolb = new MyToolbar(this);
            toolb.setBorder(new EmptyBorder(10, 10, 10, 10));

            JButton searchButton = new SearchButton(this);
            /*aici e cand apesi butonul*/
            searchButton.addActionListener(this);

            ImageIcon image;
            image = new ImageIcon("title.jpg");
            JLabel label_img = new JLabel();
            label_img.setIcon(image);

            frame.setResizable(false);
            frame.add(label_img, BorderLayout.NORTH);
            frame.add(toolb, BorderLayout.WEST);
            frame.add(Box.createRigidArea(new Dimension(0, 20)));
            frame.add(searchButton, BorderLayout.SOUTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            //frame.validate();
        });

    }

    public static void main(String args[]) {
        new SoftwareEvolution_GUI();
    }
}
