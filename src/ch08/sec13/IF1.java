package ch08.sec13;

public sealed interface IF1 permits IF2, IF3 {
    void m1();
}
