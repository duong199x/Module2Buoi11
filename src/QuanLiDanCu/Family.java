package QuanLiDanCu;

import java.util.ArrayList;

public class Family {
    private ArrayList<Person> people;
    private int numberHouse;
    private int numberPerson;
    private static int numberHouseIncrement = 0;

    public Family() {
        this.numberHouse = ++numberHouseIncrement;
        this.people = new ArrayList<>();
        this.numberPerson = 0;
    }

    public int getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(int numberHouse) {
        this.numberHouse = numberHouse;
    }

    public void addPerson(Person person) {
        this.people.add(person);
        this.numberPerson++;
    }

    public ArrayList<Person> getPeople() {
        return this.people;
    }
}
