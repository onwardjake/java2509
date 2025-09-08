package ch08.sec02;

public interface RemoteControl {
    public static final int MAX_VOLUME = 10;
    int MIN_VOLUME = 0; // 생략하더라도 컴파일 과정에서 public static final이 자동으로 붙는다.

    public void turnOn();
    public void turnOff();
    public void setVolume(int volume);

    default void setMute(boolean mute){
        if(mute){
            System.out.println("리모컨의 무음 버튼을 눌러 무음 처리되었습니다.");
            setVolume(RemoteControl.MIN_VOLUME);
        }
        else{
            System.out.println("무음을 해제합니다.");
        }
    }

    public static void changeBattery(){
        System.out.println("리모컨 배터리를 교체합니다.");
    }
}
