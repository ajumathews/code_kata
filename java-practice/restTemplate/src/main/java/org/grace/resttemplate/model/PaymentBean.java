package org.grace.resttemplate.model;

/**
 * Created by U6018134 on 6/25/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
public class PaymentBean {

    private String userId;
    private String paymentCategoryId;
    private String paymentAmount;
    private String paymentDate;
    private String paymentDescription;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPaymentCategoryId() {
        return paymentCategoryId;
    }

    public void setPaymentCategoryId(String paymentCategoryId) {
        this.paymentCategoryId = paymentCategoryId;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }
}
