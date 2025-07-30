package DayTen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collections_Comparable {
	public static void main(String[] args) {
        
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                if (i > j) {
                    return 1;
                } else if (i < j) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        List<Integer> course1 = new ArrayList<>();
        course1.add(1);
        course1.add(8);
        course1.add(7);

        System.out.println("Before Sorting: " + course1);

        Collections.sort(course1, c1);
        System.out.println("After Sorting (Ascending): " + course1);

        Collections.sort(course1, (a, b) -> b - a);
        System.out.println("After Sorting (Descending): " + course1);
    }
}
