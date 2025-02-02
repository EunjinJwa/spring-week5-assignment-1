package com.codesoom.assignment.controllers;

import com.codesoom.assignment.application.UserService;
import com.codesoom.assignment.domain.User;
import com.codesoom.assignment.dto.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
	}

	@GetMapping("{id}")
	public User getDetail(@PathVariable long id) {
		return userService.getDetail(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody @Valid UserData user) {
		return userService.create(user);
	}

	@PatchMapping("{id}")
	public User patch(@PathVariable Long id,
						  @RequestBody @Valid UserData userData) {
		return userService.updateDetail(id, userData);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void destroy(@PathVariable Long id) {
		userService.delete(id);
	}


}
