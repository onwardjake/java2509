package ch06.quiz;

public class Account {
    String acc;
    String name;
    int balance;

    Account(String acc, String name, int amt){
        this.acc = acc;
        this.name = name;
        balance = amt;
    }

    void deposit(int amt){
        balance += amt;
    }

    boolean withdraw(int amt){
        if(balance < amt)
            return false;
        else{
            balance -= amt;
            return true;
        }
    }

    int getBalance(){
        return balance;
    }
}
