package com.springdemo.soapws.web;


import com.springdemo.soapws.constants.ApiConstants;
import com.springdemo.soapws.model.Book;
import com.springdemo.soapws.repository.BookRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
public class BookEndpoint
{
    private final BookRepository bookRepository;

    public BookEndpoint(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @PayloadRoot(namespace = ApiConstants.NAMESPACE_URI, localPart = "getBookRequest")
    @ResponsePayload
    public Book getBook(@RequestPayload Long id)
    {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElse(null);
    }
}
