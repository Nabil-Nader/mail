package com.secandMail.controller;

 import com.secandMail.model.Book;
 import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

 import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {

    private static Map<Integer , Book> bookes = new HashMap<>();

    static {
        Book book1 = new Book(11,"Alice in Wonderland","Lewis Carrol");
        Book book2 = new Book(13,"Anna Karenina","Leo Tolstoy");

        bookes.put(book1.getId(),book1);
        bookes.put(book2.getId(),book2);
    }

//    @GetMapping("/book/{bookId}") @PathVariable("bookId")
    @RequestMapping(value = "/book") // /book?bookId=13
    public ResponseEntity<?> getBook(@RequestParam("bookId") Integer bookId){
        System.out.println("Retrivaing book");

        return new ResponseEntity<>(bookes.get(bookId), HttpStatus.OK);
    }


}
