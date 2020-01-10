package com.example.exam.controller;

import com.example.exam.entity.Book;
import com.example.exam.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ModelAndView getHomePage(@PageableDefault(size = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("books", bookService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create-book")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/book/create", "book", new Book());
    }

    @PostMapping("/create-book")
    public ModelAndView createBook(@Valid @ModelAttribute("book")Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("book/create");
            return modelAndView;
        }else {
            bookService.save(book);
            ModelAndView modelAndView = new ModelAndView("book/create");
            modelAndView.addObject("message","New Book Successfully !!!");
            return modelAndView;
        }
    }

    @GetMapping("/edit-book/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Book book = bookService.findById(id);
        if(book != null){
            return new ModelAndView("/book/edit","book",book);
        }else{
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit-book")
    public ModelAndView editBook(@Valid @ModelAttribute("book")Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("book/edit");
            return modelAndView;
        } else {
            bookService.save(book);
            ModelAndView modelAndView = new ModelAndView("book/edit");
            modelAndView.addObject("book", book);
            modelAndView.addObject("message", "Book Update Successfully !!!");
            return modelAndView;
        }
    }

    @GetMapping("/delete-book/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Book book = bookService.findById(id);
        if(book != null){
            return new ModelAndView("/book/delete","book",book);
        }else{
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/delete-book")
    public String deleteBook(@ModelAttribute("book") Book book){
        bookService.remove(book.getId());
        return "redirect:/";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "choose", required = false) String choose,@RequestParam(value = "s", required = false) String s) {
        ModelAndView modelAndView = new ModelAndView("/book/search");
        if (choose == null) {
            return new ModelAndView("/book/search");
        }
        return modelAndView;
    }

        @PostMapping("/search")
        public ModelAndView search (@RequestParam(value = "choose", required = false) String
        choose, @RequestParam(value = "s", required = false) String s, @PageableDefault(size = 10) Pageable pageable) {
            ModelAndView modelAndView = new ModelAndView("/book/search");
            if (choose == null) {
                return new ModelAndView("/book/search");
            } else if (choose.equals("id")) {
                modelAndView.addObject("books", bookService.findAllById((Long.parseLong(s))));
            } else if (choose.equals("name")) {
                modelAndView.addObject("books", bookService.findAllByBookName(s));
            }
            return modelAndView;
        }
}
