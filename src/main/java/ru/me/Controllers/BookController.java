package ru.me.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.me.models.Book;
import ru.me.services.BookService;

import java.util.List;

/**
 * Created by Александр on 28.12.2018.
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public synchronized ResponseEntity addBook(@RequestBody Book book){
        bookService.createBook(book);
        return new ResponseEntity("Book saved successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public synchronized List<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @RequestMapping(value = "/getCount", method = RequestMethod.GET)
    public synchronized Long getBookCountByName(String name){
        return bookService.getCountBookByBookName(name);
    }
}
