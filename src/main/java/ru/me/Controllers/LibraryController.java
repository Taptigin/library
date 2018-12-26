package ru.me.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.me.models.Author;
import ru.me.services.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private AuthorService authorService;


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
        List<Author> authorList = authorService.findAllByName("Тестовый автор 1");
        return authorList.get(0).getName();
    }

}
