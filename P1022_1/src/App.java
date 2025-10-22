

public class App {
    public static void main(String[] args) {
        // public String[] solution(int n, int[] arr1, int[] arr2) {
        int n= 5;
        int[] arr1 ={9, 20, 28, 18, 11};
        int[] arr2 ={30, 1, 21, 17, 28};

        String[] answer = {};
        int[] arrBinaryA = new int[n];
        int[] arrBinaryB = new int[n];
        String cloneA = "";
        String cloneB = "";
        int cloneC = 0;
        int[] result = new int[n];

        for(int i=0; i<n; i++){
            int a = arr1[i];
            int b = arr2[i];
            
            int k = a|b;
            System.out.println(k);
    }
    }
}

// }