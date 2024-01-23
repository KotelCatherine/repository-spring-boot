package ru.cotel.repositoryspringboot;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class Student {
    private static int idCounter = 1;
    private final int id;
    private String name;
    private String groupName;


    @JsonCreator
    public Student(String name, String groupName) {
        this.id = idCounter++;
        this.name = name;
        this.groupName = groupName;
    }
}
