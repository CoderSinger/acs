package com.acsustc.acs.service;

import com.acsustc.acs.repository.CdrTableARepository;
import com.acsustc.acs.entity.CdrTableA;
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
public class CdrTableAService {
    @Autowired
    CdrTableARepository cdrTableARepository;

    public Page4Navigator<CdrTableA> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "uuid");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =cdrTableARepository.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public List<CdrTableA> selectAll(){
        Sort sort =new Sort(Sort.Direction.ASC,"uuid");
        return cdrTableARepository.findAll(sort);
    }

    public void delete(int id) {
        cdrTableARepository.delete(id);
    }

    public CdrTableA select(int id) {
        CdrTableA cdrTableA= cdrTableARepository.findOne(id);
        return cdrTableA;
    }
    public void insert(CdrTableA bean) {
        cdrTableARepository.save(bean);
    }
    public void update(CdrTableA bean) {  //增加和修改都是save，所以看传入的bean的id，id=0是增加，不为0是修改
        cdrTableARepository.save(bean);
    }

}
