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

public class ProductServiceImpl implements ProductServices{
	@Autowired
	private ProductRepository repo;

	public ProductServiceImpl(ProductRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public <S extends Products> S save(S entity) {
		return repo.save(entity);
	}

	@Override
	public <S extends Products> List<S> saveAll(Iterable<S> entities) {
		return repo.saveAll(entities);
	}

	@Override
	public <S extends Products> Optional<S> findOne(Example<S> example) {
		return repo.findOne(example);
	}

	@Override
	public List<Products> findAll(Sort sort) {
		return repo.findAll(sort);
	}

	@Override
	public void flush() {
		repo.flush();
	}

	@Override
	public Page<Products> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@Override
	public <S extends Products> S saveAndFlush(S entity) {
		return repo.saveAndFlush(entity);
	}

	@Override
	public <S extends Products> List<S> saveAllAndFlush(Iterable<S> entities) {
		return repo.saveAllAndFlush(entities);
	}

	@Override
	public List<Products> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Products> findAllById(Iterable<Long> ids) {
		return repo.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<Products> entities) {
		repo.deleteInBatch(entities);
	}

	@Override
	public <S extends Products> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repo.findAll(example, pageable);
	}

	@Override
	public Optional<Products> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<Products> entities) {
		repo.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Long id) {
		return repo.existsById(id);
	}

	@Override
	public <S extends Products> long count(Example<S> example) {
		return repo.count(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		repo.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Products> boolean exists(Example<S> example) {
		return repo.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		repo.deleteAllInBatch();
	}

	@Override
	public Products getOne(Long id) {
		return repo.getOne(id);
	}

	@Override
	public <S extends Products, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return repo.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Products getById(Long id) {
		return repo.getById(id);
	}

	@Override
	public void delete(Products entity) {
		repo.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		repo.deleteAllById(ids);
	}

	@Override
	public Products getReferenceById(Long id) {
		return repo.getReferenceById(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Products> entities) {
		repo.deleteAll(entities);
	}

	@Override
	public <S extends Products> List<S> findAll(Example<S> example) {
		return repo.findAll(example);
	}

	@Override
	public <S extends Products> List<S> findAll(Example<S> example, Sort sort) {
		return repo.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	
	

	
	
}
