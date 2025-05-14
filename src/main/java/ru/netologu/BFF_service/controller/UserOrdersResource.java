package ru.netologu.BFF_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.netologu.BFF_service.responseEntity.OrderDto;
import ru.netologu.BFF_service.responseEntity.UserDto;
import ru.netologu.BFF_service.responseEntity.UserOrdersDto;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/site-bff/user")
@RequiredArgsConstructor
public class UserOrdersResource {
    private final String userOrdersEndpoint = "/api/orders/by-user/";
    private final String getUserEndpoint = "/api/users/";
    private final RestTemplate restTemplate = new RestTemplate();
    @Value(value = "$userService")
    private String userService;
    @Value(value = "$orderService")
    private String orderService;

    @GetMapping("/{userId}")
    public UserOrdersDto getUserOrder(@PathVariable String userId) {
        ResponseEntity<OrderDto[]> response = restTemplate.getForEntity(orderService + userOrdersEndpoint + userId,
                OrderDto[].class);
        OrderDto[] orders = response.getBody();
        List<OrderDto> orderDtos = Arrays.asList(orders);

        UserDto userDto = restTemplate.getForObject(userService + getUserEndpoint + userId, UserDto.class);

        return UserOrdersDto.fromEntity(userDto, orderDtos);
    }
}

