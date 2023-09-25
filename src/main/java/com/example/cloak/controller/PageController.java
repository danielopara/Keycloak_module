package com.example.cloak.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@RestController
public class PageController {

    @GetMapping(path = "/")
    public HashMap index() {
        // get a successful user login
        OAuth2User user = ((OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return new HashMap(){{
            put("hello", user.getAttribute("name"));
            put("your email is", user.getAttribute("email"));
            put("username id: ", user.getAttribute("userId"));
        }};
    }


    @GetMapping(path = "/unauthenticated")
    public HashMap unauthenticatedRequests() {
        return new HashMap(){{
            put("this is ", "unauthenticated endpoint");
        }};
    }
    @GetMapping(path = "/userDetails")
    public HashMap home(){
        OAuth2User user = ((OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return new HashMap(){{

            put("hello", user.getAttribute("name"));
            put("your email is", user.getAttribute("email"));
            put("username id: ", user.getName());
            System.out.println(user);
        }};
    }

}
