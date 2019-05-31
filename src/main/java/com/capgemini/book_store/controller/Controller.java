package com.capgemini.book_store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.book_store.bean.Book;
import com.capgemini.book_store.bean.Order;
import com.capgemini.book_store.bean.Review;
import com.capgemini.book_store.service.IAdminService;

@RestController
public class Controller {

		@Autowired
		IAdminService adminService;
		
		@RequestMapping(value = "/getAllOrder", method = RequestMethod.GET)
		public boolean getAllOrders()
		{
			System.out.println(adminService.getAllOrder());
			return true; 
		}
		
		@RequestMapping(value = "/updateOrder", method = RequestMethod.PUT)
		public boolean updateOrderStatus(@RequestBody Order order)
		{
			return adminService.updateStatus(order);
		}
		
		@RequestMapping(value = "/getAllBooks/{orderId}", method = RequestMethod.GET)
		public Map<Book, Integer> getAllBooks(@PathVariable int orderId)
		{
			return adminService.getAllBook(orderId);
		}
		
		@RequestMapping(value = "/getAllReview/{bookId}", method = RequestMethod.GET)
		public List<Review> getAllReview(@PathVariable int bookId)
		{
			return adminService.getAllReview(bookId);
		}
		
		@RequestMapping(value = "/updateReview", method = RequestMethod.PUT)
		public boolean updateReview(@RequestBody Review review)
		{
			return adminService.updateReview(review);
		}
		
		@RequestMapping(value = "/deleteReview/{reviewId}", method = RequestMethod.DELETE)
		public boolean deleteReview(@PathVariable int reviewId)
		{
			return adminService.deleteReview(reviewId);
		}
}
