package com.javaclimb.music.service;

import com.javaclimb.music.domain.Admin;
import com.javaclimb.music.domain.Singer;

import java.util.List;

public interface SingerService {
    public boolean insert(Singer singer);
    public boolean delete(Integer id);
    public boolean update(Singer singer);
    public Singer select(Integer id);
    public List<Singer> allselect();
    public List<Singer> selectname(String name);
    public List<Singer> selectsex(Integer sex);
}
