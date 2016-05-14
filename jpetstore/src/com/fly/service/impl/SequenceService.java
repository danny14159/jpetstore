package com.fly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fly.bean.Sequence;
import com.fly.dao.ISequenceDAO;
import com.fly.service.ISequenceService;

@Service
public class SequenceService implements ISequenceService {

	@Resource
	private ISequenceDAO sequenceDAO;
	
	@Transactional
	public void delete(Sequence entity) {
		sequenceDAO.delete(entity);
	}

	public List<Sequence> findAll() {
		return sequenceDAO.findAll();
	}

	public Sequence findById(String id) {
		return sequenceDAO.findById(id);
	}

	@Transactional
	public void save(Sequence entity) {
		sequenceDAO.save(entity);
	}

	@Transactional
	public Sequence update(Sequence entity) {
		return sequenceDAO.update(entity);
	}

}
