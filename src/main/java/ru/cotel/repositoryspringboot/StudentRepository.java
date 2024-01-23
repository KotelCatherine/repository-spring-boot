package ru.cotel.repositoryspringboot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student("Пономарев Иван", "ПИ"));
        students.add(new Student("Калинина Ангелина", "ИВТ"));
        students.add(new Student("Котельников Владислав", "ИС"));
        students.add(new Student("Прусс Михаил", "ИВТ"));
        students.add(new Student("Борсуков Петр", "ПИ"));
        students.add(new Student("Шуликова Марина", "ИС"));
        students.add(new Student("Колпаков Станислав", "ПИ"));
        students.add(new Student("Погранцов Евгений", "ИВТ"));
        students.add(new Student("Кипелов Арсений", "ИВТ"));
        students.add(new Student("Николенко Ян", "ПИ"));
    }


    /**
     * @return Возвращает список всех студентов
     */
    public List<Student> getAll() {
        return List.copyOf(students);
    }

    /**
     * Поиск студента по имени
     *
     * @param name - Имя студента
     * @return - Возвращает студента, если найден
     */
    public Student getByName(String name) {
        return students.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Фильтр списка по названию группы
     *
     * @param groupName - Название группы
     * @return - Возвращает список студентов группы
     */
    public List<Student> getByGroupName(String groupName) {
        return students.stream()
                .filter(it -> Objects.equals(it.getGroupName(), groupName))
                .collect(Collectors.toList());
    }

    /**
     * Поиск студента по id
     *
     * @param id -Идентификационный номер студента
     * @return - Возвращает данные о студенте, если найден
     */
    public Student getById(int id) {
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Добавление нового студента
     *
     * @param student - Данные нового студента
     * @return - Возращает обновленный список студентов
     */
    public List<Student> saveUpdateStudent(Student student) {
        students.add(student);
        return getAll();
    }

    /**
     * Удаляет данные студента по id
     *
     * @param id - Идентификационный номер студента
     * @return - Возвращает обновленный список студентов
     */
    public List<Student> deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        return getAll();
    }
}
