public class Q5 {
    public static void main(String[] args) {    //에라토스테네스 체 (소수 판별 알고리즘)
        boolean[] arr = new boolean[101];

        for(int i=0; i<arr.length; i++){
            arr[i]=true;
        }
        for(int number =2; number < arr.length; number++){
            if(arr[number]) {
                System.out.print(number + " ");
                for(int i = number *2; i <arr.length; i+=number){
                    arr[i] = false;
                }
            }

        }
    }
}
