package com.ricky.devtest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {
	@NotBlank
	@Size(max = 50, message = "size must be between 1 and 50")
	private String name;
	@NotBlank
	@Pattern(regexp = "^[0-9]{1,30}$", message = "id must be numeric and up to 30 digits")
	private String phone;

}
