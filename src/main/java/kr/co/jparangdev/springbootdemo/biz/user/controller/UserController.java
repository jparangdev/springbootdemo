package kr.co.jparangdev.springbootdemo.biz.user.controller;

import kr.co.jparangdev.springbootdemo.biz.user.service.UserService;
import kr.co.jparangdev.springbootdemo.biz.user.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("list")
    public List<User> searchList(@RequestBody Map<String, Object> param) {
        int page = (int) param.get("page");
        int size = (int) param.get("size");
        String keyword = (String) param.get("keyword");
        Pageable pageRequest = PageRequest.of(page,size);

        List<User> users = userService.searchByName(pageRequest, keyword);
        return users;
    }
}
