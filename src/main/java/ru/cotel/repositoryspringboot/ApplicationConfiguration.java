package ru.cotel.repositoryspringboot;

import org.springframework.context.annotation.Bean;

public class ApplicationConfiguration {

    @Bean
    StudentRepository myStudentRepository(){
        return new StudentRepository();
    }
}
