package com.acsustc.acs.repository;

import com.acsustc.acs.entity.CdrTableB;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CdrTableARepository 对数据库表CdrTableA进行操作
 * @Author 陈桢秀
 * 2018-11-23 23:10:57
 */
public interface CdrTableBRepository extends JpaRepository<CdrTableB, String> {
}

