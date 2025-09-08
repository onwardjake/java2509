package ch06.quiz;

import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        int select, i, amt;
        int accRegistered = 0;
        String acc, name, strAmt;
        Scanner scanner = new Scanner(System.in);
        Account[] accList = new Account[100];
        System.out.println("Account length: " + accList.length);
            
        Outer: while(true){
            System.out.println("----------------------------------------------------------------");
            System.out.println("1. 계좌 생성  | 2. 계좌 목록  |  3. 예금  |  4. 출금  |  5. 종료");
            System.out.println("----------------------------------------------------------------");

            System.out.print("선택 > ");
            select = Integer.parseInt(scanner.nextLine());

            switch (select){
                case 1 : // 신규 계좌 생성
                    System.out.println("--------");
                    System.out.println("계좌 생성");
                    System.out.println("--------");
                    while(true){
                        System.out.print("계좌 번호:");
                        acc = scanner.nextLine();
                        if(!acc.isEmpty())
                            break;
                    }
                    while(true){
                        System.out.print("계좌주:");
                        name = scanner.nextLine();
                        if(!name.isEmpty())
                            break;
                    }
                    while(true){
                        System.out.print("초기 입금액:");
                        strAmt = scanner.nextLine();
                        if(!acc.isEmpty()){
                            amt = Integer.parseInt(strAmt);
                            break;
                        }
                    }

                    accList[accRegistered++] = new Account(acc, name, amt);
                    System.out.println("결과: 계좌가 생성되었습니다.");
                    break;

                case 2 : // 계좌 목록 출력
                    System.out.println("--------");
                    System.out.println("계좌 목록");
                    System.out.println("--------");
                    if(accRegistered == 0)
                        System.out.println("등록된 계좌가 없습니다.");
                    else{
                        for(i=0; i<accRegistered; i++)
                            System.out.println(accList[i].acc + "\t" + accList[i].name + "\t" + accList[i].balance);
                    }
                    break;

                case 3 : // 입금
                    System.out.println("--------");
                    System.out.println("예금");
                    System.out.println("--------");

                    while(true){
                        System.out.print("계좌 번호:");
                        acc = scanner.nextLine();
                        if(!acc.isEmpty())
                            break;
                    }
                    while(true){
                        System.out.print("예금액:");
                        strAmt = scanner.nextLine();
                        if(!acc.isEmpty()){
                            amt = Integer.parseInt(strAmt);
                            break;
                        }
                    }

                    for(i=0; i<accRegistered; i++){
                        if(accList[i].acc.equals(acc)){
                            accList[i].deposit(amt);
                            // accList[i].balance += amt;
                            System.out.println("결과: 입금이 완료되었습니다. 잔액: " + accList[i].getBalance());
                            break;
                        }
                    }
                    if(i >= accRegistered)
                        System.out.println("입력하신 계좌번호는 존재하지 않습니다.");
                    break;

                case 4 : // 출금
                    System.out.println("--------");
                    System.out.println("출금");
                    System.out.println("--------");

                    while(true){
                        System.out.print("계좌 번호:");
                        acc = scanner.nextLine();
                        if(!acc.isEmpty())
                            break;
                    }
                    while(true){
                        System.out.print("출금액:");
                        strAmt = scanner.nextLine();
                        if(!acc.isEmpty()){
                            amt = Integer.parseInt(strAmt);
                            break;
                        }
                    }

                    for(i=0; i<accRegistered; i++){
                        if(accList[i].acc.equals(acc)){
                            if(accList[i].withdraw(amt)){
                                System.out.println("결과: 출금이 완료되었습니다. 잔액: " + accList[i].getBalance());
                            }
                            else{                                
                                System.out.println("출금에 실패했습니다. 잔액과 출금 요청액을 확인해주세요.");
                                System.out.println("잔액: " + accList[i].getBalance());
                                System.out.println("출금 요청액: " + amt);
                            }                            
                            break;
                        }
                    }
                    if(i >= accRegistered)
                        System.out.println("입력하신 계좌번호는 존재하지 않습니다.");
                    break;

                case 5 : // 프로그램 종료
                    System.out.println("프로그램 종료");
                    break Outer;

                default :
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }
        }

        scanner.close();
    }
}
