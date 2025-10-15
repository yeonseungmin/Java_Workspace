public class P2 {// 스코프 = 블록
    public static void main(String[] args) {
        int a = 10;
        {
            int b = 20;
            {
                int c = 30;

            }
            int d = 40;
        }
        int e = 50;
        int f = 60;
    }
}

// 지역 변수는 stack에 쌓인다.(지역변수 - 전역변수)
// 블록 내에 선언된 변수는 블록이 끝나면 즉시 소멸된다.