package com.jason.demo.service;

import com.jason.demo.domain.Book;
import com.jason.demo.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    /**
     * 查詢所有
     * @return
     */
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    /**
     * 查詢分頁
     * @return
     */
    public Page<Book> findAllByPage(Pageable pageable){
//        Pageable pageable = PageRequest.of(0,5,Sort.Direction.DESC,"id");
        return bookRepository.findAll(pageable);
    }
    /**
     * 如果沒有id就新增
     * 新增用save()
     * 有相同id就update
     *111
     */
    public Book save(Book book){
        return bookRepository.save(book);
    }

    public Book findOne(long id){
        return bookRepository.findById(id).orElse(null);
    }

    public void delete(long id){
        bookRepository.deleteById(id);
    }

    /**
     * 根據作者查詢書單LIST
     * @param author
     * @return
     */
    public List<Book> findByAuthor(String author){
        return  bookRepository.findByAuthor(author);

    }

    /**
     * 根據作者與狀態查詢書單
     * @param author
     * @param status
     * @return
     */
    public List<Book> findByAuthorAndStatus(String author,int status){
        return bookRepository.findByAuthorAndStatus(author,status);
    }

    public List<Book> findByDescriptionContains(String des){
        return bookRepository.findByDescriptionContains(des);
    }
    public List<Book> findFirstByAuthor(String author){
        return bookRepository.findFirstByAuthor(author);
    }
//    public List<Book> findByJPQL(int length){
//        return bookRepository.findByJPQL(length);
//    }


    public int updateByJPQL(int status,long id){
        return bookRepository.updateByJPQL(status,id);
    }

    public int delectByJQPL(long id){
        return bookRepository.deleteByJPQL(id);
    }
    //如果沒有 @Transactional 有exception 還是會update
    //有@Transactional 有exception 會rollback
    @Transactional
    public int deleteAndUpdate(long id,int status,long uid){
        int dcount = bookRepository.deleteByJPQL(id);
        int ucount = bookRepository.updateByJPQL(status,uid);
        return  dcount + ucount;
    }

}
