package com.example.bookStore.service.implementation;

import com.example.bookStore.dto.AuthorDto;
import com.example.bookStore.dto.BookDto;
import com.example.bookStore.exception.NotFoundException;
import com.example.bookStore.mapper.AuthorMapper;
import com.example.bookStore.model.constants.enums.Error;
import com.example.bookStore.model.entities.Author;
import com.example.bookStore.model.entities.Book;
import com.example.bookStore.repository.AuthorRepository;
import com.example.bookStore.service.AuthorService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<AuthorDto> getAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> authorDtos = new ArrayList<>();
        authors.forEach(author -> authorDtos.add(authorMapper.entityToDto(author)));
        return authorDtos;
    }

    @Override
    public AuthorDto getAuthorById(Integer id) throws NotFoundException {
        Optional<Author> author = this.authorRepository.findById(id);
        if (author.isPresent()){
            return authorMapper.entityToDto(author.get());
        }
        else {
            throw new NotFoundException(Error.NOTFOUND_ERROR.getMessage());
        }
    }

    @Override
    public AuthorDto addAuthor(AuthorDto authorDto) {
        Author saveAuthor = this.authorRepository.save(authorMapper.dtoToEntity(authorDto));
        return authorMapper.entityToDto(saveAuthor);
    }

    @Override
    public void updateAuthor(Integer id, AuthorDto authorDto) {
        Optional<Author> updatedAuthor = this.authorRepository.findById(id);
        if(updatedAuthor.isPresent()){
            Author existingAuthor = updatedAuthor.get();
            authorMapper.updateAuthorFromAuthorDto(authorDto, existingAuthor);
            authorRepository.save(existingAuthor);
        }else {
            throw new NotFoundException(Error.NOTFOUND_ERROR.getMessage());
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
