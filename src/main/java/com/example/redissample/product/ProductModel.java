package com.example.redissample.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "Product", timeToLive = 5L)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductModel {

    @Id
    String id;

    String name;

    @TimeToLive
    Long expirationInSeconds;
}
