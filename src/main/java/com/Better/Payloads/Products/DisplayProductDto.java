package com.Better.Payloads.Products;
import com.Better.Models.Images;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DisplayProductDto {
    private Long productId;
    private Images imageUrls;
    private String productName;
    private double originalPrice;
    private double offerPercentage;
    private Long NoOfOrders;
    private Integer rating;
}
