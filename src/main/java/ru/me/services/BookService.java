package ru.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.me.models.Author;
import ru.me.models.Book;
import ru.me.models.Book_;
import ru.me.repository.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
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

    @Autowired
    private StorageService storageService;

    @Autowired
    private AuthorService authorService;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createBook(Book book) throws Exception{
        Author author = null;

        author = authorService.findOneAuthor(book.getAuthor().getId());

        try{
            System.out.println(author.getId());
        }catch (javax.persistence.EntityNotFoundException ex){
            ex.printStackTrace();
            author = new Author();
            author.setName(book.getAuthor().getName());
            authorService.createAuthor(author);
            author = authorService.findAuthorByName(author.getName()).get(0);
        }

        Book bookForSave = new Book();
        bookForSave.setName(book.getName());
        bookForSave.setAuthor(author);
        bookForSave.setReleaseDate(book.getReleaseDate());

        bookRepository.save(bookForSave);
        storageService.addNewBook(book);
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public List<Book> getAllBookByIds(List<Long> bookIds){
        return bookRepository.findAll((root, criteriaQuery, criteriaBuilder) ->
                root.get(Book_.id).in(bookIds));
    }

    public Long getCountBookByBookName(String bookName){
        return bookRepository.count((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Book_.name), bookName));
    }

    public Long getBookIdByBookName(String bookName){
        return bookRepository.findAllByName(bookName).get(0).getId();
    }

    public Book getBookByName(String bookName){
        return bookRepository.findAllByName(bookName).get(0);
    }
}
