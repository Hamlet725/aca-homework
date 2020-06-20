package old;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution9_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            String parent = in.next();
            int birth = in.nextInt();
            String death = in.next();
            String religion = in.next();
            char gender = in.next().charAt(0);
            Person person = new Person(name, parent, birth, death, religion, gender);
            people.add(person);
        }

        Person root = makeTreeAndGetRoot(people);
        sortTree(root);
        printTheHeirToTheThrones(root);
    }

    public static class Person {
        public String name;
        public String parent;
        public int birth;
        public String death;
        public String religion;
        public char gender;

        public ArrayList<Person> children;

        public Person(String name, String parent, int birth, String death, String religion, char gender) {
            this.name = name;
            this.parent = parent;
            this.birth = birth;
            this.death = death;
            this.religion = religion;
            this.gender = gender;
            this.children = new ArrayList<>();
        }

        public ArrayList<Person> getChildren() {
            return children;
        }

        public void setChildren(ArrayList<Person> children) {
            this.children = children;
        }
    }

    public static void sortTree(Person parent) {
        parent.setChildren(sortAndGetChildren(parent));
        for (Person child : parent.getChildren()) {
            sortTree(child);
        }
    }

    public static void printTheHeirToTheThrones(Person parent) {
        if (parent.death.equals("-") && !parent.religion.equals("Catholic")) {
            System.out.println(parent.name);
        }
        for (Person child : parent.getChildren()) {
            printTheHeirToTheThrones(child);
        }
    }


    public static ArrayList<Person> sortAndGetChildren(Person parent) {
        ArrayList<Person> children = new ArrayList<>(parent.getChildren());
        children.sort((o1, o2) -> {
            if (o1.gender == 'M' && o2.gender == 'F') {
                return -1;
            } else if (o1.gender == 'F' && o2.gender == 'M') {
                return 1;
            } else return Integer.compare(o1.birth, o2.birth);
        });
        return children;
    }

    public static Person makeTreeAndGetRoot(ArrayList<Person> people) {
        for (Person parent : people) {
            for (Person child : people) {
                if (child.parent.equals(parent.name)) {
                    parent.getChildren().add(child);
                }
            }
        }
        for (Person person : people) {
            if (person.parent.equals("-")) {
                return person;
            }
        }
        throw new IllegalStateException("No person without parent");
    }
}
