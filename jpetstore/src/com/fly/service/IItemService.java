package com.fly.service;

import java.util.List;

import com.fly.bean.Item;

public interface IItemService {
	/**
	 * Ŀ¼�ı���
	 * @param entity����Ŀ¼��ʵ��
	 */
	public void save(Item entity);
	/**
	 * Ŀ¼��ɾ��
	 * @param entity����Ŀ¼��ʵ��
	 */
	public void delete(Item entity);
	/**
	 * Ŀ¼�ĸ���
	 * @param entity����Ŀ¼��ʵ��
	 * @returnĿ¼��Ϣ
	 */
	public Item update(Item entity);
	/**
	 * ����ID����
	 * @param id����Ŀ¼��ID
	 * @returnĿ¼��Ϣ
	 */
	public Item findById(String id);
	/**
	 * ����������Ϣ�ŵ�list��
	 * @return
	 */
	public List<Item> findAll();
	/**
	 * ���ݲ�ƷID������Ϣ
	 * @param productId�����ƷID
	 * @returnĿ¼�ļ���
	 */
	public List<Item> listByProductId(String productId);

}
