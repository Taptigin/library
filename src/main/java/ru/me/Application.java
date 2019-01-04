package ru.me;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ru.me.services.AuthorService;
import ru.me.services.BookService;
import ru.me.services.StorageService;


@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application  {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private StorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
