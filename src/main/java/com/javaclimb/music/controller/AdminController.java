package com.javaclimb.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.music.domain.Admin;
import com.javaclimb.music.service.AdminService;
import com.javaclimb.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "admin/login/status", method = RequestMethod.POST)
    public Object loginStatus(HttpSession session, HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean flaf = adminService.verifypassword(name, password);
        if (flaf) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "登录成功");
            session.setAttribute(Consts.NAME, name);
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"用户名或密码错误");
        return jsonObject;
    }


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpSession session, HttpServletRequest request) {
        List<Admin> adminList=adminService.select();
       System.out.println(adminList);
       adminList.get(0);
        System.out.println(adminList.get(0));
        String admin=String.valueOf(adminList.get(0));
    return admin;
    }

    @GetMapping(value = "/hhh")
    public List<Admin> AdminList() {
        return adminService.select();

    }

    @GetMapping(value = "/hhh/id/{id}")
    public List<Admin> AdminLists(@PathVariable("id") Integer id) {
        return adminService.find(id);

    }
}
