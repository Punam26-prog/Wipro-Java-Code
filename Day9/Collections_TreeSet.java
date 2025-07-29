package PackageNine;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class Collections_TreeSet {
    public static void main(String[] args) {
        
        Set<Integer> setData = new TreeSet<>();
        setData.add(10);
        setData.add(20);
        setData.add(30);
        setData.add(40);
        
        System.out.println("TreeSet: " + setData);

        Iterator<Integer> iterator = setData.iterator();
        System.out.println("Iterating through TreeSet:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}