package ch14.sec05.exam03;

public class WorkThread extends Thread {
    public boolean work = true;

    WorkThread(String name){
        setName(name);
    }

    @Override
    public void run() {
        while(true){
            if(work){
                System.out.println(getName() + ": 작업 실행");
            }
            else {
                Thread.yield();
            }
        }
    }
}
