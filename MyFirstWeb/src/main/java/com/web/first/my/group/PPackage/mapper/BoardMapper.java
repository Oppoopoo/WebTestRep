package com.web.first.my.group.PPackage.mapper;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


// Mapper 인터페이스
@Repository
@Mapper
public interface BoardMapper {

    // Statement ID와 같은 이름의 메소드 정의
    //List<TestTable> selectAll();
    //List<Map<String, Object>> selectAll();
    List<HashMap<Object, Object>> selectAll(HashMap<Object, Object> vo);
}