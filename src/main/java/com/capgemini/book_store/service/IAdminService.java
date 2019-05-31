package com.capgemini.book_store.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.Order;
import com.capgemini.book_store.bean.Review;

@Service
public interface IAdminService {

	List<Order> getAllOrder();

	boolean updateStatus(Order order);

	Map<Book, Integer> getAllBook(int orderId);

	List<Review> getAllReview(int bookId);

	boolean updateReview(Review review);

	boolean deleteReview(int reviewId);

}