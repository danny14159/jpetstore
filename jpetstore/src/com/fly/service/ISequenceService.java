package com.fly.service;

import java.util.List;

import com.fly.bean.Sequence;

public interface ISequenceService {
	/**
	 * ���ISequence
	 * @param entity
	 */
	public void save(Sequence entity);
/**
 * ɾ��ISequence
 * @param entity
 */
	public void delete(Sequence entity);
/**
 * ����ISequence
 * @param entity
 * @return Sequence
 */
	public Sequence update(Sequence entity);
/**
 * ͨ�� id ����ISequence
 * @param id
 * @return Sequence
 */
	public Sequence findById(String id);
/**
 * ��������ISequence
 * @return  List<Sequence>
 */
	public List<Sequence> findAll();
}
