package com.mink.springboot.testweb.dao;

import com.mink.springboot.testweb.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * from category_")
    List<Category> findAll();

}
