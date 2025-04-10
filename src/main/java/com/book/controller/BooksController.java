package com.book.controller;

import com.book.dto.BooksDto;
import com.book.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/books")
public class BooksController {

    private final BooksService bookService;

    public BooksController(BooksService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getBooks(Model model,
                           @RequestParam(required = false) String title,
                           @RequestParam(required = false) String brand,
                           @RequestParam(required = false) Integer year,
                           @RequestParam(required = false, defaultValue = "10") Integer limit) {
        if (title != null && title.isEmpty()) title = null;
        if (brand != null && brand.isEmpty()) brand = null;

        List<BooksDto> books = bookService.getBooks(title, brand, year, limit);

        model.addAttribute("books", books);
        model.addAttribute("title", title);
        model.addAttribute("brand", brand);
        model.addAttribute("year", year);
        model.addAttribute("limit", limit);

        return "books";
    }

    @GetMapping("/create")
    public String createBook(Model model) {
        model.addAttribute("book", new BooksDto());
        return "createBook";
    }

    @PostMapping("/create")
    public String createBooks(@ModelAttribute BooksDto booksDto) {
        bookService.createBooks(booksDto);
        return "redirect:/api/books";
    }

    @GetMapping("/update/{id}")
    public String updateBook(Model model, @PathVariable Long id) {
        BooksDto book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @PostMapping("/update/{id}")
    public String updateBooks(@PathVariable Long id, @ModelAttribute BooksDto booksDto) {
        bookService.updateBooks(id, booksDto);
        return "redirect:/api/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBooks(id);
        return "redirect:/api/books";
    }
}


