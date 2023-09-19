package QuanLiSinhVien.manager;

import QuanLiSinhVien.model.Student;

import java.util.ArrayList;

public class ManagerStudent implements IManager<Student> {
    ArrayList<Student> list;

    public ManagerStudent() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(Student student) {
        list.add(student);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        list.remove(index);
    }

    @Override
    public void update(int id, Student student) {
        int idEdit = findIndexById(id);
        list.set(idEdit, student);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Student searchById(int id) {
        int idsearch = findIndexById(id);
        return list.get(idsearch);
    }

    @Override
    public ArrayList<Student> findListName(String name) {
        ArrayList<Student> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }

    @Override
    public ArrayList<Student> averageMaxPoint() {
        double max = list.get(0).average();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).average() > max) {
                max = list.get(i).average();
            }
        }
        ArrayList<Student> maxPointStudent = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).average() == max) {
                maxPointStudent.add(list.get(i));
            }
        }
        return maxPointStudent;
    }

    @Override
    public ArrayList<Student> findall() {
        return list;
    }
}
