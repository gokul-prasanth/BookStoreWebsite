package com.bookstore.dao;

import java.util.List;

/**
 * Generic interface for entity operations
 * 
 * @author Gokul A
 * @createdOn March 15, 2021
 */
public interface GenericDAO<T> {

	public T create(T t);

	public T update(T t);

	public T get(Object id);

	public void delete(Object id);

	public List<T> listAll();

	public Long count();

}
