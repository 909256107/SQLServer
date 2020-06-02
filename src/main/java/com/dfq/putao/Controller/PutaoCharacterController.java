package com.dfq.putao.Controller;
import com.dfq.putao.Service.PutaoCharacterService;
import com.dfq.putao.domain.EUDataGridResult;
import com.dfq.putao.domain.PutaoCharacter;
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
 * @create 2020-06-02 17:33
 */
@Controller
@RequestMapping("/putaoCharacter")
public class PutaoCharacterController {
    @Autowired
    PutaoCharacterService usersService;
    private Map<String,Object> map = new HashMap<>();
    @RequestMapping("/findByPage")
    @ResponseBody
    public EUDataGridResult findByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "15") Integer pageSize) {
        EUDataGridResult result = usersService.findByPage(pageNum,pageSize);
        return result;
    }
    //通过手机号查找用户
    @RequestMapping("/findByPid")
    @ResponseBody
    public EUDataGridResult findByPhone( @RequestParam(defaultValue = "1") Integer pageNum,
                                         @RequestParam(defaultValue = "15") Integer pageSize,@RequestBody PutaoCharacter users) {
        System.out.println(users);
        EUDataGridResult result = usersService.findByPhone(pageNum,pageSize,users);
        return result;
    }
    @RequestMapping("/resign")
    @ResponseBody
    public Map<String,Object> resign(@RequestBody PutaoCharacter users) {
        map.clear();
        try {
            System.out.println(users);
            usersService.insert(users);
            map.put("msg",1);
        } catch (Exception e) {
            map.put("msg",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/update")
    public Map<String,Object>  update(@RequestBody PutaoCharacter users) {
        map.clear();
        try {
            System.out.println(users);
            usersService.update(users);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return  map;
    }
    @RequestMapping("/delete")
    public Map<String,Object> deleteById(@RequestBody PutaoCharacter users) {
        System.out.println(users);
        map.clear();
        try {
            usersService.deleteById(users);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }

}
