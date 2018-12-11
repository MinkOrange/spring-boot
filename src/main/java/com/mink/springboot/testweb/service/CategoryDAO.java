package com.mink.springboot.testweb.service;

import com.mink.springboot.testweb.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {

}
