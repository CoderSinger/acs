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

    public void delete(String userName) {
        userRepository.delete(userName);
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

    //用户注册逻辑
    public String  register(User user) {
        User dbUser = userRepository.findByUserName(user.getUserName());
        //判断用户是否存在
        if (dbUser == null) {
            userRepository.save(user);
            return "注册成功";
        }
        else {
            return dbUser.getUserName()+"已被使用";
        }
    }

    //用户登录逻辑
    public String login(User user) {
        //通过用户名获取用户
        User dbUser = userRepository.findByUserName(user.getUserName());
        //若获取失败
        if (dbUser == null) {
            return "该用户不存在";
        }
        //获取成功后，将获取用户的密码和传入密码对比
        else if (!dbUser.getPassword().equals(user.getPassword())){
            return "密码错误";
        }
        else {
            //若密码也相同则登录成功
            //让传入用户的属性和数据库保持一致
            user.setPhoneNumber(dbUser.getPhoneNumber());
            System.out.println(user.getPhoneNumber());
            return "登录成功";
        }
    }


}
