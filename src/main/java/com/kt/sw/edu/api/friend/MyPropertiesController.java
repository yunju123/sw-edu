package com.kt.sw.edu.api.friend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/properties")
public class MyPropertiesController {

    @Value("${properties.name}")
    String name;

    @Value("${properties.number}")
    Integer number;

    @Value("${properties.wishlist}")
    String wishlist;

    @GetMapping("/name")
    public String retrieveName() {
        return name;
    }

    @GetMapping("/number")
    public Integer retrieveNumber() {
        return number;
    }

    @GetMapping("/wishlist")
    public String retrieveWishList() {
        return wishlist;
    }



}
