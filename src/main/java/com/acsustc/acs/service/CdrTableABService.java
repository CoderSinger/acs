package com.acsustc.acs.service;

import com.acsustc.acs.entity.CdrTableAB;
import com.acsustc.acs.repository.CdrTableABRepository;
import com.acsustc.acs.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wong
 * @date 2018/11/23
 */
@Service
public class CdrTableABService {
    @Autowired
    CdrTableABRepository cdrTableABRepository;

    public Page4Navigator<CdrTableAB> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "uuid");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =cdrTableABRepository.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public List<CdrTableAB> selectAll(){
        Sort sort =new Sort(Sort.Direction.ASC,"uuid");
        return cdrTableABRepository.findAll(sort);
    }


    public CdrTableAB select(String id) {
        CdrTableAB cdrTableAB= cdrTableABRepository.findOne(id);
        return cdrTableAB;
    }
    public void delete(String id) {
        cdrTableABRepository.delete(id);
    }
    public void insert(CdrTableAB bean) {
        cdrTableABRepository.save(bean);
    }
    public void update(CdrTableAB bean) {
        cdrTableABRepository.save(bean);
    }
}
