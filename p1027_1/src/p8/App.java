package p8;

import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        //자료구조 : Collection Framework

        List<String> list = new ArrayList<>();
        list.add("한조");
        list.add("동훈");
        list.add("동훈");
        list.add("덩훈");

        System.out.println(list.size());

        for(String e : list){
            System.out.println(e);
        }

        // Map

        Map<String , Object> map = new HashMap<>();
        map.put("이름","한조");
        map.put("나이",30);
        map.put("점수",100);
        System.out.println(map.get("이름")+"\n"+map.get("나이")+"\n"+map.get("점수"));


    }
}
