package com.dfq.putao.Controller;

import com.dfq.putao.Service.UsersService;
import com.dfq.putao.domain.EUDataGridResult;
import com.dfq.putao.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

import java.util.Map;

/**
 * @author Mr Duan
 * @create 2020-06-02 16:53
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    private Map<String, Object> map = new HashMap<>();

    @RequestMapping("/findByPage")
    @ResponseBody
    public EUDataGridResult findByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "15") Integer pageSize) {
        EUDataGridResult result = usersService.findByPage(pageNum, pageSize);
        return result;
    }

    //通过手机号查找用户
    @RequestMapping("/findByPhone")
    @ResponseBody
    public EUDataGridResult findByPhone(@RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "15") Integer pageSize, @RequestBody Users users) {
        System.out.println(users);
        EUDataGridResult result = usersService.findByPhone(pageNum, pageSize, users);

        return result;

    }

    @RequestMapping("/resign")
    @ResponseBody
    public Map<String, Object> resign(@RequestBody Users users) {
        map.clear();
        try {
            System.out.println(users);
            usersService.insert(users);
            map.put("msg", 1);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @RequestMapping("/update")
    public Map<String, Object> update(@RequestBody Users users) {
        map.clear();
        try {
            System.out.println(users);
            usersService.update(users);
            map.put("msg", 1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @RequestMapping("/delete")
    public Map<String, Object> deleteById(@RequestBody Users users) {
        System.out.println(users);
        map.clear();
        try {
            usersService.deleteById(users);
            map.put("msg", 1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }
        return map;
    }

    //登录
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody Users users) {
        map.clear();
        try {
            Users login = usersService.login(users);
            System.out.println(login);
            if (login == null) {
                map.put("msg", 0);

            } else {
                map.put("msg", 1);
                map.put("name", login.getName());
            }
        } catch (Exception e) {
            map.put("msg", e.getMessage());
        }
        return map;

    }
}
