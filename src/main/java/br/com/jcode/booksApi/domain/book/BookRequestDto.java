package br.com.jcode.booksApi.domain.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {
	private String title;
	private String description;
	private String authorId;
	private List<String> librariesIds;
}
