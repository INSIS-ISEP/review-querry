package com.isep.reviewsq.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDTO {
    private String reviewText;
    private String userID;
    private Double rating;
}
