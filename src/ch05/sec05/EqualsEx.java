package ch05.sec05;

public class EqualsEx {
    public static void main(String[] args){
        String strVar1 = "이정재";
        String strVar2 = "이정재";

        if(strVar1 == strVar2)
            System.out.println("strVar1과 strVar2는 같은 메모리 주소를 참조합니다.");
        else
            System.out.println("strVar1과 strVar2는 다른 메모리 주소를 참조합니다.");

        if(strVar1.equals(strVar2))
            System.out.println("strVar1과 strVar2는 문자열이 같음.");
        else
            System.out.println("strVar1과 strVar2는 문자열이 다름.");

        String strVar3 = new String("이정재");
        String strVar4 = new String("이정재");

        if(strVar3 == strVar4)
            System.out.println("strVar3과 strVar4는 같은 메모리 주소를 참조합니다.");
        else
            System.out.println("strVar3과 strVar4는 다른 메모리 주소를 참조합니다.");

        if(strVar3.equals(strVar4))
            System.out.println("strVar3과 strVar4는 문자열이 같음.");
        else
            System.out.println("strVar3과 strVar4는 문자열이 다름.");

        System.out.println("---------------------------------------------");

        // replace로 대체한 문자열은 새로운 주소로 할당된다.
        String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String입니다.";
        String newStr = oldStr.replace("자바", "JAVA");

        System.out.println(oldStr);
        System.out.println(newStr);
        if(oldStr == newStr)
            System.out.println("oldStr과 newStr는 같은 메모리 주소를 참조합니다.");
        else
            System.out.println("strVar3과 newStr는 다른 메모리 주소를 참조합니다.");

        System.out.println("---------------------------------------------");

        String subject = "자바 프로그래밍";
        int location = subject.indexOf("프로그래밍");
        if(location < 0)
            System.out.println("검색 결과가 없습니다.");
        else {
            String subString = subject.substring(location);
            System.out.println(subString);

            if (subject == subString)
                System.out.println("subject와 subString은 같은 메모리 주소를 참조합니다.");
            else
                System.out.println("subject와 subString은 다른 메모리 주소를 참조합니다.");
        }

        System.out.println("---------------------------------------------");

        String[] strArr1 = new String[5];
        strArr1[0] = "봄";
        System.out.println(strArr1[0]);
    }
}
