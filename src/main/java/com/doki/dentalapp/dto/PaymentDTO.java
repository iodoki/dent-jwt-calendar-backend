package com.doki.dentalapp.dto;

public record PaymentDTO( Double totalAmount,
                          Double actualAmount,
                          Double remainingAmount,
                          Boolean isPaid) {
}
