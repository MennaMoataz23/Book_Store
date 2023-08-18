package com.example.bookStore.mapper;

import com.example.bookStore.dto.BookDto;
import com.example.bookStore.model.entities.Book;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto entityToDto(Book book);
    Book dtoToEntity(BookDto bookDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Book updateBookFromBookDto(BookDto bookDto, @MappingTarget Book book);
}
