package ru.netologu.BFF_service.responseEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link ru.netologu.BFF_service.responseEntity.UserOrders}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserOrdersDto {
    UUID userId;
    String fullName;
    String addressDelivery;
    String phoneNumber;
    String email;
    Order order;
}