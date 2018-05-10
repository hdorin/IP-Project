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
    CheckComboStore[] stores;
    public CheckComboStore[] getStores() {
		return stores;
	}


	public void setStores(CheckComboStore[] stores) {
		this.stores = stores;
	}

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
        this.setBackground(Color.BLACK);
        JPanel form = new JPanel();
        
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        
        form.setBorder(BorderFactory.createTitledBorder("Search form"));
        form.setBorder(new EmptyBorder(20, 20, 20, 20));
        form.add(Box.createRigidArea(new Dimension(0, 10)));
        form.setBackground(Color.BLACK);
        JLabel l1 = new JLabel("Description of the project");
        l1.setForeground(Color.WHITE);
        l1.setFont(l1.getFont().deriveFont(20f));  // Label font
        form.add(l1);
        form.add(Box.createRigidArea(new Dimension(0, 10)));
        String default_text = "Input description here...";
        ta = new JTextArea(default_text, 20, 20);//"Input description here..."
        ta.setLineWrap(true);
        ta.setFont(ta.getFont().deriveFont(20f));    // Description font

        ta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	System.out.println(ta.getText());
            	if(ta.getText().compareTo(default_text)==0) {
                	
            		ta.setText("");   // Mouse event
                }
            }
        });
        ta.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusLost(FocusEvent e){
                if(ta.getText().compareTo("")==0)
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
        language.setBackground(Color.GRAY);
        
        String[] langs = {"Java", "JavaScript", "Python", "C++", "C", "HTML", "CSS", "PHP", "C#", "Ruby"};
        Boolean[] values
                = {
                    Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE
                };
        stores = new CheckComboStore[langs.length];
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
        panel.setBackground(Color.GRAY);
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
