package com.acsustc.acs.controller;
//专门用来提供 RESTFUL 服务其控制器


import com.acsustc.acs.entity.CdrTableA;
import com.acsustc.acs.service.CdrTableAService;
import com.acsustc.acs.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * CdrTableAController
 * @Author 陈桢秀
 * @Time 2018-11-23 20:12:58
 */
@RestController  //表示这是一个控制器，并且对每个方法的返回值都会直接转换为 json 数据格式。
public class CdrTableAController {
    @Autowired                      //自动装配 CdrTableAService
    CdrTableAService cdrTableAService;

    /**
     * 查询cdr_table_a所有记录，并以分页形式展示
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("/cdr_table_a/select_all")
    public Page4Navigator<CdrTableA> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<CdrTableA> page =cdrTableAService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }

//    @GetMapping("/cdr_table_a")
//    public List<CdrTableA> list() throws Exception {
//        return cdrTableAService.list();
//    }

    /**
     *
     * @param bean
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/cdr_table_a/insert")
    public Object add(CdrTableA bean, HttpServletRequest request) throws Exception {
        cdrTableAService.insert(bean);
        return bean;
    }

    @DeleteMapping("/cdr_table_a/delete{uuid}")
    public String delete(@PathVariable("uuid") String uuid, HttpServletRequest request)  throws Exception {
        cdrTableAService.delete(uuid);
        return null;
    }

    @GetMapping("/cdr_table_a/select{uuid}")
    public CdrTableA get(@PathVariable("uuid") String uuid) throws Exception {
        CdrTableA bean=cdrTableAService.select(uuid);
        return bean;
    }

    @PostMapping("/cdr_table_a/update")
    public Object update(CdrTableA bean, HttpServletRequest request) throws Exception {
        cdrTableAService.update(bean);
        return bean;
    }

//    @PutMapping("/cdr_table_a")
//    public Object update(CdrTableA bean, HttpServletRequest request) {
//        String Id = request.getParameter("id");
//        String callerId = request.getParameter("callerId");
//        bean.setCallerId(callerId);
//        String callerName = request.getParameter("callerName");
//        bean.setCallerName(callerName);
//        String callerNumber = request.getParameter("callerNumber");
//        bean.setCallerNumber(callerNumber);
//        String destinationNumber = request.getParameter("destinationNumber");
//        bean.setDestinationNumber(destinationNumber);
//
//
//        cdrTableAService.update(bean);
//
//        return bean;
//    }

}
