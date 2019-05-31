package com.capgemini.book_store.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.book_store.bean.Order;

public interface IOrderRepo extends JpaRepository<Order, Integer> {
	
}
