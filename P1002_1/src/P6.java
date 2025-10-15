public class P6 {
    public static void main(String[] args) {
        int[] arr = {3,4,7,6,8,4};

        for(int i=0; i<arr.length; i++){
            arr[i] = (int)Math.random()*6+1;
        }
    }
}
