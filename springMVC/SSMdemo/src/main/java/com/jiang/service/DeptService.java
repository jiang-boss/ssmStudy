package com.jiang.service;

import com.jiang.dao.DeptMapper;
import com.jiang.domain.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-16
 * @time 12:04
 */
@Service
public class DeptService {
    @Autowired
    DeptMapper deptMapper;
    public List<Dept> getList(){
        return deptMapper.selectByExample(null);
    }

}
