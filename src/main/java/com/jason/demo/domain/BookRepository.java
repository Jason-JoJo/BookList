package com.jason.demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    /**
     * 查詢 注意有同名  import
     * 下面是內建的指令
     * @param pageable
     * @return
     */
    Page<Book> findAll(Pageable pageable);
    List<Book> findByAuthor(String author);
    List<Book> findByAuthorAndStatus(String author,int Status);
    List<Book> findByDescriptionContains(String des);
    List<Book> findFirstByAuthor(String author);
//    @Query("select b from Book b where length(b.name)>?1")
//    @Query(value = "select * from book where length(name) > ?1",nativeQuery = true)
//    List<Book> findByJPQL(int length);
//    自定義 update,delect要ann交易
    @Transactional
    @Modifying
    @Query(value = "update Book b set b.status = ?1 where id =?2",nativeQuery = true)
    int updateByJPQL(int status,long id);


    @Transactional
    @Modifying
    @Query("delete from Book b where b.id = ?1")
    int deleteByJPQL(long id);
}
