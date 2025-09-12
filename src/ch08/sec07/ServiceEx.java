package ch08.sec07;

public class ServiceEx implements Service{
    public static void main(String[] args) {
        Service svc = new ServiceEx();

        svc.defaultMethod1();
        svc.defaultMethod2();
        svc.defaultMethod3();

        Service.staticMethod1();
        Service.staticMethod2();
    }
}
