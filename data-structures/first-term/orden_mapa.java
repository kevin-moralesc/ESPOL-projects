import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
public class ordenMAPA {

    public static void main(String[] args) {
        // HashMap no mantiene el orden de inserción
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("B", 1);
        hashMap.put("A", 2);
        hashMap.put("C", 3);
        System.out.println("HashMap: " + hashMap);

        // TreeMap mantiene el orden natural de las claves
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("C", 3);
        treeMap.put("A", 1);
        treeMap.put("B", 2);
        System.out.println("TreeMap: " + treeMap);

        // LinkedHashMap mantiene el orden de inserción
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("B", 2);
        linkedHashMap.put("C", 3);
        linkedHashMap.put("A", 1);
        System.out.println("LinkedHashMap: " + linkedHashMap);
    }
    
}
