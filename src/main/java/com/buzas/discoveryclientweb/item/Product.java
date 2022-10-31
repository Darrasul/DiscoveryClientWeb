package com.buzas.discoveryclientweb.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private int price;

    public Product() {
    }
}
