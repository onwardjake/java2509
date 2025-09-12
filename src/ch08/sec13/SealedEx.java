package ch08.sec13;

public class SealedEx {
    public static void main(String[] args) {
        ImplClass impl = new ImplClass();

        IF1 if1 = impl;
        if1.m1();

        IF3 if3 = impl;
        if3.m1();
        if3.m3();

        IF4 if4 = impl;
        if4.m1();
        if4.m3();
        if4.m4();
    }
}
