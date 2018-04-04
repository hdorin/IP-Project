/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareevolution_gui;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author tda_m
 */
class CheckComboRenderer implements ListCellRenderer {
    
    JCheckBox checkBox;
    private MyToolbar mt;
    JLabel label;
    String title;

    public CheckComboRenderer(String title, MyToolbar mt) {
        this.checkBox = new JCheckBox();
        this.label = new JLabel();
        this.mt = mt;
        this.title = title;
    }

    @Override
    public Component getListCellRendererComponent(JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        
        CheckComboStore store = (CheckComboStore) value;

        if (index == -1 && value == null) {
            if (mt.sap) {
                    mt.combo.showPopup(); //show it again
                    mt.sap = false; //and remove the flag
                }
            
            label.setText(title);

            label.setBackground(isSelected ? Color.red : Color.white);
            label.setForeground(isSelected ? Color.white : Color.black);
            return label;
        } else {
            
            
            checkBox.setText(store.id);

            checkBox.setSelected(((Boolean) store.state).booleanValue());
            checkBox.setBackground(isSelected ? Color.red : Color.white);
            checkBox.setForeground(isSelected ? Color.white : Color.black);
            return checkBox;
        }

    }
}
