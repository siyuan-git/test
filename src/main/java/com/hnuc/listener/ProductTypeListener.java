package com.hnuc.listener;


import com.hnuc.service.ProductInfoService;
import com.hnuc.service.ProductTypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class ProductTypeListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //手工从spring容器取出ProductTypeServiceImpl的对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_*.xml");
        ProductTypeService productTypeService = (ProductTypeService) context.getBean("ProductTypeServiceImpl");
        List<ProductTypeService> typeList = productTypeService.getAll();
        //放入全局作用域对象中
        servletContextEvent.getServletContext().setAttribute("typeList",typeList);


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
