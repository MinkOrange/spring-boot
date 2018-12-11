package com.mink.springboot.testweb.controller;

import com.mink.springboot.testweb.domain.Category;
import com.mink.springboot.testweb.service.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("/category")
    public List<Category> listCategory(@RequestParam(value = "start", defaultValue = "0") int start,
                                       @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page = categoryDAO.findAll(pageable);
        System.out.println(page.getContent());
        return page.getContent();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable("id") int id) throws Exception{
        Category c = categoryDAO.getOne(id);
        System.out.println(c);
        return c;
    }

    //submit.html以JSON格式传递过来的数据与Category相对应
    @PutMapping("/category")
    public void addCategory(@RequestBody Category category) throws Exception{
        System.out.println("springboot接受到浏览器以JSON格式提交的数据:" + category);
    }

    @RequestMapping("/newworld")
    public String sayHelloWorld(){
        return "Hello New World!";
    }

}
