package com.trsystems.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageRequestUtil {
	
	public static PageRequest obterRequisicaoPaginada(int page, int size, String sort, String sortDirection) {
		Sort.Direction direction = Sort.Direction.fromString(sortDirection);
		return PageRequest.of(page, size, Sort.by(direction, sort));
	}
}
