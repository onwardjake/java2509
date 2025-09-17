package ch14.sec05.exam03;

public class YieldEx {
    public static void main(String[] args) {
        WorkThread t1 = new WorkThread("TAAAAA");
        WorkThread t2 = new WorkThread("TBBBBB");
        t1.start();
        t2.start();

        // 200ms 후에 t1.work를 false로 바꿔서 다른 스레드에 양보한다.
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {}
        t1.work = false;

        // 500ms 후에 t1.work를 true로 바꿔서 t1, t2가 번갈아가면서 수행되도록 한다.
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {}
        t1.work = true;


    }
}
