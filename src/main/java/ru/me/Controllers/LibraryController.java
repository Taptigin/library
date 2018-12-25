package ru.me.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.me.Services.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private LibraryService productService;


}
