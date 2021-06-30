package com.jiang.test;

import com.github.pagehelper.PageInfo;
import com.jiang.domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-15
 * @time 21:38
 * spring的单元测试
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/applicationContext.xml","file:F:\\SSMStudy\\springMVC\\SSMdemo\\src\\main\\resources\\conf\\springmvc.xml"})
public class MvcTest {
    //传入springmvc的ioc
    @Autowired
    WebApplicationContext context;
    //虚拟的mvc请求
    MockMvc mockMvc;

    @Before
    public void initMockMvc(){
       mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void test() throws Exception{
        MvcResult pn = mockMvc.perform(MockMvcRequestBuilders.get("/emp").param("pn", "1")).andReturn();
        //请求成功后 请求域中会pageInfo
        MockHttpServletRequest request = pn.getRequest();
        PageInfo pageInfo =(PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码"+pageInfo.getPageNum());
        System.out.println("总页码"+pageInfo.getPages());
        System.out.println("总记录数："+pageInfo.getTotal());
        //在页面需要连续显示的页码
        int[] navigatepageNums = pageInfo.getNavigatepageNums();
        for (int i:navigatepageNums){
            System.out.println(""+i);
        }
        List<Employee> list = pageInfo.getList();
        list.forEach(System.out::println);
    }
}
