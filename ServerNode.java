import java.util.HashMap;
import java.util.Map;

public class ServerNode {
    private Map<String, ClientNode> clients;

    public ServerNode() {
        this.clients = new HashMap<>();
    }

    public void registerClient(ClientNode client) {
        clients.put(client.getId(), client);
        System.out.println("Registered " + client.getId());
    }

    public void unregisterClient(String clientId) {
        if (clients.containsKey(clientId)) {
            clients.remove(clientId);
            System.out.println("Unregistered " + clientId);
        } else {
            System.out.println("Client not found: " + clientId);
        }
    }

    public void send(String fromId, String toId, String message) {
        if (clients.containsKey(toId)) {
            clients.get(toId).receive(fromId, message);
        } else {
            System.out.println("Client " + toId + " not found.");
        }
    }

    public void broadcastMessage(String message) {
        for (ClientNode client : clients.values()) {
            client.receive("Server", message);
        }
    }

    public void listClients() {
        if (clients.isEmpty()) {
            System.out.println("No clients are currently connected.");
        } else {
            System.out.println("Connected clients:");
            clients.keySet().forEach(System.out::println);
        }
    }
}
