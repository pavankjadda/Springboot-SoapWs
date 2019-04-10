package com.springdemo.soapws.web;


import com.springdemo.soapws.constants.ApiConstants;
import com.springdemo.soapws.gen.GetBookRequest;
import com.springdemo.soapws.gen.GetBookResponse;
import com.springdemo.soapws.model.Book;
import com.springdemo.soapws.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
public class BookEndpoint
{
    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    public BookEndpoint(BookRepository bookRepository, ModelMapper modelMapper)
    {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @PayloadRoot(namespace = ApiConstants.NAMESPACE_URI, localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getBook(@RequestPayload GetBookRequest getBookRequest)
    {
        GetBookResponse bookResponse = new GetBookResponse();
        Optional<Book> bookOptional = bookRepository.findById(getBookRequest.getId());
        if (bookOptional.isPresent())
        {
            Book book = bookOptional.get();
            bookResponse.setBook(transformBookObject(book));
        }
        return null;
    }

    private com.springdemo.soapws.gen.Book transformBookObject(Book book)
    {
        return modelMapper.map(book, com.springdemo.soapws.gen.Book.class);
    }
}
