/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareevolution_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author tda_m
 */
public class MyToolbar extends JSplitPane implements ActionListener {

    private final SoftwareEvolution_GUI frame;
    boolean sap = false;
    JComboBox combo;

    private JTextArea ta;

    public SoftwareEvolution_GUI getFrame() {
        return frame;
    }

    public JTextArea getTa() {
        return ta;
    }

    public MyToolbar(SoftwareEvolution_GUI frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        setResizeWeight(.5d);

        JPanel form = new JPanel();
        
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        
        form.setBorder(BorderFactory.createTitledBorder("Search form"));
        form.setBorder(new EmptyBorder(20, 20, 20, 20));
        form.add(Box.createRigidArea(new Dimension(0, 10)));
        
        JLabel l1 = new JLabel("Description of the project");
        form.add(l1);
        form.add(Box.createRigidArea(new Dimension(0, 10)));

        ta = new JTextArea("Input description here...", 6, 8);
        ta.setLineWrap(true);

        ta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ta.setText("");
            }
        });
        ta.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusLost(FocusEvent e){
                ta.setText("Input description here...");
            }

        });

        form.add(new JScrollPane(ta));

        form.add(Box.createRigidArea(new Dimension(0, 12)));

        setLeftComponent(form);

        /**
         * *****************************************
         */
        JPanel language = new JPanel();

        language.setLayout((new BoxLayout(language, BoxLayout.Y_AXIS)));

        language.add(Box.createRigidArea(new Dimension(50, 50)));

        String[] langs = {"Java", "JavaScript", "Python", "C++", "C", "HTML", "CSS", "PHP", "C#", "Ruby"};
        Boolean[] values
                = {
                    Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
                };
        CheckComboStore[] stores = new CheckComboStore[langs.length];
        for (int j = 0; j < langs.length; j++) {
            stores[j] = new CheckComboStore(langs[j], values[j]);
        }
        combo = new JComboBox(stores);
        combo.setSelectedIndex(-1);

        combo.setRenderer(new CheckComboRenderer("LANGUAGES", this));
        combo.addActionListener(this);
        combo.setAlignmentX(CENTER_ALIGNMENT);
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.add(combo);

        language.add(panel);

        setRightComponent(language);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        CheckComboStore store = (CheckComboStore) cb.getSelectedItem();
        CheckComboRenderer ccr = (CheckComboRenderer) cb.getRenderer();
        ccr.checkBox.setSelected((store.state = !store.state));

        cb.setSelectedIndex(-1);
        sap = true;
    }
}
