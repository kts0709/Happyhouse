//package com.happyhouse.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@CrossOrigin(origins = { "*" }, maxAge = 6000)
//@Controller
//public class HomeController {
//
//    @GetMapping("/ssafy")
//    public String home() {
//        return "index.html";
//    }
//
//    @GetMapping("/mvnotice")
//    public String notice() {
//        return "/notice/list";
//    }
//
//    @GetMapping(value = "/qna", produces = {"text/html"})
//    public String qna() {
//        return "/qna/qna";
//    }
//}
