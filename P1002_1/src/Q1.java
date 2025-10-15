public class Q1 {
    public static void main(String[] args) {
        //Sorting
        int[] arr ={7,8,9,1,3,4,5,6,2};
        int temp =0;
        for(int x =0; x<arr.length; x++){
            for(int y =0; y<arr.length - x -1; y++){
                if(arr[y] > arr[y+1]){
                    temp = arr[y];
                    arr[y] = arr[y+1];
                    arr[y+1] =temp;
                }
            }
        }    
        for(int e : arr){
            System.out.println(e);
        }
    }
}
