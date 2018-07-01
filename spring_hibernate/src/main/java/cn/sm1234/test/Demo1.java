package cn.sm1234.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.sm1234.dao.IProductDao;
import cn.sm1234.domain.Product;

/**
 * 演示CrudRepository接口的使用
 * @author lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo1 {

	@Resource
	private IProductDao productDao;

	/**
	 * 保存一个对象
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void test1(){
		Product p  =new Product();
		p.setName("Le phone");
		p.setBrand("LeTV");
		p.setPrice(1200D);
		p.setStore(1000);
		productDao.save(p);
	}

	/**
	 * 批量保存对象
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void test2(){
		Product p1  =new Product();
		p1.setName("vivo手机");
		p1.setBrand("vivo");
		p1.setPrice(2000D);
		p1.setStore(2000);

		Product p2  =new Product();
		p2.setName("360手机");
		p2.setBrand("360");
		p2.setPrice(1600D);
		p2.setStore(1200);

		List<Product> pList = new ArrayList<Product>();
		pList.add(p1);
		pList.add(p2);

		productDao.save(pList);
	}


	/**
	 * 查询一个对象
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void test3(){
		Product product = productDao.findOne(2);
		System.out.println(product);
	}

	/**
	 * 查询所有对象
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void test4(){
		List<Product> pList = (List<Product>)productDao.findAll();
		for (Product product : pList) {
			System.out.println(product);
		}
	}

	/**
	 * 更新一个对象
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void test5(){
		/*Product product = productDao.findOne(2); //product是持久态对象
		product.setPrice(3500D);*/


		Product p  =new Product();
		p.setId(7);
		p.setName("乐视手机");
		p.setBrand("乐视");
		p.setPrice(1200D);
		p.setStore(1000);

		productDao.save(p);
	}
}
