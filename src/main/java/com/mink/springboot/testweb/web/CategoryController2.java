package com.mink.springboot.testweb.web;

import com.mink.springboot.testweb.pojo.Category;
import com.mink.springboot.testweb.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController2 {
    @Autowired
    CategoryDAO categoryDAO;
//    @Autowired
//    CategoryMapper categoryMapper;

    @RequestMapping("/listCategory")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page = categoryDAO.findAll(pageable);
        System.out.println(page.getNumber());                         //当前第几页,返回当前页的数目。总是非负的
        System.out.println(page.getNumberOfElements());               //返回当前页上的元素数。
        System.out.println(page.getSize());                           //返回当前页面的大小。
        System.out.println(page.getTotalElements());                  //返回元素总数。
        System.out.println(page.getTotalPages());

        m.addAttribute("page", page);
        return "listCategory";
    }

    @RequestMapping("/addCategory")                //@RequestMapping这个注解，它会自动扫描形参的POJO，并创建对象，如果前端传进来的参数与POJO成员变量名相同，会通过POJO的setter方法传给该对象。
    public String addCategory(Category c) throws Exception{
        categoryDAO.save(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) throws Exception{
        categoryDAO.delete(c);
        return "redirect:listCategory";
    }

    @RequestMapping
    public String updateCategory(Category c) throws Exception{
        categoryDAO.save(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/editCategory")
    public String editCategory(int id, Model m) throws Exception{
        Category c = categoryDAO.getOne(id);
        m.addAttribute("c", c);
        return "editCategory";
    }


  /*  @RequestMapping("/listCategory")
    public String listCategory(Model m) throws Exception{
        List<Category> cs = categoryDAO.findAll();
//        List<Category> cs = categoryMapper.findAll();
        m.addAttribute("cs", cs);
        return "listCategory";
    }*/
}
