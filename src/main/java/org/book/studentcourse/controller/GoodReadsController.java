package org.book.studentcourse.controller;

import lombok.RequiredArgsConstructor;
import org.book.studentcourse.service.GoodReadsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goodreads")
public class GoodReadsController {

    private final GoodReadsService goodReadsService;

    @GetMapping("/searchBooks{title}")
    public String searchBooks(@PathVariable String title) {
        return goodReadsService.getPublishedYear(title);
    }
}
