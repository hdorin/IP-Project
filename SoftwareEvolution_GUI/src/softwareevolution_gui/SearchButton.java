package softwareevolution_gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SearchButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final SoftwareEvolution_GUI frame;
	
	public SoftwareEvolution_GUI getFrame() {
        return frame;
    }
	
	public SearchButton(SoftwareEvolution_GUI frame) {
        this.frame = frame;
        init();
    }
	
	public void init(){
        //this = new JButton("Search");
		this.setText("Search");
        this.setPreferredSize(new Dimension(80, 80));
        this.setFont(this.getFont().deriveFont(15f));
	}
	
}
