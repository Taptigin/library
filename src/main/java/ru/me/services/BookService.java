package ru.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.me.models.Book;
import ru.me.models.Book_;
import ru.me.repository.BookRepository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Александр on 28.12.2018.
 */
@Service
public class BookService {

    @Autowired
    private EntityManager em;

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createBook(Book book) throws Exception{
        bookRepository.save(book);
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Long getCountBookByBookName(String bookName){
        return bookRepository.count((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Book_.name), bookName));
    }

    public Long getBookIdByBookName(String bookName){
        return bookRepository.findAllByName(bookName).get(0).getId();
    }
}
