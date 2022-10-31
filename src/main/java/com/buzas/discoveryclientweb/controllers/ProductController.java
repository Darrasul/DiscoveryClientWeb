package com.buzas.discoveryclientweb.controllers;

import com.buzas.discoveryclientweb.item.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private RestTemplate restTemplate;
    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>();
        products.add(new Product(0L, "product#1", 55));
        products.add(new Product(1L, "product#2", 125));
        products.add(new Product(2L, "product#3", 315));
        products.add(new Product(3L, "product#4", 75));
        products.add(new Product(4L, "product#5", 65));
    }

    @GetMapping("/")
    public ModelAndView showProductString(Model model) {
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return new ModelAndView("productsPage");
    }

    @PostMapping("/")
    public ModelAndView addProduct(Model model, @RequestParam String title, @RequestParam Integer price) {
        products.add(new Product(products.get(products.size() - 1).getId() + 1, title, price));
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return new ModelAndView("productsPage");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteProduct(Model model, @PathVariable("id") Long id) {
        products.removeIf(product -> product.getId() == id);
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return new ModelAndView("productsPage");
    }
}
