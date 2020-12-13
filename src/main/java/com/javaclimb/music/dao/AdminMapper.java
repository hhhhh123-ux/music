package com.javaclimb.music.dao;

import com.javaclimb.music.domain.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface AdminMapper {

    public int verifypassword(String username,String password);
    public List<Admin> select();
    public List<Admin> find(Integer id);
}
