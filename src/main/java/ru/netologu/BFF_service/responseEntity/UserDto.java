package ru.netologu.BFF_service.responseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private UUID userId;
    private String fullName;
    private String addressDelivery;
    private String phoneNumber;
    private String email;
}
