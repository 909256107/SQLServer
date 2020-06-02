package com.dfq.putao.Controller;

import com.dfq.putao.Service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr Duan
 * @create 2020-06-02 17:12
 */
@RequestMapping("/init")
@Controller
public class InitController {
    @Autowired
    InitService initService;
    private Map<String,Object> map = new HashMap<>();

    @RequestMapping("/sql")
    @ResponseBody
    public  Map<String,Object>  init(){
        map.clear();
        try {
            initService.init();
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }

}
