package com.javaclimb.music.service;

import com.javaclimb.music.domain.Admin;

import java.util.List;

public interface AdminService {
    public boolean verifypassword(String username,String password);
    public List<Admin> select();
    public List<Admin> find(Integer id);
}
