package com.mink.springboot.testweb;

import com.mink.springboot.testweb.web.HelloWorldController;
import com.mink.springboot.testweb.pojo.Category;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class HelloWorldControlerTests {
    private MockMvc mvc;
    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }
    @Ignore
    @Test
    public void getHello() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Ignore
    @Test
    public void exceptionTest(){
        File f = new File("d:/LOL.exe");
        try {
            System.out.println("试图打开 d:/LOL.exe");
            new FileInputStream(f);
            System.out.println("成功打开");
        } catch (FileNotFoundException e) {
            System.out.println("d:/LOL.exe不存在");
            e.printStackTrace();
        }
    }

    @Test
    public void TestArrayList(){
        ArrayList list = new ArrayList();
        list.add(new Category());
        System.out.println(list.size());
        list.add(new Category());
        System.out.println(list.size());
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category());
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category());

    }
}
