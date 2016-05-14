package com.fly.dao;

import java.util.List;

import com.fly.bean.Pager;
import com.fly.bean.Product;

public interface IProductDao {

	public void save(Product entity);

	public void delete(Product entity);

	public Product update(Product entity);

	public Product findById(String id);

	public List<Product> findAll();
	
	public List<Product> findByCategoryId(String categoryId);
	
	/**����
	 * @param key
	 * @return
	 */
	public List<Product> search(String key);
	

	/**��ҳ��ѯ��
	 * @param key �ؼ���
	 * @param pageSize 
	 * @param pageNum
	 * @return Pager���� ��������pageSize,pageNum,����list,��¼����
	 */
	public Pager searchByPage(String key,int pageSize,int pageNum);
}
