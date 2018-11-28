package com.ats.asus.test;

public class Products {
    public String ProductName;
    public String BasePrice;
    public String Category;
    public String ImageUrl;
    public String ProductMatrial;
    public String Reviews;

    public Products(String productName, String BasePrice, String Category) {
        this.ProductName = productName;
        this.BasePrice = BasePrice;
        this.Category = Category;
        this.ImageUrl = ImageUrl;

        this.ProductMatrial = ProductMatrial;
        this.Reviews = Reviews;
    }

    public String getBasePrice() {
        return BasePrice;
    }

    public String getCategory() {
        return Category;
    }

    public String getProductMatrial() {
        return ProductMatrial;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getReviews() {
        return Reviews;
    }

    public void setBasePrice(String basePrice) {
        BasePrice = basePrice;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public void setProductMatrial(String productMatrial) {
        ProductMatrial = productMatrial;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setReviews(String reviews) {
        Reviews = reviews;
    }
}

