package com.happyheng.Mapper;

import com.happyheng.entity.People;
import org.springframework.stereotype.Repository;

/**
 *
 * Created by happyheng on 17/1/16.
 */
@Repository
public interface UserMapper {

    Integer getIdByName(String name);

    void insertUser(People people);
}
