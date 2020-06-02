package com.dfq.putao.Controller;

import com.dfq.putao.Service.PutaoService;
import com.dfq.putao.domain.EUDataGridResult;
import com.dfq.putao.domain.Putao;
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
 * @create 2020-06-02 17:24
 */
@Controller
@RequestMapping("/putao")
public class PutaoController {
    @Autowired
    PutaoService putaoService;

    private Map<String,Object> map = new HashMap<>();

    @RequestMapping("/findByPage")
    @ResponseBody
    public EUDataGridResult findByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "15") Integer pageSize) {
        EUDataGridResult result = putaoService.findByPage(pageNum,pageSize);
        return result;
    }
    //通过葡萄种类查找用户
    @RequestMapping("/findByPid")
    @ResponseBody
    public EUDataGridResult findByPhone( @RequestParam(defaultValue = "1") Integer pageNum,
                                         @RequestParam(defaultValue = "15") Integer pageSize,@RequestBody Putao putao) {
        System.out.println(putao);
        EUDataGridResult result = putaoService.findByPhone(pageNum,pageSize,putao);

        return result;

    }
    //添加信息
    @RequestMapping("/resign")
    @ResponseBody
    public Map<String,Object> resign(@RequestBody Putao putao) {
        map.clear();
        try {
            System.out.println(putao);
            putaoService.insert(putao);
            map.put("msg",1);
        } catch (Exception e) {
            map.put("msg",e.getMessage());
        }
        return map;
    }//修改信息
    @RequestMapping("/update")
    public Map<String,Object>  update(@RequestBody Putao putao) {
        map.clear();
        try {
            System.out.println(putao);
            putaoService.update(putao);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return  map;
    }//删除信息
    @RequestMapping("/delete")
    public Map<String,Object> deleteById(@RequestBody Putao putao) {
        System.out.println(putao);
        map.clear();
        try {
            putaoService.deleteById(putao);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }

}
