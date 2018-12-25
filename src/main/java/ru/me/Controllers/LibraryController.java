package ru.me.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.me.Services.LibraryService;
import ru.me.models.Author;

@RestController
@RequestMapping("/library")
public class LibraryController {
    private ApplicationContext context = new ClassPathXmlApplicationContext("SpringContext.xml");
    private LibraryService libraryService = (LibraryService) context.getBean("storageService");
   // private LibraryService libraryService;


    @Autowired
    public void setLibraryService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public static void main(String[] args) {
        new LibraryController().start();
    }

    void start(){
        Author author =  libraryService.getAuthorByName("Тестовый автор 1");
        System.out.println(author.getName());
    }

}
