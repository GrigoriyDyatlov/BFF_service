package ru.netologu.BFF_service.responseEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class UserOrdersDto {
    UUID userId;
    String fullName;
    String addressDelivery;
    String phoneNumber;
    String email;
    List<OrderDto> userOrders;

    public static UserOrdersDto fromEntity(UserDto userDto, List<OrderDto> orderDto) {
        return new UserOrdersDto(
                userDto.getUserId(),
                userDto.getFullName(),
                userDto.getAddressDelivery(),
                userDto.getPhoneNumber(),
                userDto.getEmail(),
                orderDto);
    }
}