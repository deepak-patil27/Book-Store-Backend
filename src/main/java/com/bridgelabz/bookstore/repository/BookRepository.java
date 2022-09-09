package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value="select * from book where book_name LIKE :bookName%",nativeQuery=true)
    public List<Book> findByBookName(String bookName);

    @Query(value="select * from book ORDER BY price",nativeQuery = true)
    public List<Book> sortBooksAsc();

    @Query(value="select * from book ORDER BY price DESC",nativeQuery = true)
    public List<Book> sortBooksDesc();

    @Query(value="select * from book where bookid =:id",nativeQuery=true)
    public List<Book> findByBookId(Integer id);


}
