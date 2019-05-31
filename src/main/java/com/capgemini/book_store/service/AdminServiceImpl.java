package com.capgemini.book_store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.book_store.DAO.IBookDetailRepo;
import com.capgemini.book_store.DAO.IBookRepo;
import com.capgemini.book_store.DAO.IOrderRepo;
import com.capgemini.book_store.DAO.IReviewRepo;
import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.BookDetail;
import com.capgemini.book_store.bean.Order;
import com.capgemini.book_store.bean.Review;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IOrderRepo orderRepo;

	@Autowired
	IBookRepo bookRepo;

	@Autowired
	IReviewRepo reviewRepo;
	
	@Autowired
	IBookDetailRepo bDetailrepo;

	/* Manage Order */

	
	@Override
	public List<Order> getAllOrder() {
		return orderRepo.findAll();
	}

	@Override
	public boolean updateStatus(Order order) {
		Order ord = orderRepo.getOne(order.getOrderId());
		ord.setOrderStatus(order.getOrderStatus());
		orderRepo.saveAndFlush(ord);
		return true;
	}

	@Override
	public Map<Book, Integer> getAllBook(int orderId) {
		Map<Book, Integer> mBook = new HashMap<>();
		List<BookDetail> li = bDetailrepo.findByOrder(orderRepo.findById(orderId).get());
		
		for(BookDetail b : li )
		{
			mBook.put(b.getBook(), b.getQuantity());
		}
	
		return mBook;
	}

	/* Manage Review */

	@Override
	public List<Review> getAllReview(int bookId) {
		/*System.out.println("------"+bookRepo.getOne(bookId));
		System.out.println("-----"+reviewRepo.findByBook(bookRepo.getOne(bookId)));*/
		return reviewRepo.findByBook(bookRepo.getOne(bookId));
	}

	@Override
	public boolean updateReview(Review review) {
		Review rev = reviewRepo.findById(review.getReviewId()).get();
		rev.setHeadLine(review.getHeadLine());
		rev.setComment(review.getComment());
		reviewRepo.save(rev);
		return true;
	}

	@Override
	public boolean deleteReview(int reviewId) {
		reviewRepo.deleteById(reviewId);
		return true;
	}
}
