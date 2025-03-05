package com.droveda.learn_springboot.coursejdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private static final String INSERT_SQL =
            """
                    insert into course (id, name, author) values (?, ?, ?) 
                    """;

    public static final String DELETE_QUERY = "delete from course where id = ?";

    public static final String SELECT_QUERY = "select * from course where id = ?";

    private final JdbcTemplate template;


    public CourseJdbcRepository(JdbcTemplate template) {
        this.template = template;
    }

    public void insert(CourseEntityJdbc course) {
        template.update(INSERT_SQL, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(long id) {
        template.update(DELETE_QUERY, id);
    }

    public CourseEntityJdbc getById(long id) {
        return template.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(CourseEntityJdbc.class), id);
    }
}
