package com.pablop.survey.web.app.services;

import org.springframework.data.repository.CrudRepository;

import com.pablop.survey.web.app.models.entity.User;

public interface IUserServiceCrud extends CrudRepository <User, Long> {

}
