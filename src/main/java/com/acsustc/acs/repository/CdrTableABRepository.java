package com.acsustc.acs.repository;

import com.acsustc.acs.entity.CdrTableAB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wong
 * @date 2018/11/23
 */
@Repository
public interface CdrTableABRepository extends JpaRepository<CdrTableAB,String> {
}
