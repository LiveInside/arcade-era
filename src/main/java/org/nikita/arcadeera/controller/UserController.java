package org.nikita.arcadeera.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.nikita.arcadeera.dto.request.UserCreateRequest;
import org.nikita.arcadeera.dto.request.UserUpdateRequest;
import org.nikita.arcadeera.dto.response.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Пользователи", description = "Взаимодействие с пользователями")
public interface UserController {
    @Operation(summary = "Получить пользователя", description = "Возвращает пользователя по заданному id", responses = {
            @ApiResponse(responseCode = "200", description = "Пользователь найден", content = @Content(schema = @Schema(implementation = UserDTO.class))),
            @ApiResponse(responseCode = "404", description = "Не найден")
    })
    @GetMapping("/{id}")
    ResponseEntity<UserDTO> get(@PathVariable @Parameter(description = "Идентификатор пользователя") Integer id);

    @Operation(summary = "Получить всех пользователей", description = "Возвращает всех пользователей", responses = {
            @ApiResponse(responseCode = "200", description = "Пользователи найдены", content = @Content(schema = @Schema(implementation = UserDTO.class)))
    })
    @GetMapping
    ResponseEntity<List<UserDTO>> getAll();

    @Operation(summary = "Создать пользователя", description = "Создает нового пользователя в базе данных", responses = {
            @ApiResponse(responseCode = "201", description = "Пользователь создан", content = @Content(schema = @Schema(implementation = UserDTO.class))),
            @ApiResponse(responseCode = "422", description = "Пользователь не создан. Введеные пользователем данные не верные")
    })
    @PostMapping
    ResponseEntity<UserDTO> create(@Valid @RequestBody @Parameter(description = "Данные по которым нужно создать пользователя") UserCreateRequest userCreateRequest);

    @Operation(summary = "Обновить пользователя", description = "Обновляет уже существующего пользователя по заданному id", responses = {
            @ApiResponse(responseCode = "201", description = "Пользователь обновлен", content = @Content(schema = @Schema(implementation = UserDTO.class))),
            @ApiResponse(responseCode = "422", description = "Пользователь не обновлен. Введенные пользователем данные не верные"),
            @ApiResponse(responseCode = "404", description = "Не найден")
    })
    @PutMapping("/{id}")
    ResponseEntity<UserDTO> update(@Valid @RequestBody @Parameter(description = "Данные по которым нужно обновить пользователя") UserUpdateRequest userUpdateRequest, @PathVariable @Parameter(description = "Идентификатор пользователя") Integer id);

    @Operation(summary = "Удалить пользователя", description = "Удаляет пользователя по заданному id", responses = @ApiResponse(responseCode = "204", description = "Игра удалена"))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable @Parameter(description = "Идентификатор пользователя") Integer id);
}
