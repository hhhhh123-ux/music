package com.javaclimb.music.dao;

import com.javaclimb.music.domain.Admin;
import com.javaclimb.music.domain.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerMapper {

    public int insert(Singer singer);
    public int delete(Integer id);
    public int update(Singer singer);
    public Singer select(Integer id);
    public List<Singer> allselect();
    public List<Singer> selectname(String name);
    public List<Singer> selectsex(Integer sex);
}
