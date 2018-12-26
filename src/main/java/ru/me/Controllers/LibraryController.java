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




    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public synchronized String getAuthor(){
        List<Author> authorList = authorService.findAllByName("Тестовый автор 1");
        return authorList.get(0).getName();
    }

}
