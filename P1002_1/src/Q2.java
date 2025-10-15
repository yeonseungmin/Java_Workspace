import java.lang.reflect.Array;
import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        //논리 파트 : 변수 ~ 배열
        //클래스 : 난이도 최상
        //API : 
        int[] arr = {1,3,14,5,16,7,18,};
        Arrays.sort(arr);
        for(int x : arr){
            System.out.println(x);
        }
    }
}
