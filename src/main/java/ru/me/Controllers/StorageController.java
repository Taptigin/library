package ru.me.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    public synchronized Integer getCountBookByName (@RequestParam(value = "bookName") String bookName){
        Long bookId = bookService.getBookIdByBookName(bookName);
        return storageService.getCountBookByBookId(bookId);
    }
}
