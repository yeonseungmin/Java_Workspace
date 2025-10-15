public class P2 {
    public static void main(String[] args) {
        double value = Math.random()*6 ;
        int value2 = (int)(Math.random()*6) + 1 ; //Math( 0~ 0.9999... *6 = 0~5.999...)
                // (int)(Math.random()*6 // 총 범위) + 1 // 시작지점


        if (value2 ==1) {
            System.out.println("1");
        } else if(value2 == 2){
            System.out.println("2");
        } else if(value2 == 3){
            System.out.println("3");
        } else if(value2 == 4){
            System.out.println("4");
        } else if(value2 == 5){
            System.out.println("5");        
        } else if(value2 == 6){
            System.out.println("6");
        } 

        
    }
}
