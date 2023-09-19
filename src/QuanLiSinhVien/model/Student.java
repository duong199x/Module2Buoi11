package QuanLiSinhVien.model;

import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private String gender;
    private double[] point;
    private static int idIncrement = 1;

    public Student(String name, String gender, double[] point) {
        this.id = idIncrement;
        this.name = name;
        this.gender = gender;
        this.point = point;
        idIncrement++;
    }

    public Student(int id, String name, String gender, double[] point) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double[] getPoint() {
        return point;
    }

    public void setPoint(double[] point) {
        this.point = point;
    }

    public static int getIdIncrement() {
        return idIncrement;
    }

    public static void setIdIncrement(int idIncrement) {
        Student.idIncrement = idIncrement;
    }

    public double average() {
        double sum = 0;
        for (int i = 0; i < point.length; i++) {
            sum += point[i];
        }
        return sum / point.length;
    }

    @Override
    public String toString() {
        return "Học sinh thứ " + id +
                ", tên là: " + name +
                ", giới tính: " + gender +
                ", điểm toán-văn-anh: " + Arrays.toString(point);
    }
}
