package quiz.d0916;

import quiz.d0916.abst.AbstMain;
import quiz.d0916.ext.ExtMain;
import quiz.d0916.inter.InterfaceMain;
import quiz.d0916.poly.PolymorphismMain;

public class Main {
    public static void main(String[] args) {
        // 상속
        ExtMain em = new ExtMain();

        // 추상 클래스
        AbstMain am = new AbstMain();

        // 다형성
        PolymorphismMain pm = new PolymorphismMain();

        // 인터페이스
        InterfaceMain im = new InterfaceMain();
    }
}
