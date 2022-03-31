package com.web.first.my.group.PPackage.service;

import java.util.HashMap;
import java.util.List;


public interface BoardService {   
    List<HashMap<Object, Object>> selectAll(HashMap<Object, Object> vo) throws Exception;
}