package com.codegen.demo.resource;

import com.codegen.demo.model.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {
  @PostMapping("/login")
  @ResponseStatus(HttpStatus.OK)
  void login(@Validated @RequestBody LoginRequest loginRequest) {}

  @GetMapping("/logout")
  String logout() {
    return "logout";
  }

  @GetMapping("/{id}")
  User getUser(@PathVariable("id") String id) {
    return User.builder().name("test").email("test@email.com").build();
  }

  @PutMapping("/update/{id}")
  void updateUserById(
      @PathVariable("id") String id, @RequestBody @Validated UpdateUserRequest updateUserRequest) {}

  @GetMapping("/search")
  List<String> searchUserIdsByName(@RequestParam("searchName") String searchName) {
    return new ArrayList<String>() {
      {
        this.add("test-id1");
        this.add("test-id1");
      }
    };
  }

  @GetMapping("/profile/search")
  UserProfileList searchUserProfile(
      @RequestParam(name = "id", required = false) String id,
      @RequestParam(name = "name", required = false) String name) {
    return UserProfileList.builder()
        .userProfileList(
            new ArrayList<UserProfile>() {
              {
                this.add(UserProfile.builder().github("github").build());
              }
            })
        .build();
  }

  @GetMapping("/enums")
  LookupEnumGroupVO getEnums() {
    return LookupEnumGroupVO.builder()
        .gender(
            new ArrayList<LookupEnumGroupVO.LookupEnumVO>() {
              {
                this.add(
                    LookupEnumGroupVO.LookupEnumVO.builder()
                        .type("gender")
                        .code("M")
                        .label("Male")
                        .build());
                this.add(
                    LookupEnumGroupVO.LookupEnumVO.builder()
                        .type("gender")
                        .code("F")
                        .label("Female")
                        .build());
              }
            })
        .build();
  }
}
