package com.solomanin.dao;

import com.solomanin.dao.exception.DaoSystemException;
import com.solomanin.dao.exception.NoSuchEntityException;
import com.solomanin.entity.Product;

import java.util.List;

public interface ProductDao {
    Product selectById(Integer id) throws DaoSystemException, NoSuchEntityException;

    List<Product> selectAll() throws DaoSystemException;
}
