package com.droveda.sbproject.dao;

import com.droveda.sbproject.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;
        }
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new PersonRowMapper());
    }

    public Person findById(long id) {
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    public int delete(long id) {
        return jdbcTemplate.update("delete from person where id=?", id);
    }

    public int insert(Person person) {
        String sql = "INSERT INTO person (id, name, location, birth_date) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                person.getId(),
                person.getName(),
                person.getLocation(),
                new Timestamp(person.getBirthDate().getTime()));
    }

    public int update(Person person) {
        String sql = "update person set name = ?, location = ?, birth_date = ? where id = ?";
        return jdbcTemplate.update(sql,
                person.getName(),
                person.getLocation(),
                new Timestamp(person.getBirthDate().getTime()),
                person.getId());
    }

}
