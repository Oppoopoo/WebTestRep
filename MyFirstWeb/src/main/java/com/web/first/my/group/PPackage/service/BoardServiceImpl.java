package com.web.first.my.group.PPackage.service;

import com.web.first.my.group.PPackage.mapper.BoardMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service    //①
@Transactional //커넥션 하나만 생성. auto-commit false. 젅부 성공적으로 완료시 commit
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper mapper;    //②

    @Override
    public List<HashMap<Object, Object>> selectAll(HashMap<Object, Object> vo) {
        return mapper.selectAll(vo);
    }
}