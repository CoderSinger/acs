package com.acsustc.acs.service;

import com.acsustc.acs.entity.CdrTableB;
import com.acsustc.acs.repository.CdrTableBRepository;
import com.acsustc.acs.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 陈桢秀
 * 2018-11-23 23:12:32
 */
@Service
public class CdrTableBService {
    @Autowired
    CdrTableBRepository cdrTableBRepository;

    public Page4Navigator<CdrTableB> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "uuid");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =cdrTableBRepository.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public List<CdrTableB> selectAll(){
        Sort sort =new Sort(Sort.Direction.ASC,"uuid");
        return cdrTableBRepository.findAll(sort);
    }

    public void delete(String uuid) {
        cdrTableBRepository.delete(uuid);
    }

    public CdrTableB select(String uuid) {
        CdrTableB cdrTableB= cdrTableBRepository.findOne(uuid);
        return cdrTableB;
    }
    public void insert(CdrTableB bean) {
        cdrTableBRepository.save(bean);
    }
    public void update(CdrTableB bean) {  //增加和修改都是save，所以看传入的bean的id，id=0是增加，不为0是修改
        cdrTableBRepository.save(bean);
    }

}
