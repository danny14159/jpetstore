package com.fly.service;

import java.util.List;

import com.fly.bean.Inventory;

public interface IInventoryService {
	/**
	 * ����
	 * @param entity�������嵥��ʵ��
	 */
	public void save(Inventory entity);
	/**
	 * ɾ��
	 * @param entity�������嵥��ʵ��
	 */
	public void delete(Inventory entity);
	/**
	 * ����
	 * @param entity����Ŀ¼�嵥��ʵ��
	 * @returnĿ¼�嵥����Ϣ
	 */
	public Inventory update(Inventory entity);
	/**
	 * ����Ŀ¼ID�õ�Ŀ¼�嵥
	 * @param itemId����Ŀ¼ID
	 * @returnĿ¼�嵥����Ϣ
	 */
	public Inventory findByItemId(String itemId);
	/**
	 * ��������Ŀ¼�嵥
	 * @returnĿ¼�嵥�ļ���
	 */
	public List<Inventory> findAll();

}
