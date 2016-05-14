package com.fly.service;

import java.util.List;

import com.fly.bean.Sequence;

public interface ISequenceService {
	/**
	 * 添加ISequence
	 * @param entity
	 */
	public void save(Sequence entity);
/**
 * 删除ISequence
 * @param entity
 */
	public void delete(Sequence entity);
/**
 * 更新ISequence
 * @param entity
 * @return Sequence
 */
	public Sequence update(Sequence entity);
/**
 * 通过 id 查找ISequence
 * @param id
 * @return Sequence
 */
	public Sequence findById(String id);
/**
 * 查找所有ISequence
 * @return  List<Sequence>
 */
	public List<Sequence> findAll();
}
