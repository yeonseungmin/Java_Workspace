package p3;

public class App {
    public static void main(String[] args) {
        String str = "ffffff";
        str = str.substring(3);
        
        
        int[] arr = new int[5];
        arr[3] = 30;

        try {
            int a = 3/0;    
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("프끝");
    }
}
