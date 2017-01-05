package com.happyheng.controller;

import com.happyheng.dao.PeopleDao;
import com.happyheng.entity.People;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * Created by happyheng on 17/1/4.
 */
@RestController
@RequestMapping("people")
public class PeopleController {

    @Resource
    private PeopleDao peopleDao;

    @RequestMapping("getByName")
    public People getPeopleByName(String name) {

        People people = peopleDao.getPeopleByName(name);
        return people;
    }

}
