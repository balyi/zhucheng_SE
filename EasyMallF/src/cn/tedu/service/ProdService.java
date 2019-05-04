package cn.tedu.service;

import java.util.List;

import cn.tedu.entity.Product;
//首先光标放到接口名称上->Ctrl+T->下箭头
public interface ProdService {
	/**查询全部商品
	 * @return 全部商品对应集合对象
	 */
	public List<Product> findAll();
	/**修改商品的库存
	 * @param id：商品id
	 * @param pnum：修改后的商品数据
	 * @return true:表示修改成功，false：表示修改失败
	 */
	public boolean changePnum(String id, int pnum);
	/**根据商品id删除商品信息
	 * @param id：商品id
	 * @return true:表示删除成功，false表示删除失败
	 */
	public boolean deleteProdById(String id);
	/**根据关键字查询符合条件的商品
	 * @param name：商品名称关键字
	 * @param cate：商品分类关键字
	 * @param min：价格区间的最小值
	 * @param max：价格区间的最大值
	 * @return 符合添加的商品集合
	 */
	public List<Product> findAllByKey(String name, String cate, Double min,
			Double max);
	/**根据商品id查询对应商品的详细信息对象
	 * @param id：商品id
	 * @return：对应商品的详细信息
	 */
	public Product findProdById(String id);
}
