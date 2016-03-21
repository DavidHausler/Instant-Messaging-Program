//TODO
    //Add button binding (ENTER) for sending a message.
    //Add button java.swing.JButton for sending a message.
    //Delete/keep options? (file,edit).
    //FIX sometimes brokend layout.
    //FIX terrible collors.
    //FIX chat area white overlay while resizing.
    //FIX overall size values while fullscreen on large monitors.
package imp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.util.*;
import imp.view.GuiFrame;

/**
 * Class creating user interface for the application, all elements with
 * exception of base frame are created here.
 *
 * @author David Häusler
 * @date 03.03.2016 13:50:00 PM
 */
public class ImpGuiPanel extends JFrame {

    // Variable for saving sent messages.
    private String Message;
    // Split pane containing users on the right and history+chat on the left.
    private javax.swing.JSplitPane splitUserComm;
    // Split pane containing history on the top and chat on the bottom.
    private javax.swing.JSplitPane splitHistoryChat;
    // Wrapper for history.
    private javax.swing.JScrollPane wrapperHistory;
    // Non editable text area for showing sent messages.
    private javax.swing.JTextArea History;
    // Text field for writing new messages.
    private java.awt.TextArea Chat;
    // Wrapper for Users.
    private javax.swing.JScrollPane wrapperUsers;
    // List for displaying added users.
    private javax.swing.JList Users;
    // Content wrapper for menu items.
    private javax.swing.JMenuBar jMenuBar1;
    // Main menu panel.
    private javax.swing.JMenu jMenu1;
    // Secondary menu panel.
    private javax.swing.JMenu jMenu2;
    // End of variables declaration.

    /**
     * Constructor calling a method responsible for building GUI.
     */
    public ImpGuiPanel() {
        initComponents();
    }

    /**
     * Constructs the GUI.
     *
     */
    private void initComponents() {

        splitUserComm = new javax.swing.JSplitPane();
        splitHistoryChat = new javax.swing.JSplitPane();
        wrapperHistory = new javax.swing.JScrollPane();
        History = new javax.swing.JTextArea();
        Chat = new java.awt.TextArea();
        wrapperUsers = new javax.swing.JScrollPane();
        Users = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        splitUserComm.setResizeWeight(0.80);

        splitHistoryChat.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        splitHistoryChat.setResizeWeight(0.5);

        History.setEditable(false);
        History.setColumns(20);
        History.setRows(5);
        wrapperHistory.setViewportView(History);

        splitHistoryChat.setTopComponent(wrapperHistory);

        Chat.setText(Message);
        splitHistoryChat.setRightComponent(Chat);

        splitUserComm.setLeftComponent(splitHistoryChat);
//        Sets abstracition data model for JList, overvrites abstract methods.
//        Users.setModel(new javax.swing.DefaultListModel() {
//            String[] strings = {"User1", "User2", "User3", "User4", "User5"};
//
//            @Override
//            public int getSize() {
//                return strings.length;
//            }
//
//            @Override
//            public Object getElementAt(int i) {
//                return strings[i];
//            }
//        });
        Users.setMaximumSize(new java.awt.Dimension(200, 2000));
        Users.setMinimumSize(new java.awt.Dimension(80, 80));
        Users.setPreferredSize(new java.awt.Dimension(100, 80));
        Users.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        wrapperUsers.setViewportView(Users);

        splitUserComm.setRightComponent(wrapperUsers);

        jMenuBar1.setBackground(new java.awt.Color(0,51,255));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);
        // Creates the layout of the GUI

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(splitUserComm, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(splitUserComm, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 55, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * @param args the command line arguments
     */
    /**
     * **************************************************************************
     */
    /**
     * Setters and getters*
     */
//    private class EventHandler implements ActionListener{
//        @Override
//        public void ActionPerformed(ActionEvent e){
//        
//        }
//        
//    }
    /**
     * Method for retrieving message from GUI.
     * @return Returns the content of the message typed in the JFramePanel.
     */
    public String getMessage() {
        return Message;
    }

    /**
     * Method for accessing JList and populating it with users
     * @param data Parameter carrying data from Model to be used in JList.
     */
    public void setUsers(String data) {
        DefaultListModel model = new DefaultListModel();
        model.addElement(data);
        Users.setModel(model);
    }
    public void setHistory(String message){
        History.append(message);
    }
}
