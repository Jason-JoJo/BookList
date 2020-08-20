package com.jason.demo.web;

import com.jason.demo.domain.Book;
import com.jason.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController 會回應json格式
@RestController
@RequestMapping("/api/v2")
public class BookApp {
    @Autowired
    private BookService bookService;

//    @GetMapping("/books")
//    public Page<Book> getAll(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "3") int size) {
////        return bookService.findAll();
////        Sort sort = new Sort(Sort.Direction.DESC,"id");
//        //原本的方法已棄用改成下面
//        Pageable pageable = PageRequest.of(page,size,Sort.Direction.DESC,"id");
//        return bookService.findAllByPage(pageable);
//    }

    @GetMapping("books")
    public Page<Book> getAll(@PageableDefault(size = 5,
            sort = {"id"},
            direction = Sort.Direction.ASC) Pageable pageable){

        return bookService.findAllByPage(pageable);
    }



//    /**
//     * 傳入單體 可以用Book book取代
//     * @param name
//     * @param author
//     * @param description
//     * @param status
//     * @return
//     */
//    @PostMapping("/books")
//    public Book post(@RequestParam String name,
//                     @RequestParam String author,
//                     @RequestParam String description,
//                     @RequestParam int status) {
//        Book book = new Book();
//        book.setName(name);
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setStatus(status);
//        return bookService.save(book);
//    }

    @PostMapping("/books")
    public Book post(Book book) {
        return bookService.save(book);
    }
    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable long id) {
        return bookService.findOne(id);
    }

    @PutMapping("/books")
    public Book update ( @RequestParam long id,
                         @RequestParam String name,
                         @RequestParam String author,
                         @RequestParam String description,
                         @RequestParam int status){
            Book book = new Book();
            book.setId(id);
            book.setName(name);
            book.setAuthor(author);
            book.setDescription(description);
            book.setStatus(status);
            return bookService.save(book);
        }
        @DeleteMapping("/books/{id}")
        public String deleteOne(@PathVariable long id){
            bookService.delete(id);
            return "ID = "+id+" delect success!!";
        }
//        @PostMapping("/books/by")
//        public List<Book> findBy(@RequestParam String author){
//            return bookService.findByAuthor(author);
//        }
//        @PostMapping("/books/by")
//        public List<Book> findBy(@RequestParam String author,@RequestParam int status){
//            return bookService.findByAuthorAndStatus(author,status);
//        }
//        @PostMapping("/books/by")
//        public  List<Book> findBy(@RequestParam String descrition){
//            return bookService.findByDescriptionContains(descrition);
//        }
//     @PostMapping("/books/by")
//    public List<Book> findBy(@RequestParam int length){
//        return bookService.findByJPQL(length);
//    }
//    @PostMapping("/books/by")
//    public int findBy(@RequestParam int status,@RequestParam long id){
//        return bookService.updateByJPQL(status,id);
//    }

//    @PostMapping("/books/by")
//    public String delectByJPQL(long id){
//        bookService.delectByJQPL(id);
//        return id+" delect by JQPL success!" ;
//    }

    @PostMapping("/books/by")
    public int findBy(@RequestParam long id,@RequestParam int status,@RequestParam long uid){
        return bookService.deleteAndUpdate(id,status,uid);
    }
}

