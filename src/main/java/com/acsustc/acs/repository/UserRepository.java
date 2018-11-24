package com.acsustc.acs.repository;

import com.acsustc.acs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * @Author 陈桢秀
 * 2018-11-23 23:12:08
 */
public interface UserRepository extends JpaRepository<User,String> {
    public User findByUserName(String userName);
}

