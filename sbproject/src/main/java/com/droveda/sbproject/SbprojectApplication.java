package com.droveda.sbproject;

import com.droveda.sbproject.dao.PersonJdbcDao;
import com.droveda.sbproject.model.Book;
import com.droveda.sbproject.model.Person;
import com.droveda.sbproject.repository.BookRepository;
import com.droveda.sbproject.repository.BookSpringDataRepository;
import com.droveda.sbproject.service.BusinessService;
import com.droveda.sbproject.service.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SbprojectApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(SbprojectApplication.class);

    @Autowired
    BusinessService businessService;

    @Autowired
    BusinessService2 businessService2;

    @Autowired
    PersonJdbcDao personJdbcDao;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookSpringDataRepository dataRepository;


    public static void main(String[] args) {
        SpringApplication.run(SbprojectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info(businessService.calculateSomething());
        LOG.info(businessService2.calculateSomething());

        List<Person> persons = personJdbcDao.findAll();
        persons.forEach(p -> LOG.info("{}", p));

        LOG.info("{}", personJdbcDao.findById(10001));

        LOG.info("number of rows deleted: {}", personJdbcDao.delete(10002));

        Person person = new Person(10004, "New Person", "Curitiba", new Date());
        personJdbcDao.insert(person);

        personJdbcDao.update(new Person(10003, "Pieter", "Utrecht", new Date()));

        Book save = bookRepository.save(new Book("The hobbit", "JRR Tolkien", new Date()));

        Book book = bookRepository.findById(save.getId());
        LOG.info("{}", book);

        //bookRepository.deleteById(book.getId());

        List<Book> all = bookRepository.findAll();
        LOG.info("{}", all);


        List<Book> all2 = dataRepository.findAll();
        LOG.info("{}", all2);

    }
}
