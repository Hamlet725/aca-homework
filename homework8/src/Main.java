public class Main {
    public static void main(String[] args) {

        Company A = new Company();
        Company B = new Company();
        
        A.CompanyName = "AAA";
        B.CompanyName = "BBB";

        Person A1 = new Person();
        Person A2 = new Person();
        Person A3 = new Person();
        Person B1 = new Person();
        Person B2 = new Person();
        Person B3 = new Person();

        A1.name = "Ash";    A1.balance = 20;  A1.company = A;
        A2.name = "Mash";   A2.balance = 25;  A2.company = A;
        A3.name = "Sash";   A3.balance = 52;  A3.company = A;
        B1.name = "Pash";   B1.balance = 50;  B1.company = B;
        B2.name = "Mish";   B2.balance = 32;  B2.company = B;
        B3.name = "Grish";  B3.balance = 23;  B3.company = B;

        A1.sendMoney(A2, 25);
        A2.sendMoney(A3, 52);
        B1.sendMoney(B2, 30);
        B2.sendMoney(B3, 65);
        
        Person[] person = new Person[] {A1, A2, A3, B1, B2, B3};

        double bal1 = 0, bal2 = 0;
        Person mostBalance = A2;
        for (int i = 0; i < 6; i++) {
            if (person[i].balance > mostBalance.balance) {
                mostBalance = person[i];
            }
            if (person[i].company == A) {
                bal1 += person[i].balance;
            } else {
                bal2 += person[i].balance;
            }
        }
        System.out.println("The perso with most balance is: " +  mostBalance.name + " from company " +  mostBalance.company.CompanyName);
        System.out.println();
        if (bal2 > bal1) {
            System.out.println("The highest value company is: " + B.CompanyName);
        } else {
            System.out.println("The highest value company is: " + A.CompanyName);
        }

    }
}
