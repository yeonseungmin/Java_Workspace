public class P3 {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        //arr1 = null; // null : 참조할 것이 없다는 의미의 값.

        //int[] arr2 = new int[5];

        int[] arr2 = arr1;      //주소값을 복사

        arr1[0] = 30;
        arr2[0] = 40;
        System.out.println(arr1[0]);
        System.out.println(arr2[0]);
    }
}
