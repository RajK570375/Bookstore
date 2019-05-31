package com.capgemini.book_store.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.Review;

public interface IReviewRepo extends JpaRepository<Review, Integer>{

	List<Review> findByBook(Book book);
}
