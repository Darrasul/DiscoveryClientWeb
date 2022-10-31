package com.buzas.discoveryclientweb.controllers;

import com.buzas.discoveryclientweb.item.Product;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private List<Product> productList = new ArrayList<>();

    @PostConstruct
    private void Init() {
        productList.add(new Product(0, "first", 15));
        productList.add(new Product(1, "second", 72));
        productList.add(new Product(2, "third", 133));
        productList.add(new Product(3, "fourth", 40));
    }

    @GetMapping("/")
    public ModelAndView showProductString(Model model) {
        model.addAttribute("products", productList);
        return new ModelAndView("productsPage");
    }
}
