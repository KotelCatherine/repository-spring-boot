package ru.cotel.repositoryspringboot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    /**
     * Запрос на получение полного списка студентов
     *
     * @return - Выводит список всех студентов
     */
    @GetMapping("/all")
    public List<Student> getAllStudent() {
        return repository.getAll();
    }

    /**
     * Запрос на получение данных о студенте по id
     *
     * @param id - Идентификационный номер студента
     * @return - Выводит данные студента
     */
    @GetMapping(value = "/{id}")
    public Student getByName(@PathVariable int id) {
        return repository.getById(id);
    }

    /**
     * Запрос на получение списка студентов определенной кафедры
     *
     * @param groupName - Название кафедры
     * @return - Выводит список студентов
     */
    @GetMapping("/group/{groupName}/students")
    public List<Student> getByGroupName(@PathVariable String groupName) {
        return repository.getByGroupName(groupName);
    }

    /**
     * Запрос на получние данных студента по его ФИ
     *
     * @param name - Строка с фамилией и именем
     * @return - Выводит данные студента
     */
    @GetMapping("/search")
    public Student getByName(@RequestParam String name) {
        return repository.getByName(name);
    }

    /**
     * Запрос на добавление студента в репозиторий
     *
     * @param student - Объект с данными
     * @return - Выводит обновленный список студентов
     */
    @PostMapping
    public List<Student> addStudent(@RequestBody Student student) {
        return repository.saveUpdateStudent(student);
    }

    /**
     * Запрос на удаление студента по id
     *
     * @param id - Идентификационный номер студента
     * @return - Выводит обновленный список студентов
     */
    @DeleteMapping("/{id}")
    public List<Student> deleteStudentById(@PathVariable int id) {
        return repository.deleteStudent(id);
    }
}
