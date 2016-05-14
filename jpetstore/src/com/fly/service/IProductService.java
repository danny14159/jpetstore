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
	
	/**����key�ؼ�������product����ѯ���ֶ�like�����ֶΣ�name,productid,descn
	 * ���Ҵ��Ϸ�ҳ
	 * @param key
	 * @param ps ÿҳ��ʾ������
	 * @param pn ��ǰҳ�ţ���1��ʼ
	 * @return
	 */
	public Pager searchByPage(String key,Integer ps,Integer pn);
	
	/**������ҳ�Ĳ�ѯ
	 * @param key
	 * @return
	 */
	public List<Product> search(String key);
	
	/**����categoryid��ѯproduct
	 * @param categoryId
	 * @return
	 */
	public List<Product> findByCategoryId(String categoryId);
}
