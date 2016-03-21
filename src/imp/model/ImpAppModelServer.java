//TODO
    //Add ability to enable communication between 2 users.(for now only 
    //server - client is possible)

    //Add simple UI in order to monitor the server.
    //Replace system.out.println() with explicit method for displaying alerts.
    //Add runner for the server

    
package imp.model;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * ImpAppModelServer class for implementing logic of the application.  
 * @author David Häusler
 * @date 26.02.2016 12:30:00 PM
 */
public class ImpAppModelServer {
    /* Variable for saving of outcoming data */
    private ObjectOutputStream connOutput;
    /* Variable for saving of incoming data */
    private ObjectInputStream connInput;
    /* Variable for saving server */
    private ServerSocket server;
    /* Variable for saving connection to user */
    private Socket connection;
    /**
     *
     */
    public ImpAppModelServer() {
        
    }
    /**
     * Starter method for initiating server.
     */
    public void createSession() {
        /* Nested try catch method*/
        try {
            /* Creates new connection on port 6789 with 10 maximum connections
             and ads it to variable Server*/
            server = new ServerSocket(6355, 10);
            /* Infinite loop */
            while (true) {
                /* Nested try catch method running 2 core methods.*/
                try {
                    /* Before connection state */
                    waitForConnection();
                    /* Setting up connection with the server*/
                    setUpStreams();
                    /* While in connected state */
//                    whileConnected();
                } catch (EOFException eofException) {
                    /* When someone leaves the room, or connection to server
                     is lost */
                    System.out.print("User left the room");
                } finally {
                    /* After connection is terminated */
                    closeConnection();
                }
            }
            /* If something goes wrong */
        } catch (IOException ioException) {
            /* Prins the error for tracing */
            ioException.printStackTrace();
        }
    }

    /**
     * Waits for incoming connection, when connection is available, accepts it.
     *
     * @throws IOException
     */
    private void waitForConnection() throws IOException {
        /* When client is runnig, this message is generated, to inform user 
         that the client is waiting for connection */
        System.out.print("Waiting for someone to be online...");
        /* If connection is made (loops check of it) and .accept() accpets
         the connection and allows it to be made. It also blocks connection
         until it's made so the socket is created only when the connection 
         is made. */
        connection = server.accept();
        /* Creates a message for user, infroms him about his adress and the
         IP adress of the server*/
        System.out.print("Connection created between"
                + connection.getInetAddress().getHostName());
    }
    /**
     * Creates both ways streams for packets.
     * @throws IOException 
     */
    private void setUpStreams() throws IOException {
        /* Creates a stream(connection) with another computer whose adress is
         save in $connection */
        connOutput = new ObjectOutputStream(connection.getOutputStream());
        /* Sends leftover data from buffer to the other person */
        connOutput.flush();
        connInput = new ObjectInputStream(connection.getInputStream());
        /* Inform user */
     //   System.out.print("Connection succesful, ready to chat");
    }
    ;
    /**
     * Method for 
     * @throws IOException 
     */
//    private void whileConnected() throws IOException {
//        /* inform the user */
//        String message = "Succesfuly connected";
//        /* Inform the user*/
//        sendMessage(message);
//    }
    /**
     * Closes input-output streams and connection.
     * @throws IOException 
     * 
     */
    private void closeConnection() throws IOException {

        try {
            /* Closes the stream from user to server */
            connOutput.close();
            /* Closes the stream from server to user */
            connInput.close();
            /* Closes the stream itself */
            connection.close();
            /* If an error ocures */
        } catch (IOException ioException) {
            /* Shows user the error code */
            ioException.printStackTrace();
        }
    }
    /**
     * Sends message (string) trough the stream and clears the stream after the
     * fact.
     * @param message text from the message created by the user.
     */
    public void sendMessage(String message) {
        /* Try loop, which tries to send a message, dump excess data and display
         that message in chatHistory*/
        try {
            /* Message (coming from the SERVER) is written im Object into the 
             $connOutput stream. After that, it is ready to be sent to the
             client */
            connOutput.writeObject("SERVER - " + message);
            /* Dumps any unused data */
            connOutput.flush();
        } catch (IOException ioException) {
            
            /* Creates exception fot chatHitory, for case of message not beeing
             String object type */
        }
    }
    /**
     * Method for retrieving elements (added friends) in the array for use in 
     * GUI.
     * @return the elements in the ArrayList
     */
    
}
