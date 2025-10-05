package com.clf.juc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

@SpringBootApplication
public class JucLearningApplication {

    public static void main(String[] args) {

        SpringApplication.run(JucLearningApplication.class, args);
        System.out.println("Hello World");


    }



}
