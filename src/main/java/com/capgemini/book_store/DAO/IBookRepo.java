package com.capgemini.book_store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.book_store.bean.Book;

public interface IBookRepo extends JpaRepository<Book, Integer> {

}
