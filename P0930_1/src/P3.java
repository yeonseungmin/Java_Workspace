public class P3 {
    public static void main(String[] args) {
        // 연산자 - 연산과정 중 모든 타입에 매우 주의
        // 산술 연산자 : + = * / %
        {
        int a = 10;
        int b = a + 10;
        int c = a + b;

        byte v1 = 10 +20;
        byte v2 = 30;
        // byte v3 = v1 + v2; 타입 오류
        byte v3 = (byte)(v1 + v2);
        }
        {
            int a = 10;
            double b = 20.0;
            double c = a + b;   // double 을 int 로 convert 못함 타입 미스매치

        }
        {
            int a = 10;
            double b = a/3;     // 3 [ / : 양옆의 피 연산자가 둘다 int면 정수 나누기]
            double c = a/3.0;

        }
        {
            int a = 5;
            int b = 2;
            int c = a / b;      // 3 [ / : 피연산자의 타임에 따라 정수 혹은 실수 나누기를 한다.]
            double d = a / (double)b;
            double e = 10 /0.0; // Infinity 무한대
            double f = 0.0/0.0; // NaN : Not a Number
            int g = 1 + 2 * 3 + 4;

        }
        {
            //세밀한 계산시에는 정수 타입으로,  더블은 최소한
            int apple = 1;
            double count = 7;
            double piece = 0.1;
            double result = apple - (piece * count);
            int weight = 10;
            int b = 1 * weight;
            int c = (int)(0.1 * weight);
            int count2 = 7;
            int result2 = b - (c*count2);
            double result3 = result2/(double)weight;        //2.99999999999999993

        }

        // 비교 연산자 : == != > < >= <=
        {
            int a =5;
            int b =2;
            boolean r1 = a>b;
            boolean r2 = a<b;
            boolean r3 = a>=b;
            boolean r4 = a<=b;
            boolean r5 = a!=b;
            boolean r6 = a==b;

        }

        // 논리 연산자 : &&(And) ||(Or) !(Not)
        {
            //피연산자는 boolean, 결과도 boolean
            int a = 10;
            int b = 20;

            boolean r1 = a > 5 && b < 3;    // 왼쪽이 참이면 오른쪽 시행, 왼쪽이 거짓이면 종료
            boolean r2 = a > 5 || b > 5;    // 왼쪽이 참이면 종료, 왼쪽이 거짓이면 오른쪽도 확인,

            //!
            boolean r3 = !(a !=4 && !(a>5));
        }
        // 단추 배정 연산자 : += -= *= ..
        // 증감 연산자 ++ --
        {
            int a =10;
            a = a+1;
            a +=1;
            a ++;

            int b =10;
            b = b+3;
            b +=3;

            int c = 30;
            c = c - 7;
            c -= 7;

            int f = 3;
            f++;
            ++f;
        }

        System.out.println();
    }
}
