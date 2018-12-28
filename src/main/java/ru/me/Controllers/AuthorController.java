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
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addAuthor(@RequestBody Author author){
        authorService.createAuthor(author);
        return new ResponseEntity("Author saved successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public synchronized List<Author> getAuthor(){
        List<Author> authorList = authorService.findAll();
        return authorList;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public synchronized List<Author> findAuthorByName(String name) {
        return authorService.findAuthorByName(name);
    }

}
