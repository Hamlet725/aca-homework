public class Person {
    String name;
    double balance;
    Company company;

    void sendMoney(Person otherPerson, double amount) {
        otherPerson.balance += amount;
        balance -= amount;
    }
    }

