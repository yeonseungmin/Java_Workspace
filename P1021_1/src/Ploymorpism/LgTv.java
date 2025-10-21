package Ploymorpism;

public class LgTv implements Tv { // 표준은 신경 안씀
    private Speaker speaker;
    public LgTv(Speaker speaker){
        this.speaker = speaker;
    }
    // public void turnOn(){
    //     System.out.println("엘지 TV ON");
    // }
    // public void turnOff(){
    //     System.out.println("엘지 TV OFF");
    // }
    // public void soundUp(){
    //     System.out.println("엘지 TV SoundUp");
    // }
    // public void soundDown(){
    //     System.out.println("엘지 TV SoundDwon");
    // }
    public void powerOn(){
        System.out.println("엘지 TV ON");
    }
    public void powerOff(){
        System.out.println("엘지 TV OFF");
    }
    public void volumUp(){
        speaker.soundUp();
    }
    public void volumDown(){
        speaker.soundDwon();
    }
}
