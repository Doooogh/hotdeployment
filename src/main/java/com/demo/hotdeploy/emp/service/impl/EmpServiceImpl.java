package com.demo.hotdeploy.emp.service.impl;

import com.demo.hotdeploy.emp.entity.Emp;
import com.demo.hotdeploy.emp.mapper.EmpMapper;
import com.demo.hotdeploy.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {


    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> list() {
        return empMapper.list();
    }
}
