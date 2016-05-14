package com.fly.service;

import java.util.List;

import com.fly.bean.Pager;
import com.fly.bean.Product;

public interface IProductService {

	public void save(Product entity);

	public void delete(Product entity);

	public Product update(Product entity);

	public Product findById(String id);

	public List<Product> findAll();
	
	/**根据key关键字搜索product，查询的字段like三个字段，name,productid,descn
	 * 并且带上分页
	 * @param key
	 * @param ps 每页显示的数量
	 * @param pn 当前页号，从1开始
	 * @return
	 */
	public Pager searchByPage(String key,Integer ps,Integer pn);
	
	/**不带分页的查询
	 * @param key
	 * @return
	 */
	public List<Product> search(String key);
	
	/**根据categoryid查询product
	 * @param categoryId
	 * @return
	 */
	public List<Product> findByCategoryId(String categoryId);
}
