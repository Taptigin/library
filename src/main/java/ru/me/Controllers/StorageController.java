package ru.me.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.me.services.BookService;
import ru.me.services.StorageService;

/**
 * Created by Александр on 04.01.2019.
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/getCountBookByName", method = RequestMethod.GET)
    public synchronized Integer getCountBookByName (@RequestParam(value = "bookName") String bookName){
        Long bookId = bookService.getBookIdByBookName(bookName);
        return storageService.getCountBookByBookId(bookId);
    }

    @RequestMapping(value = "/incrementBookCountByBookNameAndBookCount", method = RequestMethod.POST)
    public synchronized ResponseEntity incrementBookCountByBookNameAndBookCount(@RequestParam("bookName") String bookName,
                                                                                @RequestParam("bookCount") int bookCount){
        try{
            bookCount = bookCount > 0 ? bookCount : 0;
            storageService.incrementBookCountByBookNameAndBookCount(bookName, bookCount);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("Книга с названием - " + bookName + " не найдена", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Количество книг - " + bookName + " равно " +
                storageService.getCountBookByBookId(bookService.getBookIdByBookName(bookName)), HttpStatus.OK);
    }

    @RequestMapping(value = "decrementBookCountByBookNameAndBookCount", method = RequestMethod.POST)
    public synchronized ResponseEntity decrementBookCountByBookNameAndBookCount(@RequestParam("bookName") String bookName,
                                                                                @RequestParam("bookCount") int bookCount){

        storageService.decrementBookCountByBookNameAndBookCount(bookName, bookCount);
        return new ResponseEntity("Количество книг - " + bookName + " равно " +
                storageService.getCountBookByBookId(bookService.getBookIdByBookName(bookName)), HttpStatus.OK);
    }
}
