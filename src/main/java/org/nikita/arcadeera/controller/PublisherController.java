package org.nikita.arcadeera.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.nikita.arcadeera.dto.request.PublisherCreateRequest;
import org.nikita.arcadeera.dto.request.PublisherUpdateRequest;
import org.nikita.arcadeera.dto.response.PublisherDTO;
import org.nikita.arcadeera.exception.NotUpdated;
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
@RequestMapping("/publishers")
@Tag(name = "Издатели", description = "Взаимодействие с издателями")
public interface PublisherController {
    @Operation(summary = "Получить издателя", description = "Возвращает издателя по заданному id", responses = {
            @ApiResponse(responseCode = "200", description = "Издатель найден", content = @Content(schema = @Schema(implementation = PublisherDTO.class))),
            @ApiResponse(responseCode = "404", description = "Не найден")
    })
    @GetMapping("/{id}")
    ResponseEntity<PublisherDTO> get(@PathVariable @Parameter(description = "Идентификатор издателя") Integer id);

    @Operation(summary = "Получить всех издателей", description = "Возвращает всех издателей", responses = {
            @ApiResponse(responseCode = "200", description = "Издатели найдены", content = @Content(schema = @Schema(implementation = PublisherDTO.class)))
    })
    @GetMapping
    ResponseEntity<List<PublisherDTO>> getAll();

    @Operation(summary = "Создать издателя", description = "Создает нового издателя в базе данных", responses =  {
            @ApiResponse(responseCode = "201", description = "Издатель создан", content = @Content (schema = @Schema(implementation = PublisherDTO.class))),
            @ApiResponse(responseCode = "422", description = "Издатель не создан. Введеные пользователем данные не верны")
    })
    @PostMapping
    ResponseEntity<PublisherDTO> create(@Valid @RequestBody @Parameter(description = "Данные по которым нужно создать издателя") PublisherCreateRequest publisherCreateRequest);

    @Operation(summary = "Обновить издателя", description = "Обновляет уже существующего издателя по заданному id", responses = {
            @ApiResponse(responseCode = "201", description = "Издатель обновлён", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PublisherDTO.class))}),
            @ApiResponse(responseCode = "422", description = "Издатель не обновлен. Введеные пользователем данные не верные"),
            @ApiResponse(responseCode = "404", description = "Не найден")
    })
    @PutMapping("/{id}")
    ResponseEntity<PublisherDTO> update(@Valid @RequestBody @Parameter(description = "Данные по которым нужнообновить издателя") PublisherUpdateRequest publisherUpdateRequest, @PathVariable @Parameter(description = "Идентификатор издателя") Integer id) throws NotUpdated;

    @Operation(summary = "Удалить издателя", description = "Удаляет издателя по заданному id", responses = @ApiResponse(responseCode = "204", description = "Игра удалена"))
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable @Parameter(description = "Идентификатор издателя") Integer id);
}
