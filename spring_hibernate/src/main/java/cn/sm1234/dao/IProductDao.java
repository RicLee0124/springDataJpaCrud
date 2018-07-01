package cn.sm1234.dao;

import org.springframework.data.repository.CrudRepository;

import cn.sm1234.domain.Product;

public interface IProductDao extends CrudRepository<Product, Integer>{

}
