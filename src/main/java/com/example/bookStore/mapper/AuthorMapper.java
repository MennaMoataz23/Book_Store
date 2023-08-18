package com.example.bookStore.mapper;

import com.example.bookStore.dto.AuthorDto;
import com.example.bookStore.model.entities.Author;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto entityToDto(Author author);
    Author dtoToEntity(AuthorDto authorDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAuthorFromAuthorDto(AuthorDto authorDto, @MappingTarget Author author);}
