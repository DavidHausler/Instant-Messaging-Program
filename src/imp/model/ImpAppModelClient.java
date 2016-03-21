//TODO
    //Replace system.out.println() with explicit method for displaying alerts.
    //Figure out how to save messages local/server DB or some other way.
    //Remove printStackTrace
    //Add option to change port in case of collision.
    //If all goes well add ability to send files (requires serialization)
package imp.model;

/**
 * Client class for the IMP
 *
 * @author David Häusler
 * @date 21.03.2016 9:00:00 AM
 */
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImpAppModelClient {
    /* Variable for saving message ready to be sent */

    private JTextArea userChat;
    /* Variable for saving sent and recived messages */
    private JTextArea chatHistory;
    /* Variable for saving of outcomming data */
    private ObjectOutputStream connOutput;
    /* Variable for saving of incoming data */
    private ObjectInputStream connInput;
    //private String message;
    /* Variable for saving server IP*/
    private final String serverIP;
    /* Variable for saving session*/
    private Socket connection;
    /* String array for saving members in the friendlist*/
    //TODO Needs to be implemented via local/server DB or serialization,
    //String only for testing. 
    //Not to be implemented via array.
    public String friendList = "Test";

    /**
     * Class constructor responsible for assigning value via parameter to IP
     * variable.
     *
     * @param host IP address of the server client connects to.
     */
    public ImpAppModelClient(String host) {
        serverIP = host;

    }

    /**
     * Root method responsible for starting, maintaining closing the session.
     */
    public void startRunning() {

        try {
            //connects to server
            connectToServer();
            //creates the session between server and user
            setUpStreams();
            //maintains the connection and messages
            whileConnected();
        } catch (EOFException eofException) {
            System.out.println("user thinks you are boring and went offline");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
//        closeConnection();
    }

    /**
     * Connects to specified server on pre defined port number.
     *
     * @throws IOException
     */
    private void connectToServer() throws IOException {
        try {
            System.out.println("Connecting to the server ./..");
            connection = new Socket(InetAddress.getByName(serverIP), 6355);
            System.out.println("connected to "
                    + connection.getInetAddress().getHostName());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    /**
     * Method implementing the communication between the server and the user.
     *
     * @throws IOException
     */
    private void setUpStreams() throws IOException {
        /* Creates a stream(connection) with another computer whose adress is
         saved in $connection */
        connOutput = new ObjectOutputStream(connection.getOutputStream());
        /* Sends leftover data from buffer to the other person */
        connOutput.flush();
        connInput = new ObjectInputStream(connection.getInputStream());
        /* Inform user */
        System.out.println("Connection succesful.");
    }

    /**
     * Method responsible for displaying in/outcomming messages.
     *
     * @throws IOException
     */
    private void whileConnected() throws IOException {
        /* inform the user */
        String message = "Succesfuly connected";
        /* Inform the user*/
        System.out.println(message);

        /* Once we are connected to other user, following loop is iniciated and
         will be running as long as the other user doesn't close the client,
         types the terminating message or the server doesn't overload or fail */
        do {
            try {
                /* Reads the incoming object(message) and converts it to String,
                 content of the message is than saved to $message and shown in 
                 the GUI.*/
                message = (String) connInput.readObject();
                /* Shows the message in the $chatHistory on the new line */
                displayMessage("\n" + message);
                /* If recived message is not recognized as a String (object), throw error */
            } catch (ClassNotFoundException classNotFoundException) {
                /* Inform user about the error */
                displayMessage("Message not recognized as a String");
            }
            /* While message is not equal to TerminateConn1205, you can chat. If it
             is, chat and the connection will be closed*/
        } while (!message.equals("CLIENT - TerminateConn1205"));

    }

    /**
     * Method ensuring correct end of the session.
     *
     * @throws IOException
     */
    private void closeConnection() throws IOException {
        try {
            connOutput.close();
            connInput.close();
            connection.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Method responsible for sending a message.
     * @param message
     */
    public void sendMessage(String message) {
        try {
            connOutput.writeObject("ME " + message);
            connOutput.flush();
            displayMessage(message);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public String displayMessage(final String message) {
        return message;
    }

    public String friendList() {
        return friendList;
    }
}
