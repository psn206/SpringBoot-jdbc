package com.example.springbootjdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.List;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final String query = read("templates/02_select_product_name.sql");


    private String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductNames(String name) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        return jdbcTemplate.query(query, params, rowMapper());
    }

    private RowMapper<String> rowMapper() {
        return (ResultSet resultSet, int rowNum) ->
                resultSet.getString("product_name");
    }

}