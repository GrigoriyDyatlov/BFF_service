package ru.netologu.BFF_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.netologu.BFF_service.responseEntity.Order;
import ru.netologu.BFF_service.responseEntity.User;
import ru.netologu.BFF_service.responseEntity.UserOrders;

import java.util.List;

@RestController
@RequestMapping("/api/site-bff/user")
@RequiredArgsConstructor
public class UserOrdersResource {
    private final String userOrdersEndpoint = "/api/orders/by-user/";
    private final String getUserEndpoint = "/api/users/";

    @Value(value = "$userService")
    private String userService;

    @Value(value = "$orderService")
    private String orderService;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{userId}")
    public UserOrders getUserOrder (@PathVariable String userId) {
        Order order = restTemplate.getForObject(orderService + userOrdersEndpoint + userId,
                Order.class);

        User user = restTemplate.getForObject(userService + getUserEndpoint + userId, User.class);

        return new UserOrders(user, order);

    }
}

