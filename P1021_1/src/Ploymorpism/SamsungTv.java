package Ploymorpism;

public class SamsungTv implements Tv{    // 표준을 준수함
    private Speaker speaker;
    public SamsungTv(Speaker speaker){
        this.speaker = speaker;
    }

    public void powerOn(){
        System.out.println("삼성 TV ON ");
    }
    public void powerOff(){
        System.out.println("삼성 TV OFF ");
    }

    public void volumUp(){
        speaker.soundUp();
    }

    public void volumDown(){
        speaker.soundDwon();
    }
}
