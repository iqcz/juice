package com.packt.mvneclipse.guava;

import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.packt.mvneclipse.guava.model.Book;

public class BookListConverter implements Function<List<Book>, Map<String, String>> {

	@Override
	public Map<String, String> apply(List<Book> books) {
		Map<String, String> map = Maps.newHashMap();
		Joiner joiner = Joiner.on("|");
		
		for(Book book : books) {
			map.put(book.getIsbn(), joiner.join(book.getTitle(), book.getPublisher(), book.getPrice()));
		}
		return map;
	}

}
