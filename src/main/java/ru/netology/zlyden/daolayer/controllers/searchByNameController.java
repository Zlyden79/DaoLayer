package ru.netology.zlyden.daolayer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.zlyden.daolayer.repositories.SearchRepository;

import java.util.List;

@RestController
@RequestMapping("/products/fetch-product")
public class searchByNameController {

    private final SearchRepository searchRepository;

    @Autowired
    public searchByNameController(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @GetMapping
    public List<String> searchByName(@RequestParam String name) {
        return searchRepository.getProductName(name);
    }
}
