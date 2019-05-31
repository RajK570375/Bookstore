package com.capgemini.book_store.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.book_store.bean.BookDetail;
import com.capgemini.book_store.bean.Order;

public interface IBookDetailRepo extends JpaRepository<BookDetail, Integer> {

	List<BookDetail> findByOrder(Order order);
}
