

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayNode extends Node implements Iterable<Node> {

    private final ArrayList<Node> nodes;

    public ArrayNode() {
        nodes = new ArrayList<>();
    }
    
    public void add(Node node) {
        nodes.add(node);
    }
    
    public int size() {
        return nodes.size();
    }

    @Override
    public Iterator<Node> iterator() {
        return nodes.iterator();
    }
}
