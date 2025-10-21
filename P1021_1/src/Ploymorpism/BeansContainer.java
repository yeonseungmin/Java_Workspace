package Ploymorpism;

//인스턴스 생성관리,조립 - 다른 기능 없음
//설정에 해당하는 클래스 = 나중에 xml,json, 어노테이션 설정으로 바뀜
public class BeansContainer {
    private User user;
    public BeansContainer(){
        //설정
        Speaker speaker = new AppleSpeaker();
        Tv tv = new LgTv(speaker);
        // Tv tv = new LgTv();  
        user = new User(tv);    // 정확한 DI 구현장소
    }
    public User getUser(){
        return user;
    }
    // public Tv getTv(){
    //     return new LgTv();  // 생성해서 리턴해준다.
    // }
}
