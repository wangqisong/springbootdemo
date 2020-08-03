package com.example.demo.controller;

import com.example.demo.mapper.TOrderMapper;
import com.example.demo.pojo.TOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author: wangqisong
 * @date: 2019/9/3
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    TOrderMapper orderMapper;

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello world";
    }

    @PostMapping("/insertOrder")
    public ResponseEntity insertOrder(TOrder torder) {
        int i = orderMapper.insertOrder(torder);
        String msg=null;
        if (i>0){
            msg="数据库插入成功，新增id："+torder.getId();
        }else{
            msg="数据库插入失败："+i;
        }
        return ResponseEntity.ok().body(msg);
    }

    @PostMapping("/findOrderById")
    public ResponseEntity findOrderById(Integer id) {
        TOrder oneOrderById = orderMapper.findOneOrderById(id);
//        if (oneOrderById.isPresent()){
//            TOrder tOrder = oneOrderById.get();
//            return ResponseEntity.ok(tOrder);
//        }
        if (oneOrderById==null){
            return ResponseEntity.ok().body("数据不存在");
        }else{
            return ResponseEntity.ok(oneOrderById);
        }
    }
}
