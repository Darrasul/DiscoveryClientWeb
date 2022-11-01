package com.buzas.discoveryclientweb.controllers;

import com.buzas.discoveryclientweb.item.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("client-db")
public interface ClientDb {
    @GetMapping("/")
    List<Product> findAll();

    @PostMapping("/")
    void addProduct(@RequestParam String title, @RequestParam Integer price);

    @PostMapping("/{id}")
    void deleteProduct(@PathVariable Long id);
}
