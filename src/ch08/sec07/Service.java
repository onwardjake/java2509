package ch08.sec07;

public interface Service {
    default void defaultMethod1(){
        System.out.println("defaultMethod1");
        defaultCommon();
    }

    default void defaultMethod2(){
        System.out.println("defaultMethod2");
        defaultCommon();
    }

    default void defaultMethod3(){
        System.out.println("defaultMethod3");
        defaultCommon();
        staticCommon();
    }

    private void defaultCommon() {
        System.out.println("private defaultCommon");
    }

    static void staticMethod1(){
        System.out.println("staticMethod1");
        staticCommon();
    }

    static void staticMethod2(){
        System.out.println("staticMethod2");
        staticCommon();
    }

    private static void staticCommon(){
        System.out.println("private staticCommon");
    }
}
