package com.ricky.devtest.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ricky.devtest.entity.User;
import com.ricky.devtest.model.CreateUserRequest;
import com.ricky.devtest.model.EditUserRequest;
import com.ricky.devtest.model.GetUserRequest;
import com.ricky.devtest.model.GetUserResponse;
import com.ricky.devtest.repository.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Validator validator;
	
	public void create(CreateUserRequest req) {
		Set<ConstraintViolation<CreateUserRequest>> constraintViolations = validator.validate(req);
		if(constraintViolations.size() != 0) {
			throw new ConstraintViolationException(constraintViolations);
		}
		
		User u = new User();
		u.setName(req.getName());
		u.setPhone(req.getPhone());
		
		userRepository.save(u);
	}
	
	private GetUserResponse toGetUserResponse(User u) {
		return GetUserResponse.builder()
				.name(u.getName())
				.phone(u.getPhone())
				.build();
	}

    public GetUserResponse get(GetUserRequest req) {
		Set<ConstraintViolation<GetUserRequest>> constraintViolations = validator.validate(req);
		if(constraintViolations.size() != 0) {
			throw new ConstraintViolationException(constraintViolations);
		}

		User u = userRepository.findById(req.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID not found"));
    
		return toGetUserResponse(u);
    }
    
    public GetUserResponse update(EditUserRequest req) {
		Set<ConstraintViolation<EditUserRequest>> constraintViolations = validator.validate(req);
		if(constraintViolations.size() != 0) {
			throw new ConstraintViolationException(constraintViolations);
		}

		User u = userRepository.findById(req.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID not found"));
    
		u.setName(req.getName());
		u.setPhone(req.getPhone());
		
		userRepository.save(u);

        return toGetUserResponse(u);
    }
    
    public void delete(GetUserRequest req) {
		Set<ConstraintViolation<GetUserRequest>> constraintViolations = validator.validate(req);
		if(constraintViolations.size() != 0) {
			throw new ConstraintViolationException(constraintViolations);
		}
		
		User u = userRepository.findById(req.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID not found"));
    
		userRepository.deleteById(req.getId());
    }
}
