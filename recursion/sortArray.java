package recursion;
import java.util.*;

public class sortArray {
    public static void main(String[] args){
        ArrayList arr = new ArrayList(Arrays.asList(5,1,0,2));
        ArrayList list = sort(arr);
        System.out.println(list);
    }
    public static ArrayList<Integer> sort(ArrayList<Integer> arr){
        if(arr.size() == 1){
            return arr;
        }
        int val = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        sort(arr);

        insert(arr,val);
        return arr;
    }
    public static ArrayList<Integer> insert(ArrayList<Integer> arr,int val){
        if(arr.size() == 0 || val >= arr.get(arr.size() - 1)){
            arr.add(val);
            return arr;
        }
        int data = arr.get(arr.size()-1);
        arr.remove(arr.size() -1);
        insert(arr,val);

        arr.add(data);
        return arr;
    }
}