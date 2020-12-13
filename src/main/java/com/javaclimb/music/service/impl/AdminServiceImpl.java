package com.javaclimb.music.service.impl;

import com.javaclimb.music.dao.AdminMapper;
import com.javaclimb.music.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.javaclimb.music.service.AdminService;

import java.util.List;

/**实现类**/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public boolean verifypassword(String username, String password) {

        return  adminMapper.verifypassword(username,password)>0;
    }
     @Override
    public List<Admin> select(){

      return adminMapper.select();
     }


    public List<Admin>find(Integer id){

        return adminMapper.find(id);
    }
}
