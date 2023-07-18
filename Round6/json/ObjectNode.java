
import java.util.*;

public class ObjectNode extends Node implements Iterable<String> {

    private final Map<String, Node> objects;

    public ObjectNode () {
        objects = new TreeMap<>();
    }

    public Node get(String key) {
        return objects.get(key);
    }

    public void set(String key, Node node) {
        objects.put(key, node);
    }

    public int size() {
        return objects.size();
    }

    @Override
    public Iterator<String> iterator() {
        Set<String> keys = objects.keySet();
        return keys.iterator();
    }
}
