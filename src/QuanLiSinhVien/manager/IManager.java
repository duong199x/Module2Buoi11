package QuanLiSinhVien.manager;

import java.util.ArrayList;

public interface IManager<E> {
    void add(E e);

    void delete(int id);

    void update(int id, E e);

    int findIndexById(int id);

    ArrayList<E> findListName(String name);

    ArrayList<E> averageMaxPoint();

    ArrayList<E> findall();


}
