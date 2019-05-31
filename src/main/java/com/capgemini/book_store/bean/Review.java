package com.capgemini.book_store.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Reviews")
public class Review {
	@Id
	@GeneratedValue(generator = "review", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "review", sequenceName = "six", initialValue = 500, allocationSize = 1)
	private int reviewId;

	@OneToOne
	private Book book;

	@Column(name = "ratings")
	private int rating;

	private String headLine;

	@Column(name = "comments")
	private String comment;

	@OneToOne
	private Customer customer;

	private Date reviewDate;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getHeadLine() {
		return headLine;
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", book=" + book + ", rating=" + rating + ", headLine=" + headLine
				+ ", comment=" + comment + ", customer=" + customer + ", reviewDate=" + reviewDate + "]";
	}
	
}
