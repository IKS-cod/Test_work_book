package com.book.service;

import com.book.dto.BooksDto;
import com.book.exception.BooksNotFoundException;
import com.book.mapper.Mappers;
import com.book.model.Books;
import com.book.repository.BooksRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService {
    private final Mappers mappers;
    private final BooksRepository booksRepository;

    public BooksService(Mappers mappers, BooksRepository booksRepository) {
        this.mappers = mappers;
        this.booksRepository = booksRepository;
    }

    public BooksDto createBooks(BooksDto booksDto) {
        Books booksForDb = mappers.toBooks(booksDto);
        booksForDb.setId(null);
        Books booksSaveInDb = booksRepository.save(booksForDb);
        return mappers.toBooksDto(booksSaveInDb);
    }

    public void deleteBooks(Long id) {
        if (!booksRepository.existsById(id)) {
            throw new BooksNotFoundException("Books not found with ID: " + id);
        }
        booksRepository.deleteById(id);
    }


    public void updateBooks(Long id, BooksDto booksDto) {
        Books booksFromDb = booksRepository.findById(id)
                .orElseThrow(() -> new BooksNotFoundException("Books not found with ID: " + id));
        booksFromDb.setVendorCode(booksDto.getVendorCode());
        booksFromDb.setTitle(booksDto.getTitle());
        booksFromDb.setYear(booksDto.getYear());
        booksFromDb.setBrand(booksDto.getBrand());
        booksFromDb.setStock(booksDto.getStock());
        booksFromDb.setPrice(booksDto.getPrice());
        booksRepository.save(booksFromDb);

    }

    public BooksDto getBookById(Long id) {
        return booksRepository.findById(id)
                .map(mappers::toBooksDto)
                .orElseThrow(() -> new BooksNotFoundException("Books not found with ID: " + id));

    }

    public List<BooksDto> getBooks(String title, String brand, Integer year, Integer limit) {
        Pageable pageable = PageRequest.of(0, limit);
        Page<Books> page = booksRepository.findByTitleAndBrandAndYear(title, brand, year, pageable);

        return page.getContent().stream()
                .map(mappers::toBooksDto)
                .collect(Collectors.toList());
    }
}

