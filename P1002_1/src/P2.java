public class P2 {
    public static void main(String[] args) {
        //배열
        int score1 = 70;        //스택 score1[기본 타입] 
        int[] scores = new int[5];//scores 자체는 스택    int[] 는 힙 메모리
        scores[0] = 10;          //scores[참조 타입] ---> 배열의 주소[][][][][]
        //scores[10] - RunTime Error  10번째 공간은 [0~9] 다.
        //scores[참조 주소] - 변수를 제거했을때 heap 메모리에 저장된 데이터는 참조 제거되어 소실된다.
        System.out.println(scores[0]);
        for (int i =0; i < 10 ; i++){
            System.out.println(scores[i]);
        }

    }
}
