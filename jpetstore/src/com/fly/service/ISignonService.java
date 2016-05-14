package com.fly.service;

import java.util.List;

import com.fly.bean.Signon;

public interface ISignonService {
/**
 * ���Signon��Ϣ
 * @param entity
 */
	public void save(Signon entity);
/**
 * ɾ��Signon��Ϣ
 * @param entity
 */
	public void delete(Signon entity);
/**
 * ����Signon��Ϣ
 * @param entity
 * @return
 */
	public Signon update(Signon entity);
/**
 * ͨ��id���Ҷ�Ӧ��Signon��Ϣ
 * @param id
 * @return Signon
 */
	public Signon findById(String id);
/**
 * ��������Signon��Ϣ
 * @return List
 */
	public List<Signon> findAll();
}
