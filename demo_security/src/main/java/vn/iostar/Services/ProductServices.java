package vn.iostar.Services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import vn.iostar.Repository.ProductRepository;
import vn.iostar.entity.Products;

public interface ProductServices {

	void deleteAll();

	<S extends Products> List<S> findAll(Example<S> example, Sort sort);

	<S extends Products> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends Products> entities);

	Products getReferenceById(Long id);

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(Products entity);

	Products getById(Long id);

	void deleteById(Long id);

	long count();

	<S extends Products, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	Products getOne(Long id);

	void deleteAllInBatch();

	<S extends Products> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	<S extends Products> long count(Example<S> example);

	boolean existsById(Long id);

	void deleteAllInBatch(Iterable<Products> entities);

	Optional<Products> findById(Long id);

	<S extends Products> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Products> entities);

	List<Products> findAllById(Iterable<Long> ids);

	List<Products> findAll();

	<S extends Products> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Products> S saveAndFlush(S entity);

	Page<Products> findAll(Pageable pageable);

	void flush();

	List<Products> findAll(Sort sort);

	<S extends Products> Optional<S> findOne(Example<S> example);

	<S extends Products> List<S> saveAll(Iterable<S> entities);

	<S extends Products> S save(S entity);

	

	
	
}
