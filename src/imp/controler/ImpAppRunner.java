package imp.controler;
import imp.model.ImpAppModelClient;
import imp.view.ImpGuiPanel;
import imp.view.GuiFrame;
import imp.controler.ImpAppController;


/**
 * Runner object for the IMP application.
 *
 * @author David Häusler
 * @date 26.02.2016 11:45:00 AM
 */
public class ImpAppRunner {

    /**
     * Main starter method or entry point for the Java application.
     *
     * @param args Unused for now
     */
    public static void main(String[] args) {
        ImpAppModelClient Client = new ImpAppModelClient("127.0.0.1");
        ImpGuiPanel Panel = new ImpGuiPanel();
     // 
     //   GuiFrame Frame = new GuiFrame();
        ImpAppController Control = new ImpAppController(Panel, Client);
        

        Panel.setVisible(true);

    }

}
