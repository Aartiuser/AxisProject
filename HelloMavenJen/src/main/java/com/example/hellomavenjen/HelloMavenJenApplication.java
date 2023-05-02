package com.example.hellomavenjen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloMavenJenApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloMavenJenApplication.class, args);
        System.out.println("Hello World!");
    }

}
