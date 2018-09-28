package cs544.exercise19;

import cs544.sample.NoSuchResourceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class BookController {

	@Resource
    BookDao bookDao;

	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/books";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("books", bookDao.getAll());
		return "bookList";
	}
	@RequestMapping(value="/addBook",method=RequestMethod.GET)	
    public String showForm(@ModelAttribute("book") Book book, Model model){
	        return "addBook";
    }

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "addBook";
		}
		else {
		bookDao.add(book);
		return "redirect:/books";
		}
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public String getBook(@PathVariable int id, Model model) {
		model.addAttribute("book", bookDao.get(id));
		return "bookDetail";
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.POST)
	public String getBook(Book book, @PathVariable int id) {
		bookDao.update(id, book);
		return "redirect:/books";
	}

	@RequestMapping(value = "/books/delete", method = RequestMethod.POST)
	public String deleteBook(int bookId) {
		bookDao.delete(bookId);
		return "redirect:/books";
	}

	@ExceptionHandler(value = NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}

}
