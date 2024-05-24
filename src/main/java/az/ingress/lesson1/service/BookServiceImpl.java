package az.ingress.lesson1.service;

import az.ingress.lesson1.dto.BookRequestDto;
import az.ingress.lesson1.dto.BookResponseDto;
import az.ingress.lesson1.model.Book;
import az.ingress.lesson1.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
        Book book = Book.builder()
                .author(dto.getAuthor())
                .pageCount(dto.getPageCount())
                .name(dto.getName())
                .id(id)
                .build();
        bookRepository.save(book);

        return BookResponseDto.builder()
                .author(book.getAuthor())
                .pageCount(book.getPageCount())
                .name(book.getName())
                .id(book.getId())
                .build();
    }

    @Override
    public void delete(Integer id) {
        bookRepository.delete(bookRepository.getReferenceById(id));
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
