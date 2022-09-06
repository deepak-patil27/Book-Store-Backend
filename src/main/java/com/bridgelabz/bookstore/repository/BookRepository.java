package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value="select * from book where book_name LIKE :bookName%",nativeQuery=true)
    public List<Book> findByBookName(String bookName);

    @Query(value="select * from book where bookid =:id",nativeQuery=true)
    public List<Book> findByBookId(Integer id);

}
