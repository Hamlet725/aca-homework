package old;

import java.util.*;

class Solution9 {

    static ArrayList<String> sortPeople = new ArrayList<>();
    static ArrayList<Person> people = new ArrayList<>();
    static Person heirToTheThrone;
    static String heirToTheThroneName;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            String parent = in.next();
            int birth = in.nextInt();
            String death = in.next();
            String religion = in.next();
            String gender = in.next();
            Person person = new Person(name, parent, birth, death, religion, gender);
            if (parent.equals("-")) {
                heirToTheThrone = person;
                heirToTheThroneName = name;
            }
            if (!parent.equals("-")) {
                people.add(person);
            }
        }
        ArrayList<String> strings = ratifyByName(people, heirToTheThrone);
        if (heirToTheThrone.getDeath().equals("-")) {
            System.out.println(heirToTheThroneName);
        }
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> ratifyByName(ArrayList<Person> people1, Person parent) {
        ArrayList<Person> people = new ArrayList<>();
        for (Person person : people1) {
            if (parent.getName().equals(person.getParent())) {
                people.add(person);
            }
        }
        return ratifyByGender(people);
    }

    public static ArrayList<String> ratifyByGender(ArrayList<Person> people) {
        ArrayList<Person> mPeople = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender().equals("M")) {
                mPeople.add(person);
            }
        }
        ArrayList<Person> temp1 = new ArrayList<>(sortFromBigToSmall(mPeople));
        mPeople = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender().equals("F")) {
                mPeople.add(person);
            }
        }
        temp1.addAll(sortFromBigToSmall(mPeople));
        return takeOutTheDeathsAndCatholicsAndGetTheNamesInOrder(temp1);
    }

    public static ArrayList<Person> sortFromBigToSmall(ArrayList<Person> people) {
        for (int i = 0; i < people.size(); i++) {
            for (int j = 0; j < people.size() - i - 1; j++) {
                if (people.get(j).getBirth() > people.get(j + 1).getBirth()) {
                    Person temp = people.get(j);
                    people.set(j, people.get(j + 1));
                    people.set(j + 1, temp);
                }
            }
        }
        return people;
    }

    public static ArrayList<String> takeOutTheDeathsAndCatholicsAndGetTheNamesInOrder(ArrayList<Person> people) {
        for (Person person : people) {
            if ((person.getDeath().equals("-")) && !person.getReligion().equals("Catholic")) {
                sortPeople.add(person.getName());
            }
            ratifyByName(Solution9.people, person);
        }
        return Solution9.sortPeople;
    }
}

class Person {
    private String name;
    private String parent;
    private int birth;
    private String death;
    private String religion;
    private String gender;

    public Person(String name, String parent, int birth, String death, String religion, String gender) {
        this.name = name;
        this.parent = parent;
        this.birth = birth;
        this.death = death;
        this.religion = religion;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getParent() {
        return parent;
    }

    public int getBirth() {
        return birth;
    }

    public String getDeath() {
        return death;
    }

    public String getReligion() {
        return religion;
    }

    public String getGender() {
        return gender;
    }
}