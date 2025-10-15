public class P3 {
    public static void main(String[] args) {
        //swich - case 분기

        int value = 3;  //해당 값으로 점프후 아래 케이스 계속 실행 break 를 만나면 종료

        switch (value) {
            case 1:
                System.out.println("1");
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
            case 3 : 
                System.out.println("3");
            case 4 : 
                System.out.println("4");
            case 5 : 
                System.out.println("5");
            case 6 : 
                System.out.println("6");
            default:
                System.out.println("나머지");
                break;
        }
        {
            int value2 = 3;
            String day = switch (value2) {
                case 1 -> "월요일";
                default -> "잘못된 값";
            };
        }
    }
}
