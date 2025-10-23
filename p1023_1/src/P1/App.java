package P1;

public class App {
    public static void main(String[] args) {
        //API = 프로그램을 완성하기 위한 도구
        //평생 걸쳐 공부해도 다 못함
        //대부분의 API는 이해보다는 사용방법에 집중
        System.out.println("ddd");

        // ~~~. -> 인스턴스 메서드-------------------------------------
        Math.log(10);
        //몇몇개의 API 는 이해가 중요하다.  /자료구조, 네트워크
        String str1 = "aaa, bbb, ccc";
        String a = str1.toUpperCase();
        System.out.println(a);

        String searchWord = "bts";
        String targetWord = "Bts";

        if(searchWord.toUpperCase().equals(targetWord.toUpperCase())){

        }
        int length = searchWord.length();
        searchWord.equals(a);
        searchWord.contains(targetWord);
        searchWord.split(",");
        String k="   tt  t   ".trim();  // 왼쪽, 오른쪽 끝 공백 삭제
        System.out.println(k);

        "이러멛".startsWith("이"); // "이" 로 시작하느냐
        "addafefaadf".substring(3,5);   //3번째~5번째 인덱스를 기준으로 나누겠다.   // (3) 파라미터 하나도 가능
        int result ="dfaefdfef".indexOf("ef");  //해당글자의 인덱스 첫 위치를 알려준다.
        System.out.println(result);
        String filename = " aaabbbccc.jpg";
        String ext = filename.substring(filename.lastIndexOf("."));
        System.out.println(ext);

        ////////////////////////////////////////////////////////////////////////////////////////////////
        // Static 매서드 클래스().~~
        
        int b = 10;
        String aa = String.valueOf(b);
        int q=2;
        int w=3;
        System.out.println(String.format("%d X %d = %d", q,w,q*w));


    }
}
