package org.book.studentcourse.service;

import lombok.RequiredArgsConstructor;
import org.book.studentcourse.client.GoodReadsClient;
import org.book.studentcourse.dto.response.GoodReadsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodReadsService {
    private final GoodReadsClient goodReads;
    @Value("${host}")
    private String host;
    @Value("${key}")
    private String key;

    public String getPublishedYear(String input) {
        List<GoodReadsResponse> books = goodReads.searchBooks(host,key,input,1);
        return books.getFirst().getPublishedYear();
    }


}
