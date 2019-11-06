package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Technology;
import org.softwire.training.bookish.models.page.AboutPageModel;
import org.softwire.training.bookish.models.page.BooksDetailModel;
import org.softwire.training.bookish.models.page.BooksPageModel;
import org.softwire.training.bookish.services.BooksService;
import org.softwire.training.bookish.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping("")
    ModelAndView books() {

        List<Book> books = booksService.getAllBooks();

        BooksPageModel booksPageModel = new BooksPageModel();
        booksPageModel.setBooks(books);


        return new ModelAndView("books", "model", booksPageModel);
    }

    @RequestMapping("/add-book")
    RedirectView addBook(@ModelAttribute Book book) {

        booksService.addBook(book);

        return new RedirectView("/books");
    }

    @RequestMapping("/delete-book")
    RedirectView deleteBook(@RequestParam int bookID) {

        booksService.deleteBook(bookID);

        return new RedirectView("/books");
    }

    @RequestMapping("/book-detail/{id}")
    ModelAndView displayBook(@PathVariable("id") int bookID) {

        Book book = booksService.getBook(bookID);

        BooksDetailModel booksDetailModel = new BooksDetailModel();
        booksDetailModel.setBook(book);

        return new ModelAndView("/book-detail", "model", booksDetailModel);
    }

    @RequestMapping("/update-book")
    RedirectView updateBook(@ModelAttribute Book book) {

        booksService.updateBook(book);

        return new RedirectView("/books");
    }

}
