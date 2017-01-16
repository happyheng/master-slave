package com.happyheng.Mapper;

import org.springframework.stereotype.Repository;

/**
 *
 * Created by happyheng on 17/1/16.
 */
@Repository
public interface UserMapperMapper {

    Integer getIdByName(String name);

}
