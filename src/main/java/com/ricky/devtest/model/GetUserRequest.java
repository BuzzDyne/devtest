package com.ricky.devtest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserRequest {
	@NotBlank
	@Pattern(regexp = "^[0-9]+$", message = "id must be numeric")
	private String id;
}