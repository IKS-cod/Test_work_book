package com.book.mapper;

import com.book.dto.BooksDto;
import com.book.model.Books;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface Mappers {
    BooksDto toBooksDto(Books books);

    Books toBooks(BooksDto booksDto);

}
