//Class initially creted for use in manual created GUI but after using netbeans
//GUI builder this class became useless. 
package imp.view;

import javax.swing.JFrame;
import imp.controler.ImpAppController;

/**
 * GuiFrame object extending JFrame class for use in GUI.
 * @author David Häusler
 * @date 26.02.2016 12:30:00 PM
 */

public class GuiFrame extends JFrame {
    //
    private ImpGuiPanel basePanel;
    /**
     * Creates an instance of GuiFrame that passes a reference to the 
     * ImpAppContorller for use by GuiFrame instance.
     *. 
     */
    public GuiFrame() {

        this.setContentPane(basePanel);
        this.setSize(500, 500);
        this.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    /**
     * Creates root content panel, sets default width, height and makes the
     * panel visible, closes application on window close.
     */
    private void setupFrame() {
        
    }
    
}
