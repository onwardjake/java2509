import java.util.Scanner;

public class Banking {
    public static void main(String[] args){
        long deposit = 0;
        Scanner scan = new Scanner(System.in);
        String strDeposit = "";
        String strInput = "";

        ExitLoop: while(true){
            System.out.println("---------------------------------------");
            System.out.println("1. 예금  |  2. 출금  |  3. 잔고  |  4. 종료");
            System.out.println("---------------------------------------");

            System.out.print("선택 > ");
            strInput = scan.nextLine();

            switch(strInput){
                case "1" :
                    System.out.print("예금액 > ");
                    strDeposit = scan.nextLine();
                    deposit += Integer.parseInt(strDeposit);
                    break;
                case "2" :
                    System.out.print("출금액 > ");
                    strDeposit = scan.nextLine();
                    deposit -= Integer.parseInt(strDeposit);
                    break;
                case "3" :
                    System.out.println("잔고> " + deposit);
                    break;
                case "4" :
                    System.out.println("프로그램 종료");
                    break ExitLoop;
                default :
                    System.out.println("입력이 올바르지 않습니다. 다시 시도해주세요.");
                    break;
            }
        }

        scan.close();
    }
}
