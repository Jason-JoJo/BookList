package com.jason.demo.web;

import com.jason.demo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @RestController 以Restful表示
 * @RequestMapping("/api/v1") 定義路徑
 *
 */
//@Controller
@RestController
@RequestMapping("/api/v1")
public class HelloController {
//  @Autowired  //自動綁定 可以標註在建構式參數上;在 Spring 管理的 Bean 中能夠找到
//  private Book book;


  //可以改寫為@GetMapping("/say")
//  @RequestMapping(value = "/say",method = RequestMethod.GET)
//
//
//
//
//    public String hello(){
//        return "Hello";
//    }
//    @RequestMapping("/kay")
//    public String kollo(){
//      return "kollo";
//    }
//    @PostMapping("/postmap")
//    public String po(){
//      return "post";
//    }
//    @GetMapping("/books")
////    @ResponseBody
//    public Object getAll(){
//      Map<String,Object> map = new HashMap<>();
//      map.put("name","good");
//      map.put("price",30);
//      return map;
//    }

  /**
   * 正規表達式 在參數後面加 : []+ @GetMapping("/books/{id}","username : [a-z] +")
   * @PathVariable 定義請求參數
   * @return
   */
    @GetMapping("/books/{id}")
    public Object getOne(@PathVariable("id") long id){
//      return book;
      return null;
    }

    @PostMapping("/books")
    public Object post(@RequestParam String name,
                       @RequestParam String author,
                       @RequestParam String isbn){
     Map<String,Object> book = new HashMap<>();
     book.put("name",name);
     book.put("author",author);
     book.put("isbn",isbn);
     return book;
    }

  /**
   * @RequestParam(defaultValue = "1") 如果沒有值預設 1 一定要有""
   * RequestParam 通常用於Post表單，查詢頁數(提交頁數)
   * PathVariable 用於獲取一個資源(get)，改變一個資源(delete)
   *
   * @RequestParam 和 @PathVariable註解是用於從request中接收請求的，
   * 兩個都可以接收參數，關鍵點不同的是
   * @RequestParam是從request裡面拿取值，
   * 而@PathVariable是從一個URI模板裡面來填充
   *
   * 使用@RequestParam時，URL是這樣的：http://host:port/path?引數名=引數值
   *
   * 使用@PathVariable時，URL是這樣的：http://host:port/path/引數值
   *
   * @param page
   * @param size
   * @return
   */
//  @GetMapping("/books")
//  public Object getAllbyPage(@RequestParam int page,@RequestParam(defaultValue = "1") int size){
//    Map<String,Object> book1 = new HashMap<>();
//    book1.put("name","some");
//    book1.put("isbn","123456");
//    book1.put("author","jason");
//    Map<String,Object> book2 = new HashMap<>();
//    book2.put("name","good");
//    book2.put("isbn","4567222");
//    book2.put("author","bell");
//    List<Map> contents = new ArrayList<>();
//    contents.add(book1);
//    contents.add(book2);
//
//    Map<String,Object> pagemap = new HashMap<>();
//    pagemap.put("page",page);
//    pagemap.put("size",size);
//    pagemap.put("contents",contents);
//
//    return pagemap;
//  }
}
