package ru.me.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.me.models.ReadingRoom;
import ru.me.services.ReadingRoomService;
import ru.me.utils.OrderBookErorrs;

import java.security.Principal;
import java.util.List;

/**
 * Created by Александр on 06.01.2019.
 */
@RestController
@RequestMapping("/readingRoom")
public class ReadingRoomController {

    @Autowired
    ReadingRoomService readingRoomService;

    @RequestMapping(value = "/orderBook", method = RequestMethod.PUT)
    public synchronized String orderBook(@RequestParam(value = "bookName") String bookName, Model model, Principal principal){

        OrderBookErorrs result = readingRoomService.orderBook(bookName, principal.getName());

        if (result.equals(OrderBookErorrs.OK)) return result.getErrorDescrption() + " - " + bookName;
        return result.getErrorDescrption();
    }

    @RequestMapping(value = "/getAllOrders", method = RequestMethod.GET)
    public synchronized List<ReadingRoom> getAllOrders(){
        return readingRoomService.getAllOrders();
    }

    @RequestMapping(value = "/returnBook", method = RequestMethod.DELETE)
    public synchronized String returnBook(@RequestParam(value = "bookName") String bookName, Model model, Principal principal){
        return readingRoomService.returnBook(bookName, principal.getName());
    }
}
