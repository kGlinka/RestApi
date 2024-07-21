package com.example.springbootapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.component.page.AppShellConfigurator;

@SpringBootApplication

@Theme(value = "my-theme")
public class SpringBootApiApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiApplication.class, args);
    }
}
