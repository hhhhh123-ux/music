package com.javaclimb.music.service.impl;

import com.javaclimb.music.dao.SingerMapper;
import com.javaclimb.music.domain.Singer;
import com.javaclimb.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**实现类**/
@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerMapper singerMapper;
    @Override
    public boolean insert(Singer singer) {
        return singerMapper.insert(singer)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return singerMapper.delete(id)>0;
    }

    @Override
    public boolean update(Singer singer) {
        return singerMapper.update(singer)>0;
    }

    @Override
    public Singer select(Integer id) {
        return singerMapper.select(id);
    }

    @Override
    public List<Singer> allselect() {
        return singerMapper.allselect();
    }

    @Override
    public List<Singer> selectname(String name) {
        return singerMapper.selectname(name);
    }

    @Override
    public List<Singer> selectsex(Integer sex) {
        return singerMapper.selectsex(sex);
    }
}