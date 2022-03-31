package com.web.first.my.group.PPackage.controller;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.first.my.group.PPackage.service.BoardService;


@Controller //①
public class BoardController {

    @Autowired
    private BoardService boardService;  //②

    @RequestMapping("/board/openBoardList.do")  //③
    public ModelAndView openBoardList() throws Exception{
        ModelAndView mv = new ModelAndView("/board/boardList"); //④

        HashMap<Object, Object> parameterMap = new HashMap<Object, Object>();
		parameterMap.put("region", "N");
        List<HashMap<Object, Object>> list = boardService.selectAll(parameterMap);   //⑤
        
        System.out.println(list);
        mv.addObject("list", list); //⑥
        
        return mv;
    }
}