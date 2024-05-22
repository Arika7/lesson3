package az.ingress.lesson1.service;

import az.ingress.lesson1.dto.BookRequestDto;
import az.ingress.lesson1.dto.BookResponseDto;
import az.ingress.lesson1.dto.Hello;
import az.ingress.lesson1.model.Book;
import az.ingress.lesson1.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final Hello hello;

    public BookServiceImpl(BookRepository bookRepository, Hello hello) {
        this.bookRepository = bookRepository;
        this.hello = hello;
    }

    @Override
    public int create(BookRequestDto dto) {
        Book book = Book.builder()
                .author(dto.getAuthor())
                .pageCount(dto.getPageCount())
                .name(dto.getName())
                .id(dto.getId())
                .build();
        bookRepository.save(book);
        return book.getId();
    }

    @Override
    public BookResponseDto update(Integer id, BookRequestDto dto) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public BookResponseDto get(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return BookResponseDto.builder()
                .author(book.getAuthor())
                .pageCount(book.getPageCount())
                .name(book.getName())
                .id(book.getId())
                .build();
    }
}
