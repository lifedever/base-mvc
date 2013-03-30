package com.wincn.base.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * jpa的基类
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createDate 2013-3-30 上午12:53:59
 * @param <T>
 * @param <ID>
 */
public interface BaseDAO<T, ID extends Serializable> extends JpaRepository<T, ID> {
	T findOne(ID id);
	List<T> findAll(Sort sort);
	Page<T> findAll(Pageable pageable);
}
