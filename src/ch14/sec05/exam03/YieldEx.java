package ch14.sec05.exam03;

public class YieldEx {
    public static void main(String[] args) {
        WorkThread t1 = new WorkThread("TAAAAA");
        WorkThread t2 = new WorkThread("TBBBBB");
        t1.start();
        t2.start();

        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {}
        t1.work = false;

        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {}
        t1.work = true;


    }
}
