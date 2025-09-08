package ch08.sec02;

public class RemoteControlEx {
    public static void main(String[] args) {
        RemoteControl rc = new Television();
        rc.turnOn();

        RemoteControl rc2 = new Audio();
        rc2.turnOn();

        System.out.println("최대 볼륨 : " + RemoteControl.MAX_VOLUME);
        System.out.println("최소 볼륨 : " + RemoteControl.MIN_VOLUME);

        rc.setVolume(100);
        rc2.setVolume(5);

        rc.setMute(true);
        rc.setMute(false);

        rc2.setMute(true);
        rc2.setMute(false);

        RemoteControl.changeBattery();
    }
}
