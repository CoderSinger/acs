package com.acsustc.acs.controller;
//专门用来提供 RESTFUL 服务其控制器


import com.acsustc.acs.entity.CdrTableB;
import com.acsustc.acs.service.CdrTableBService;
import com.acsustc.acs.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * CdrTableBController
 * @Author 陈桢秀
 * @Time 2018-11-23 20:12:58
 */
@RestController  //表示这是一个控制器，并且对每个方法的返回值都会直接转换为 json 数据格式。
public class CdrTableBController {
    @Autowired                      //自动装配 CdrTableBService
    CdrTableBService cdrTableBService;

    /**
     * 查询cdr_table_b所有记录，并以分页形式展示
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("/cdr_table_b/select_all")
    public Page4Navigator<CdrTableB> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<CdrTableB> page =cdrTableBService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }

//    @GetMapping("/cdr_table_b")
//    public List<CdrTableB> list() throws Exception {
//        return cdrTableBService.list();
//    }

    /**
     *
     * @param bean
     * @param request
     * @return
     * @throws Exception
     */
    //为了解决“Request method 'POST' not supported”问题，原先是PostMapping
    @RequestMapping("/cdr_table_b/insert")
    public Object add(CdrTableB bean, HttpServletRequest request) throws Exception {
        cdrTableBService.insert(bean);
        return bean;
    }

    @DeleteMapping("/cdr_table_b/delete{uuid}")
    public String delete(@PathVariable("uuid") String uuid, HttpServletRequest request)  throws Exception {
        cdrTableBService.delete(uuid);
        return null;
    }

    @GetMapping("/cdr_table_b/select{uuid}")
    public CdrTableB get(@PathVariable("uuid") String uuid) throws Exception {
        CdrTableB bean=cdrTableBService.select(uuid);
        return bean;
    }

    @PostMapping("/cdr_table_b/update")
    public Object update(CdrTableB bean, HttpServletRequest request) throws Exception {
        cdrTableBService.update(bean);
        return bean;
    }

//    @PutMapping("/cdr_table_b")
//    public Object update(CdrTableB bean, HttpServletRequest request) {
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
//        cdrTableBService.update(bean);
//
//        return bean;
//    }

}
