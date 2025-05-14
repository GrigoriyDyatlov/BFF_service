package ru.netologu.BFF_service.responseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private UUID id;
    private String userId;
    private String currency;
    private Integer totalCost;
    private List<String> listOfGoods;
}
