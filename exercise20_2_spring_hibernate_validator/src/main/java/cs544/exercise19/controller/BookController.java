package cs544.exercise19.controller;

import cs544.exercise19.domain.Book;
import cs544.exercise19.service.BookService;
import cs544.exercise19.NoSuchResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/books";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("books", bookService.getAll());
		return "book/list";
	}

	@RequestMapping(value="/addBook", method=RequestMethod.GET)
	public String addBook(@ModelAttribute("newBook") Book book) {
		return "book/add";
	}

	@RequestMapping(value="/addBook", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("newBook") Book book, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "book/add";
		}
		bookService.add(book);
		return "redirect:/books";
	}

	@RequestMapping(value="/books/{id}", method=RequestMethod.GET)
	public String get(@ModelAttribute("newBook") Book book, @PathVariable int id, Model model) {
		model.addAttribute("book", bookService.get(id));
		return "book/detail";
	}

	@RequestMapping(value="/books/{id}", method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute("newBook") Book book, BindingResult bindingResult, @PathVariable int id) {
		if(bindingResult.hasErrors()){
			return "books/"+id;
		}
		bookService.update(id, book); // book.id already set by binding
		return "redirect:/books";
	}

	@RequestMapping(value="/books/delete", method=RequestMethod.POST)
	public String delete(int bookId) {
		bookService.delete(bookId);
		return "redirect:/books";
	}

	@ExceptionHandler(value=NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}
}
