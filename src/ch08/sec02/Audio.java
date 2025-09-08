package ch08.sec02;

public class Audio implements RemoteControl {
    private int volume;

    @Override
    public void turnOn(){
        System.out.println("Audio를 켭니다.");
    }

    @Override
    public void turnOff(){
        System.out.println("Audio를 끕니다.");
    }

    @Override
    public void setVolume(int volume){
        if(volume > RemoteControl.MAX_VOLUME)
            this.volume = RemoteControl.MAX_VOLUME;
        else if(volume < RemoteControl.MIN_VOLUME)
            this.volume = RemoteControl.MIN_VOLUME;
        else
            this.volume = volume;

        System.out.println("Audio 볼륨이 " + this.volume + " 으로 설정되었습니다.");
    }

    private int prevVolume;
    @Override
    public void setMute(boolean mute){
        if(mute){
            System.out.println("Audio가 묵음처리되었습니다.");
            prevVolume = this.volume;
            setVolume(RemoteControl.MIN_VOLUME);
        }
        else{
            setVolume(prevVolume);
            System.out.println("Audio 묵음이 해제되었습니다. 현재 볼륨 : " + this.volume);
        }
    }
}
