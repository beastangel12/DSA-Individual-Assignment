import java.util.ArrayList;
import java.util.List;

//Given an array of even numbers sorted in ascending order and an integer k,
//        Find the k^th missing even number from provided array
//        Input a[] ={0, 2, 6, 18, 22} k=6
//        Output: 16 examples:
//        Explanation: Missing even numbers on the list are 4, 8, 10, 12, 14, 16, 20 and so on and kth
//        missing number is on 6th place of the list i.e. 16
public class Question8B {


    public static int findKthMissingEvenNumber(int[] a, int k) {
        List<Integer> missingEvens = new ArrayList<>();
        int j = 0;
        for (int i = a[0]; i < a[a.length - 1]; i += 2) {
            if (j < a.length && a[j] == i) {
                j++;
                continue;
            }
            missingEvens.add(i);
            if (missingEvens.size() == k) {
                return i;
            }
        }
        return a[a.length - 1] + 2 * k;
    }

    public static void main(String[] args) {
        int[] a = {0, 2, 6, 18, 22};
        int k = 6;
        System.out.println(findKthMissingEvenNumber(a, k));
    }
}

