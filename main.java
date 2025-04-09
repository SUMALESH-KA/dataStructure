import SORTING.Selection;

public class main {
    public static void main(String[] args) {
        int[] arr = {3, 8, 1, 100, 9, 18};
        Selection s = new Selection();
        s.selectionSort(arr, arr.length);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
