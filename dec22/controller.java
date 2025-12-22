package com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springboot.entities.User;
import com.springboot.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "user Apis", description = "CURD OPERATION")
public class UserController {

	@Autowired
	private UserService userService;

	// CREATE
	@PostMapping
	@Operation(summary = " USER created")
	@ApiResponse(responseCode = "200", description = "created user sucessfully")
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	// READ ALL
	@GetMapping
	@Operation(summary = "findALL USERS")
	@ApiResponse(responseCode = "200", description = "retrives all users info")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// READ BY ID
	@GetMapping("/{id}")
	@Operation(summary = "find USER by id")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "user retrived by id"),
			@ApiResponse(responseCode = "404", description = "user not found") })
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	// UPDATE
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "User deleted successfully";
	}
}
