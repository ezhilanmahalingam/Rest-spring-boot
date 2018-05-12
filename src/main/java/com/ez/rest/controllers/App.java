package com.ez.rest.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ez.rest" })
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}