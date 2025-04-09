package SORTING;

public class Selection {
    public void swap(int[] arr, int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp; 
    }

    public void selectionSort(int[] arr, int len){
        for(int i = 0 ; i < len - 1; i++){ // fixed i < len - 1
            int min = i;
            for(int j = i + 1; j < len; j++){ // fixed inner loop
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr,i,min);
        }
    }
}
