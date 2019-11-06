package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService extends DatabaseService {

    public List<Book> getAllBooks() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM book")
                        .mapToBean(Book.class)
                        .list()
        );
    }

    public void addBook(Book book) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO book (id, title, isbn, noOfCopies, noAvailable) " +
                        "VALUES (:id, :title, :isbn, :noOfCopies, :noAvailable)")
                .bind("id", book.getId())
                .bind("title", book.getTitle())
                .bind("isbn", book.getIsbn())
                .bind("noOfCopies", book.getNoOfCopies())
                .bind("noAvailable", book.getNoAvailable())
                .execute()
        );
    }

    //TODO finish code to updated individual book properties
    public void updateBook(String columnName, String newValue, int bookID) {
        jdbi.withHandle(handle ->
                handle.createUpdate("UPDATE book SET " + columnName +  "= " + newValue + " WHERE id= :id")
                .bind("id", bookID)
                .execute()
        );
    }

    public void deleteBook(int bookID) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM book WHERE id = :id")
                        .bind("id", bookID)
                        .execute()
        );
    }
}
