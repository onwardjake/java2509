public class BitLogicEx {
    public static void main(String[] args){
        // 45 00101101
        // 25 00011001
        System.out.println("45 & 25 = " + (45 & 25));
        System.out.println("45 | 25 = " + (45 | 25));
        System.out.println("45 ^ 25 = " + (45 ^ 25)); // 00110100

        // 11010010 -> 최상위 비트를 제외한 나머지의 보수 0101101에 1을 더하고 - 부호를 붙인다
        // 1 4 8 32 = 45에 1을 더하면 46이므로 -46이 된다.
        System.out.println("~45 = " + ~45);

        byte receiveData = -120; // 10001000

        int unsignedInt1 = receiveData & 255;
        System.out.println(unsignedInt1);

        int unsignedInt2 = Byte.toUnsignedInt(receiveData);
        System.out.println(unsignedInt2);

        int test = 136; // 10001000
        byte btest = (byte)test;
        System.out.println(btest);
    }

}
