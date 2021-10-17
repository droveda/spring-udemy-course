package com.droveda.springin5steps;

import com.droveda.springin5steps.xml.XmlPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIn5StepsBasicXMLContextApplication {

    private final static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsBasicXMLContextApplication.class);

//    public static void main(String[] args) {
//
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        LOGGER.info("Beans Loaded -> {}",
//                (Object) context.getBeanDefinitionNames());
//
//        XmlPersonDAO xmlPersonDAO = context.getBean(XmlPersonDAO.class);
//        LOGGER.info("{}", xmlPersonDAO);
//        LOGGER.info("{}", xmlPersonDAO.getXmlJDBCConnection());
//        LOGGER.info("{}", xmlPersonDAO.getXmlJDBCConnection());
//    }

}
