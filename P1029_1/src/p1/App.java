package p1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();

    }
    {
    List<Map<String,Object>> totalDataList = new ArrayList<>();

    Map<String,Object> map1 = new HashMap<>();
        
    map1.put("userInfo",new User());

    List<Article> articlelist = new ArrayList<>();
    articlelist.add(new Article());
    articlelist.add(new Article());
    articlelist.add(new Article());
    map1.put("articleList", articlelist);
    }
    {
        Map<String, Object> data =new HashMap<>();
        data.put("Writer", new User());
        data.put("article", new Article());

        // List<Comment> commentList = new ArrayList<>();
        // data.put("commentList", commentList);
        List<Map<String,Object>>commentDataList = new ArrayList<>();
        data.put("commentDataList",commentDataList);

        Map<String,Object> commentData1 = new HashMap<>();
        commentData1.put("comment", new Comment());
        commentData1.put("writer", new User());
        commentDataList.add(commentData1);
        
    }
    
}

class User{
    String nickname;
    // List<Article> list;
}

class Article{

}
class Comment{
    String text;
}