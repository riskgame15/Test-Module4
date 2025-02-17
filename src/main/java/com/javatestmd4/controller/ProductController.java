package com.javatestmd4.controller;


import com.javatestmd4.model.Product;
import com.javatestmd4.model.ProductType;
import com.javatestmd4.service.product.IProductService;
import com.javatestmd4.service.producttype.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IProductTypeService productTypeService;


    @GetMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        List<Product> productList = productService.findAll();
        List<ProductType> productTypeList = productTypeService.findAll();
        mv.addObject("productList", productList);
        mv.addObject("productTypeList", productTypeList);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView mv = new ModelAndView("create");
        Product product = new Product();
        mv.addObject("product", product);
        List<ProductType> productTypeList = productTypeService.findAll();
        mv.addObject("productTypeList", productTypeList);
        return mv;
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("update");
        Product product = productService.findById(id).get();
        mv.addObject("product", product);
        List<ProductType> productTypeList = productTypeService.findAll();
        mv.addObject("productTypeList", productTypeList);
        return mv;
    }

    @PostMapping
    public ModelAndView save(@ModelAttribute Product product) {
        productService.save(product);
        return new ModelAndView("redirect:/product");
    }

    @DeleteMapping
    public ModelAndView delete(@RequestBody List<Long> idList) {
        ModelAndView mv = new ModelAndView("index");
        for (Long id : idList) {
            productService.delete(productService.findById(id).get());
        }
        return mv;
    }

    @PutMapping("/{id}")
    public ModelAndView update(@ModelAttribute Product product, @PathVariable Long id) {
        productService.save(product);
        return new ModelAndView("redirect:/product");
    }
}


