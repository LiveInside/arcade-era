package org.nikita.arcadeera.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.nikita.arcadeera.dto.request.GameCreateRequest;
import org.nikita.arcadeera.dto.request.GameUpdateRequest;
import org.nikita.arcadeera.dto.response.GameDTO;
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
@RequestMapping("/games")
@Tag(name = "Игры", description = "Взаимодействие с играми")
public interface GameController {
    @Operation(summary = "Получить игру", description = "Возвращает игру по заданному id", responses = {
            @ApiResponse(responseCode = "200", description = "Игра найдена", content = @Content(schema = @Schema(implementation = GameDTO.class))),
            @ApiResponse(responseCode = "404", description = "Не найден")
    })
    @GetMapping("/{id}")
    ResponseEntity<GameDTO> get(@PathVariable @Parameter(description = "Идентификатор игры") Integer id);

    @Operation(summary = "Получить все игры", description = "Возвращает все игры", responses = {
            @ApiResponse(responseCode = "200", description = "Игры найдены", content = @Content(schema = @Schema(implementation = GameDTO.class)))
    })
    @GetMapping
    ResponseEntity<List<GameDTO>> getAll();

    @Operation(summary = "Создать игру", description = "Создает новую игру в базе данных", responses = {
            @ApiResponse(responseCode = "201", description = "Игра создана", content = @Content(schema = @Schema(implementation = GameDTO.class))),
            @ApiResponse(responseCode = "422", description = "Игра не создана. Введённые пользователем данные не верные")
    })
    @PostMapping
    ResponseEntity<GameDTO> create(@Valid @RequestBody @Parameter(description = "Данные по которым нужно создать игру") GameCreateRequest gameCreateRequest);

    @Operation(summary = "Обновить игру", description = "Обновляет уже существующую игру по заданному id", responses = {
            @ApiResponse(responseCode = "201", description = "Игра обновлена", content = @Content(schema = @Schema(implementation = GameDTO.class))),
            @ApiResponse(responseCode = "422", description = "Игра не обновлена. Введеные пользователем данные не верные"),
            @ApiResponse(responseCode = "404", description = "Не найден")
    })
    @PutMapping("/{id}")
    ResponseEntity<GameDTO> update(@Valid @RequestBody @Parameter(description = "Данные по которым нужно обновить игру") GameUpdateRequest gameUpdateRequest, @PathVariable @Parameter(description = "Идентификатор игры") Integer id);

    @Operation(summary = "Удалить игру", description = "Удаляет игру по заданному id", responses = @ApiResponse(responseCode = "204", description = "Игра удалена"))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable @Parameter(description = "Идентификатор игры") Integer id);
}