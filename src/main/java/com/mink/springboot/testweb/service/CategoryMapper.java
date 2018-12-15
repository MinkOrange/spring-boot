package com.mink.springboot.testweb.service;

import com.mink.springboot.testweb.domain.Category;
import com.mink.springboot.testweb.domain.Category2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * from category_")
    List<Category> findAll();

}
