import java.util.Scanner;

public class NetworkSimulation {
    private static Star network = new Star();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Commands: register [id], unregister [id], send [fromId] [toId] [message], broadcast [message], list, exit");
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "register":
                    network.insertNode(new ClientNode(parts[1], network.centralNode));
                    break;
                case "unregister":
                    network.deleteNode(parts[1]);
                    break;
                case "send":
                    String fromId = parts[1];
                    String toId = parts[2];
                    String message = command.substring(command.indexOf(parts[3]));
                    network.centralNode.send(fromId, toId, message);
                    break;
                case "broadcast":
                    network.centralNode.broadcastMessage(command.substring(command.indexOf(parts[1])));
                    break;
                case "list":
                    network.centralNode.listClients();
                    break;
                case "exit":
                    System.out.println("Exiting network simulation.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }
}
