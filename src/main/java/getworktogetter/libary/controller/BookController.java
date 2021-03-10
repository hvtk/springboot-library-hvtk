package getworktogetter.libary.controller;

import getworktogetter.libary.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import getworktogetter.libary.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService BookService;

    @GetMapping(value = "/books")
    public ResponseEntity<Object> getBooks() {
        List<Book> books = BookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable("id") long id) {
        return new ResponseEntity<>(BookService.getBook(id), HttpStatus.OK);
    }

    @PostMapping(value = "/books")
    public ResponseEntity<Object> createBook(@RequestBody Book book) {
        BookService.save(book);
        return new ResponseEntity<>("Book created", HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") long id) {
        BookService.deleteById(id);
        return new ResponseEntity<>("Book deleted", HttpStatus.OK);
    }
}

