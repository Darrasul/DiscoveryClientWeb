package com.buzas.discoveryclientweb.controllers;

import com.buzas.discoveryclientweb.item.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("web")
public class ProductController {
    private final ClientDb clientDb;

    @GetMapping("/")
    public ModelAndView showProductString(Model model) {
        List<Product> products = clientDb.findAll();
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return new ModelAndView("productsPage");
    }

    @PostMapping("/")
    public ModelAndView addProduct(Model model, @RequestParam String title, @RequestParam Integer price) {
        clientDb.addProduct(title, price);
        List<Product> products = clientDb.findAll();
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return new ModelAndView("productsPage");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteProduct(Model model, @PathVariable("id") Long id) {
        clientDb.deleteProduct(id);
        List<Product> products = clientDb.findAll();
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return new ModelAndView("productsPage");
    }
}
