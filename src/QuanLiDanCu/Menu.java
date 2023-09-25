package QuanLiDanCu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Street street = new Street();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("===Menu khu phố===\n" + "1. Thêm hộ gia đình.\n" + "2. Hiển thị hộ gia đình");
            System.out.println("Nhập lựa chọn");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showMenuAddFamily();
                    break;
                case 2:
                    showAllFamily();
                    break;
            }
        } while (choice != 0);

    }

    public void showMenuAddFamily() {

        Family family = new Family();
        street.addFamily(family);
        System.out.println("===> thêm nhà thành công có id: " + family.getNumberHouse());
    }

    public void showAllFamily() {
        ArrayList<Family> families = street.getFamilies();
        System.out.println("danh sách các nhà");
        for (int i = 0; i < families.size(); i++) {
            System.out.println(i + 1 + ". số nhà " + families.get(i).getNumberHouse());
        }
        System.out.println("chọn nhà bạn muốn vào:");
        int choice = inputInt.nextInt();
        showMenuPerson(families.get(choice - 1));
    }

    public void showMenuPerson(Family family) {
        int choice;
        do {
            System.out.println("===Menu nhà số " + family.getNumberHouse() + "===\n1.Thêm người\n2.Hiển thị người\n0.thoát");
            System.out.println("Mời nhập");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    menuAddPerson(family);
                    break;
                case 2:
                    showAllPerson(family);
                    break;
            }
        } while (choice != 0);
    }

    public void menuAddPerson(Family family) {
        System.out.println("===Menu thêm người===");
        System.out.println("nhập tên");
        String name = inputString.nextLine();
        System.out.println("nhập tuổi");
        int age = inputInt.nextInt();
        Person person = new Person(name, age);
        family.addPerson(person);
        System.out.println("===> thêm người thành công vào nhà" + family.getNumberHouse());
    }

    public void showAllPerson(Family family) {
        ArrayList<Person> people = family.getPeople();
        System.out.println("danh sách người trong nhà");
        for (Person person : people
        ) {
            System.out.println(person);
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showMainMenu();
    }
}
