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

//    @RequestMapping(value = "/addAuthor", method = RequestMethod.PUT)
//    public synchronized void addAuthor(@RequestParam(value = "name") String name){
//        Author author = new Author();
//        author.setName(name);
//        authorService.createAuthor(author);
//    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
    public ResponseEntity saveProduct(@RequestBody Author author){
        authorService.createAuthor(author);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }


//    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
//    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product){
//        Product storedProduct = productService.getProductById(id);
//        storedProduct.setDescription(product.getDescription());
//        storedProduct.setImageUrl(product.getImageUrl());
//        storedProduct.setPrice(product.getPrice());
//        productService.saveProduct(storedProduct);
//        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
//    }


    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public synchronized String getAuthor(){
        List<Author> authorList = authorService.findAllByName("Тестовый автор 1");
        return authorList.get(0).getName();
    }

}
