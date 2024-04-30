import java.util.ArrayList;
import java.util.List;

/**
 * Star class models a star topology in a computer network.
 */
public class Star {
    ServerNode centralNode;
    private List<ClientNode> nodes;

    public Star() {
        centralNode = new ServerNode();
        nodes = new ArrayList<>();
    }

    public void insertNode(ClientNode node) {
        nodes.add(node);
        centralNode.registerClient(node);
    }

    public void deleteNode(String nodeId) {
        nodes.removeIf(n -> n.getId().equals(nodeId));
        centralNode.unregisterClient(nodeId);
    }
}
