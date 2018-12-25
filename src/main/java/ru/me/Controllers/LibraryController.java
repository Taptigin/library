package ru.me.Controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.me.models.Author;
import ru.me.services.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("SpringContext.xml");
    private static LibraryService libraryService = (LibraryService) context.getBean("storageService");
   // private LibraryService libraryService;


//    @Autowired
//    public void setLibraryService(LibraryService libraryService) {
//        this.libraryService = libraryService;
//    }

//    public static void main(String[] args) {
//        new LibraryController().start();
//    }
//
//    void start(){
//        Author author =  libraryService.getAuthorByName("Тестовый автор 1");
//        System.out.println(author.getName());
//    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String getAuthor(){
        Author author =  libraryService.getAuthorByName("Тестовый автор 1");
        return author.getName();
    }

}
