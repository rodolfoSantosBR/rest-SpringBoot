package br.com.rodolfo.api.transaction.services;

import java.util.List;
import java.util.logging.Logger;

import br.com.rodolfo.api.transaction.data.vo.v1.BookVO;
import br.com.rodolfo.api.transaction.exception.NotFoundOperationException;
import br.com.rodolfo.api.transaction.mapper.DozerMapper;
import br.com.rodolfo.api.transaction.model.Book;
import br.com.rodolfo.api.transaction.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServices {
	
	private Logger logger = Logger.getLogger(BookServices.class.getName());
	
	@Autowired
	BookRepository repository;

	public List<BookVO> findAll() {

		logger.info("Finding all book!");

		var books = DozerMapper.parseListObjects(repository.findAll(), BookVO.class);
	 	return books;
	}

	public BookVO findById(Long id) {
		
		logger.info("Finding one book!");
		
		var entity = repository.findById(id)
			.orElseThrow(() -> new NotFoundOperationException("No records found for this ID!"));
		var vo = DozerMapper.parseObject(entity, BookVO.class);
		return vo;
	}
	
	public BookVO create(BookVO book) {
		logger.info("Creating one book!");
		var entity = DozerMapper.parseObject(book, Book.class);
		var vo =  DozerMapper.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	public BookVO update(BookVO book) {

		logger.info("Updating one book!");
		
		var entity = repository.findById(book.getKey())
			.orElseThrow(() -> new NotFoundOperationException("No records found for this ID!"));

		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		var vo =  DozerMapper.parseObject(repository.save(entity), BookVO.class);

		return vo;
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one book!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new NotFoundOperationException("No records found for this ID!"));
		repository.delete(entity);
	}
}
