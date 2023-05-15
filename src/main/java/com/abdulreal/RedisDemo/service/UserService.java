package com.abdulreal.RedisDemo.service;

import com.abdulreal.RedisDemo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    boolean saveUser(User user);

    List<User> fetchAllUser();

    User fetchUserById(Long id);

    boolean deleteUser(Long id);

    boolean updateUser(Long id, User user);
}
