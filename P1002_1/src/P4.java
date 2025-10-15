public class P4 {
    public static void main(String[] args) {
        
        int[] arr1 = null;
        //arr1[0] = 10 -->  NullPointException
        {
            int[] arr2 = new int[5];    //heap 메모리는 참조가 끊길때 사라짐. 
            arr2[0] = 30;               //stack 은 스코프를 빠져나가면 삭제
            arr1 = arr2;                //주소값을 복사해 참조를 연결해놨기 때문에 heap메모리 유지
        }
        System.out.println(arr1[0]);    //
    }
}
