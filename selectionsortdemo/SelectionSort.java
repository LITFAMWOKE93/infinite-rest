package selectionsortdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SelectionSort {

    public static void sort(ArrayList<Student> students, Comparator<Student> comparator) {
        int n = students.size();
        // outer loop executes N times
        for (int i = 0; i < n-1; i ++) {
            int minIndex = i;
            // inner looper executes N times
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(students.get(j), students.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // swap is not a sorting method by itself, but is a utility used in sorting
            Collections.swap(students, i, minIndex);
        }
    }
    
}
