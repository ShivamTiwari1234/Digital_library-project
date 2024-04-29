package com.example.Minorproject.Digital.library.Controller;

import com.example.Minorproject.Digital.library.Models.Book;
import com.example.Minorproject.Digital.library.Responce.BookSearchResponce;
import com.example.Minorproject.Digital.library.enums.BookFilterType;
import com.example.Minorproject.Digital.library.requests.BookCreateRequest;
import com.example.Minorproject.Digital.library.service.BookServiceInterf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    @Autowired
    BookServiceInterf bookServiceInterf;

    @PostMapping("/saveBook")
    public ResponseEntity saveBook(@Valid @RequestBody BookCreateRequest bookCreateRequest){
        Book book = bookServiceInterf.saveBook(bookCreateRequest);
        return new ResponseEntity(book, HttpStatus.CREATED);
    }

    @GetMapping("/books/search")
    public List<BookSearchResponce> findBooks(@RequestParam("filter") BookFilterType bookFilterType,
                                              @RequestParam("value") String value){
        return bookServiceInterf.findBooks(bookFilterType, value).stream()
                .map(Book::toBookSearchResponce)
                .collect(Collectors.toList());

    }
}
