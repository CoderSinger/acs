package com.acsustc.acs.service;

import com.acsustc.acs.entity.User;
import com.acsustc.acs.repository.UserRepository;
import com.acsustc.acs.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 陈桢秀
 * 2018-11-23 23:12:59
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Page4Navigator<User> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "user_name");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =userRepository.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public List<User> selectAll(){
        Sort sort =new Sort(Sort.Direction.ASC,"user_name");
        return userRepository.findAll(sort);
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public User login(String userName, String password) {
        User user= userRepository.findByUserNameAndPassword(userName, password);
        return user;
    }
    public User select(String userName) {
        User user= userRepository.findByUserName(userName);
        return user;
    }
    public void insert(User bean) {
        userRepository.save(bean);
    }
    public void update(User bean) {  //增加和修改都是save，所以看传入的bean的id，id=0是增加，不为0是修改
        userRepository.save(bean);
    }
}
