package QuanLiSinhVien.view;

import QuanLiSinhVien.manager.ManagerStudent;
import QuanLiSinhVien.model.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuStudent {
    ManagerStudent managerStudent = new ManagerStudent();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public void ShowMainMenu() {
        int choice;
        do {
            System.out.println("===Menu Student Manager===\n1.Thêm mới học sinh\n2.Xóa học sinh\n3.Sửa học sinh\n4.Tìm kiếm sinh viên theo ID\n5.Hiển thị danh sách sinh viên theo tên gần đúng\n6.Học viên có điểm trung bình lớn nhất\n7.Hiển thị tất cả\n0.Thoát");
            System.out.println("Nhập lựa chọn:");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuDelete();
                    break;
                case 3:
                    showMenuEdit();
                    break;
                case 4:
                    showMenuSearchId();
                    break;
                case 5:
                    showMenuSearchName();
                    break;
                case 6:
                    showMaxAverage();
                    break;
                case 7:
                    showAll();
                    break;
            }
        } while (choice != 0);

    }

    public void showMenuAdd() {
        System.out.println("===Menu add===");
        System.out.println("Nhập tên");
        String name = inputString.nextLine();
        System.out.println("Nhập giới tính");
        String gender = inputString.nextLine();
        System.out.println("Nhập điểm toán");
        int toan = inputInt.nextInt();
        System.out.println("Nhập điểm văn");
        int van = inputInt.nextInt();
        System.out.println("Nhập điểm anh");
        int anh = inputInt.nextInt();
        double[] arr = {toan, van, anh};
        Student student = new Student(name, gender, arr);
        managerStudent.add(student);
        System.out.println("===> Thêm thành công");
    }

    public void showMenuDelete() {
        System.out.println("===Delete Menu===");
        System.out.println("Nhập id muốn xóa");
        int idDelete = inputInt.nextInt();
        managerStudent.delete(idDelete);
        System.out.println("===> Xóa thành công");
    }

    public void showMenuEdit() {
        System.out.println("===Edit Menu===");
        System.out.println("Nhập id muốn edit:");
        int idEdit = inputInt.nextInt();
        System.out.println("Nhập tên");
        String name = inputString.nextLine();
        System.out.println("Nhập giới tính");
        String gender = inputString.nextLine();
        System.out.println("Nhập điểm toán");
        int toan = inputInt.nextInt();
        System.out.println("Nhập điểm văn");
        int van = inputInt.nextInt();
        System.out.println("Nhập điểm anh");
        int anh = inputInt.nextInt();
        double[] arr = {toan, van, anh};
        Student student = new Student(idEdit, name, gender, arr);
        managerStudent.update(idEdit, student);
        System.out.println("===> sửa thành công");
    }

    public void showMenuSearchId() {
        System.out.println("===Search Id Menu===");
        System.out.println("nhập id muốn tìm");
        int idSearch = inputInt.nextInt();
        System.out.println(managerStudent.searchById(idSearch));
    }

    public void showMenuSearchName() {
        System.out.println("===Search name===");
        System.out.println("nhập tên:");
        String name = inputString.nextLine();
        ArrayList<Student> searchStudent = managerStudent.findListName(name);
        for (Student students : searchStudent) {
            System.out.println(students);
        }
    }

    public void showMaxAverage() {
        System.out.println("Học sinh có điểm cao nhất:");
        ArrayList<Student> arrayList = managerStudent.averageMaxPoint();
        for (Student students : arrayList) {
            System.out.println(students);
        }
    }

    public void showAll() {
        ArrayList<Student> arrayList = managerStudent.findall();
        for (Student students : arrayList) {
            System.out.println(students);
        }
    }
}
