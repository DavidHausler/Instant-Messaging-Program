//TODO
    //Rememember what the hell the sentMessage was suppposed to do.
    //Add actionListener for ENTER button.
    //Add actionListener for user sending a message and displaying it.
    //Add actionListener for user reciving a message and displaying it.
    //Add actionListener for client closing a connection.
    //Add actionListener for server beeing down.
        //Possible sollution: if server availible{connect} else {server off}
    //

package imp.controler;

import java.awt.event.ActionListener;
import java.util.IllegalFormatException;
import imp.model.ImpAppModelClient;
import imp.view.ImpGuiPanel;
import imp.model.ImpAppModelClient;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Class responsible for handling communication between Model and View.  
 * @author David Häusler
 * @date 26.02.2016 12:30:00 PM
 */

public class ImpAppController {

    private final ImpGuiPanel appPanel;
    private final ImpAppModelClient impAppModel;
/**
 * Main constructor method, creates variables for saving links on Data and 
 * GUI.
 * @param appPanel Ensures communication between GUI and controller.
 * @param appModel Ensures communication between Model and controller.
 */ 
    public ImpAppController(ImpGuiPanel appPanel, ImpAppModelClient appModel) {

        this.appPanel = appPanel;
        this.impAppModel = appModel;
        
        appPanel.setUsers(appModel.friendList());
        
        
        
    }
    
    /**
     * Message handler responsible for passing message from View into Model
     */
    //TODO 
//    class MessageListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent sentMessage) {
//
//            String message;
//            try {
//                message = appPanel.getMessage();
//                
//                impAppModel.sendMessage(message);
//                
//            } catch(IllegalFormatException illegalFormatException)  {
//                    System.out.println(illegalFormatException + 
//                            "Text of the message must be text-based."
//                         + " Please, change the text of the message."); 
//            }
//        }
//    }
    /**
     * 
     * @param message data taken from model to be passed into the GUI.
     */
//    public void passMessage(String message){
//        SwingUtilities.invokeLater(
//                new Runnable() {
//                    public void run() {
//                        appPanel.setHistory(appModel.displayMessage());
//                    }
//                }
//        );
//    }
}
