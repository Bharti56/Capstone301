package com.review.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.review.entity.ReviewEvent;
import com.review.entity.Reviews;
@Repository
public interface ReviewRepository extends JpaRepository<Reviews,Long> {


	Reviews findByReviewid(long reviewid);

	void save(ReviewEvent event);

	

	

	

	

}
