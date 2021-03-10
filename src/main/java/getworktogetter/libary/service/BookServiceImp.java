package getworktogetter.libary.service;

import getworktogetter.libary.exception.RecordNotFoundException;
import getworktogetter.libary.model.Book;
import getworktogetter.libary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImp implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List(Book) getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(long id) {
        if (bookRepository.existsById(id)) {
            return bookRepository.findById(id).get();
        }
        else {
            throw new RecordNotFoundException("No book with id " + id);
        }
    }

    @Override
    public List<Book> getBooksTitleStartsWith(String title) {
        return bookRepository.findAllByTitleStartingWith(title);
    }

    @Override
    public void deleteByID(lomg id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException("No book with id " + id);
        }
    }
}
