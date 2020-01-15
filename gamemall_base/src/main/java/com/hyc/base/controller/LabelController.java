package com.hyc.base.controller;

import com.hyc.base.pojo.Label;
import com.hyc.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@CrossOrigin //跨域

//@RequestMapping("/label")
public class LabelController {
    /*查询全部
    * CRUD
    *
    * */
    @Autowired
    private LabelService labelService;
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功",labelService.findAll());
    }
    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId){
        return  new Result(true,StatusCode.OK,"查血成功",labelService.findById(labelId));
    }
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }
    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable("labelId") String labelId,@RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "更新成功");
    }
    @RequestMapping(value = "/{labelId}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("labelId") String labelId){
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){
       List<Label> list =labelService.findSearch(label);
        return new Result(true,StatusCode.OK,"查询成功");
    }
//    @RequestMapping(value = "/login",method = RequestMethod.GET)

    @PostMapping("/login")
    public String login() {
        return "loginCustomer";
    }

}
