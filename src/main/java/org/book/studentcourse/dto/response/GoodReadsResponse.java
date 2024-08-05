package org.book.studentcourse.dto.response;

import lombok.Data;

import java.util.ArrayList;

@Data
public class GoodReadsResponse {
    public String imageUrl;
    public String bookId;
    public String workId;
    public String bookUrl;
    public String title;
    public ArrayList<Author> author;
    public String rank;
    public String rating;
    public String totalRatings;
    public String publishedYear;
    public String totalEditions;
}
