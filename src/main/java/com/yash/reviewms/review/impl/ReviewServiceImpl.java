package com.yash.reviewms.review.impl;

import com.yash.reviewms.review.Review;
import com.yash.reviewms.review.ReviewRepository;
import com.yash.reviewms.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        List<Review> reviewList = reviewRepository.findAll();
        return reviewList;
    }

    @Override
    public List<Review> getAllReviewsByCompanyId(Long companyId) {
        List<Review> reviewList = reviewRepository.findByCompanyId(companyId);
        return reviewList;
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteReviewById(Long id) {
        try {
            reviewRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
