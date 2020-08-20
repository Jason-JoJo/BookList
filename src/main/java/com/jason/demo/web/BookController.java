package com.jason.demo.web;

import com.jason.demo.domain.Book;
import com.jason.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//@Controller回應模板格式
@Controller
public class BookController {

    //要注入
    @Autowired
    private BookService bookService;

//    @GetMapping("/books")
//    public String list(Model model){
//        List<Book> books = bookService.findAll();
//        model.addAttribute("books",books);
//        return "books";
//    }
    @GetMapping("books/{id}")
    public String detail(@PathVariable long id, Model model){

        Book book = bookService.findOne(id);
        if(book == null){
            book = new Book();
        }
        //設定模板類型
        model.addAttribute("book",book);

        //"book" 對應到模板裡的 book.html
        return "book";
    }

    /**
     * 給新增按鈕的跳轉頁面方法
     * @return
     */
    @GetMapping("/books/input")
    public String inputPage(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return "input";
    }

    /**
     * Post 一個書 重導向到/books 上方的路徑
     * @param book
     * @return
     */
    /**
     * Post  >> redirect >>  Get 有兩次請求 用model不能傳直
     *
     *
     *addFlashAttribute
     */
//    @PostMapping("/books")
//    public String post(Book book,Model model){
//        Book book1 = bookService.save(book);
//            if(book1 != null){
//                model.addAttribute("message"," <" + book1.getName() + "> 新增成功");
//            }
//        bookService.save(book);
//        return "redirect:/books";
//    }
    @PostMapping("/books")
    public String post(Book book, final RedirectAttributes attributes){
        Book book1 = bookService.save(book);
        if(book1 != null){
            attributes.addFlashAttribute("message"," <" + book1.getName() + "> 更新成功");
        }
        bookService.save(book);
        return "redirect:/books";
    }

    /**
     * 更新頁面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/books/{id}/input")
    public String inputEditPage(@PathVariable long id,Model model){
        Book book = bookService.findOne(id);
        model.addAttribute("book",book);
        return "input";
    }
//    @GetMapping("/books")
//    public String list(@RequestParam(defaultValue = "0") int page,
//                             @RequestParam(defaultValue = "3") int size,
//                             Model model) {
////        Sort sort = new Sort(Sort.Direction.DESC,"id");
////        Page<Book> page1 = bookService.findAllByPage(new PageRequest(page,size,new Sort(Sort.Direction.DESC,"id")));
//
//        //原本的方法已棄用改成下面
//        Pageable pageable = PageRequest.of(page,size, Sort.Direction.ASC,"id");
//        Page<Book> page1 = bookService.findAllByPage(pageable);
//        model.addAttribute("page",page1);
//        return "books";
//    }
//
//}
    @GetMapping("/books")
    public String list(@PageableDefault(size =5,sort = {"id"},
            direction = Sort.Direction.ASC) Pageable pageable,
                       Model model){
        Page<Book> page1 = bookService.findAllByPage(pageable);
        model.addAttribute("page",page1);
        return "books";
        //
    }
    @GetMapping("/books/{id}/delete")
    public String delete(@PathVariable long id,final RedirectAttributes attributes){
        bookService.delete(id);
        attributes.addFlashAttribute("message","delect success!!");
        return "redirect:/books";
    }
}