package com.yash.reviewms.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews();


    void addReview(Review review);

    Review getReviewById(Long id);

    Boolean deleteReviewById(Long id);

    List<Review> getAllReviewsByCompanyId(Long companyId);

}
