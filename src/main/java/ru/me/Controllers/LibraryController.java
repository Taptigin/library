package ru.me.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.me.models.Author;
import ru.me.services.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
    public ResponseEntity addAuthor(@RequestBody Author author){
        authorService.createAuthor(author);
        return new ResponseEntity("Author saved successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public synchronized String getAuthor(){
        List<Author> authorList = authorService.findAllByName("Тестовый автор 1");
        return authorList.get(0).getName();
    }

}
