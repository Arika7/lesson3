package az.ingress.lesson1.service;

import az.ingress.lesson1.dto.BookRequestDto;
import az.ingress.lesson1.dto.BookResponseDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BookServiceImpl2 implements BookService {

    @Override
    public int create(BookRequestDto dto) {
        return 0;
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
        return null;
    }
}
