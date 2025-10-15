public class P7 {
    public static void main(String[] args) {
        //이중 배열   -- 이중 반복문 이랑 사용
        // [ ] < -- 또한 접근 연산자(메모리 사용)
        int[][] arr = new int[3][4];    // 총 메모리 16개  
                                // [][][][]
                                // [][][][]
                                // [][][][]
        
        arr[1] = new int[2];    
                                // [][][][]
                                // [][]
                                // [][][][]
        for(int x = 0; x<arr.length; x++){
            for (int y =0; y<arr[x].length; y++){
                arr[x][y]=30;
            }
        }
        

    }
}
