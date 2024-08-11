package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// {1,3,4,5,7}, {2,3,5,6}
public class SortedArrayIntersection {
    public int[] sortedArrayInterection(int[] arr1, int[] arr2) {
        int index1 = 0, index2 = 0;
        List<Integer> intersectionList = new ArrayList<>();
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] == arr2[index2]) {
                intersectionList.add(arr1[index1]);
                index1++;
                index2++;
            } else if (arr1[index1] < arr2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        int[] intersectedValues = intersectionList.stream().mapToInt(Integer::intValue).toArray();
        return intersectedValues;
    }

    public static void main(String[] args) {
        SortedArrayIntersection sortedArrayIntersection = new SortedArrayIntersection();
        int[] arr1 = {1, 3, 4, 5, 7}, arr2 = {2, 3, 5, 6};
        int[] interection = sortedArrayIntersection.sortedArrayInterection(arr1, arr2);
        Arrays.stream(interection).boxed().forEach(e->{
            System.out.print(e+" ");
        });
    }
}
