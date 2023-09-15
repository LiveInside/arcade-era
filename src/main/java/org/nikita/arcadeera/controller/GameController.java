package org.nikita.arcadeera.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Получить игру", description = "Возвращает игру по заданному id")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Игра найдена",
            content = { @Content(mediaType = "aplication/json",
            schema = @Schema(implementation = GameDTO.class))}))
    @GetMapping("/{id}")
    ResponseEntity<GameDTO> getGameById(@PathVariable @Parameter(description = "Идентификатор игры") Integer id);

    @Operation(summary = "Получить все игры", description = "Возвращает все игры")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Игры найдены",
            content = { @Content(mediaType = "aplication/json",
                    schema = @Schema(implementation = GameDTO.class))}))
    @GetMapping
    ResponseEntity<List<GameDTO>> getAllGames();

    @Operation(summary = "Создать игру", description = "Создает новую игру в базе данных")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "201", description = "Игра создана",
                    content = { @Content(mediaType = "aplication/json",
                            schema = @Schema(implementation = GameDTO.class))}),
            @ApiResponse (responseCode = "422", description = "Игра не создана. Введёные пользователем данные не верные")
    })
    @PostMapping
    ResponseEntity<GameDTO> createGame(@Valid @RequestBody @Parameter(description = "Данные по которым нужно создать игру") GameCreateRequest gameCreateRequest);

    @Operation(summary = "Обновить игру", description = "Обновляет уже существующую игру по заданному id")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "201", description = "Игра обновлена",
                    content = { @Content(mediaType = "aplication/json",
                            schema = @Schema(implementation = GameDTO.class))}),
            @ApiResponse (responseCode = "422", description = "Игра не обновлена. Введеные пользователем данные не верные")
    })
    @PutMapping("/{id}")
    ResponseEntity<GameDTO> updateGame(@Valid @RequestBody @Parameter(description = "Данные по которым нужно обновить игру") GameUpdateRequest gameUpdateRequest, @PathVariable @Parameter(description = "Идентификатор игры") Integer id);

    @Operation(summary = "Удалить игру", description = "Удаляет игру по заданному id")
    @ApiResponses(@ApiResponse(responseCode = "204", description = "Игра удалена"))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteGame(@PathVariable @Parameter(description = "Идентификатор игры") Integer id);
}