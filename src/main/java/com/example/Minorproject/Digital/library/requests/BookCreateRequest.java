package com.example.Minorproject.Digital.library.requests;

import com.example.Minorproject.Digital.library.Models.Author;
import com.example.Minorproject.Digital.library.Models.Book;
import com.example.Minorproject.Digital.library.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreateRequest {

    @NotBlank
    private String name;

    @Positive
    private int cost;

    @NotNull
    private Genre genre;

    @NotNull
    private Author author;

    public Book toBook(){
        return Book.builder().cost(this.cost)
                .genre(this.genre)
                .name(this.name).author(this.author)
                .build();
    }


}
