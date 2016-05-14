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
	
	/**搜索
	 * @param key
	 * @return
	 */
	public List<Product> search(String key);
	

	/**分页查询，
	 * @param key 关键字
	 * @param pageSize 
	 * @param pageNum
	 * @return Pager对象 ，里面有pageSize,pageNum,数据list,记录总数
	 */
	public Pager searchByPage(String key,int pageSize,int pageNum);
}
