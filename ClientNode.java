import java.util.ArrayList;

/**
 * ClientNode represents a node in a star network, capable of sending and receiving messages.
 */
public class ClientNode {
    private String id;
    private ServerNode server;
    private ArrayList<String> messageLog;  // Stores the history of received messages

    public ClientNode(String id, ServerNode server) {
        this.id = id;
        this.server = server;
        this.messageLog = new ArrayList<>();
        server.registerClient(this);  // Register this client with the server upon creation
    }

    public String getId() {
        return id;
    }

    public void send(String toId, String message) {
        server.send(id, toId, message);  // Changed to server.send to align with updated ServerNode
    }

    public void receive(String fromId, String message) {
        String fullMessage = id + " received from " + fromId + ": " + message;
        System.out.println(fullMessage);
        messageLog.add(fullMessage);  // Log this message
    }

    public void printMessageLog() {
        System.out.println("Message log for " + id + ":");
        for (String msg : messageLog) {  // Corrected iteration to use for-each loop
            System.out.println(msg);
        }
    }

    public void rename(String newId) {
        server.unregisterClient(id);
        this.id = newId;
        server.registerClient(this);
    }
}
