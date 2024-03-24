package com.yash.reviewms.review;

import com.yash.reviewms.review.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewServiceImpl reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getALlReviews(){
        List<Review> allReviews = reviewService.getAllReviews();
        return new ResponseEntity<>(allReviews, HttpStatus.OK);
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<List<Review>> getALlReviewsByCompanyId(@PathVariable Long companyId){
        List<Review> allReviews = reviewService.getAllReviewsByCompanyId(companyId);
        return new ResponseEntity<>(allReviews, HttpStatus.OK);
    }

    @PostMapping
    public String addReview(@RequestBody Review review){
        reviewService.addReview(review);
        return "Review added successfully";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewByCompanyId(@PathVariable Long id){
        Review review= reviewService.getReviewById(id);
        if(review!=null)
            return new ResponseEntity<>(review, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long id){
        Boolean isDeleted= reviewService.deleteReviewById(id);
        if(isDeleted)
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
