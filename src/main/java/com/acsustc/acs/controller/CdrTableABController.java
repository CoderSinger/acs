package com.acsustc.acs.controller;

import com.acsustc.acs.entity.CdrTableAB;
import com.acsustc.acs.service.CdrTableABService;
import com.acsustc.acs.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wong
 * @date 2018/11/23
 */
@RestController
public class CdrTableABController {
    @Autowired
    CdrTableABService cdrTableABService;

    @GetMapping("/cdr_table_ab/select_all")
    public Page4Navigator<CdrTableAB> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<CdrTableAB> page =cdrTableABService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }
    @PostMapping("/cdr_table_ab/insert")
    public Object add(CdrTableAB bean, HttpServletRequest request) throws Exception {
        cdrTableABService.insert(bean);
        return bean;
    }

    @DeleteMapping("/cdr_table_ab/delete{id}")
    public String delete(@PathVariable("id") String id, HttpServletRequest request)  throws Exception {
        cdrTableABService.delete(id);
        return null;
    }

    @GetMapping("/cdr_table_ab/select{id}")
    public CdrTableAB get(@PathVariable("id") String id) throws Exception {
        CdrTableAB bean=cdrTableABService.select(id);
        return bean;
    }

    @PostMapping("/cdr_table_ab/update")
    public Object update(CdrTableAB bean, HttpServletRequest request) throws Exception {
        cdrTableABService.update(bean);
        return bean;
    }
}
