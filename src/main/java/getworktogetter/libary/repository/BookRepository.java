package getworktogetter.libary.repository;

import getworktogetter.libary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository <Book, Long> {
    @Override
    List<Book> findAllByTitleStartingWith(String title);
}
