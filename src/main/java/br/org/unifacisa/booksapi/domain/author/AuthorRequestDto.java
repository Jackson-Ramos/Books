package br.org.unifacisa.booksapi.domain.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequestDto {
	private String name;
	private List<String> bookIds;
}
