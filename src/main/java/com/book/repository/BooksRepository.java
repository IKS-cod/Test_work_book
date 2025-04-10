package com.book.repository;

import com.book.model.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    @Query("SELECT b FROM Books b WHERE " +
            "(:title IS NULL OR b.title = :title) AND " +
            "(:brand IS NULL OR b.brand = :brand) AND " +
            "(:year IS NULL OR b.year = :year)")
    Page<Books> findByTitleAndBrandAndYear(@Param("title") String title,
                                           @Param("brand") String brand,
                                           @Param("year") Integer year,
                                           Pageable pageable);
}
