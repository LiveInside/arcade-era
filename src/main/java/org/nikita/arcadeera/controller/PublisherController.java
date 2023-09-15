package org.nikita.arcadeera.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.nikita.arcadeera.dto.request.PublisherCreateRequest;
import org.nikita.arcadeera.dto.request.PublisherUpdateRequest;
import org.nikita.arcadeera.dto.response.PublisherDTO;
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
    @Operation(summary = "Получить издателя", description = "Возвращает издателя по заданному id")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Издатель найден",
            content = { @Content(mediaType = "aplication/json",
                    schema = @Schema(implementation = PublisherDTO.class))} ))
    @GetMapping("/{id}")
    ResponseEntity<PublisherDTO> getPublisherById(@PathVariable @Parameter(description = "Идентификатор издателя") Integer id);

    @Operation(summary = "Получить всех издателей", description = "Возвращает всех издателей")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Издатели найдены",
            content = { @Content(mediaType = "aplication/json",
                    schema = @Schema(implementation = PublisherDTO.class))} ))
    @GetMapping
    ResponseEntity<List<PublisherDTO>> getAllPublisher();

    @Operation(summary = "Создать издателя", description = "Создает нового издателя в базе данных")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Издатель создан",
                    content = { @Content(mediaType = "aplication/json",
                            schema = @Schema(implementation = PublisherDTO.class))}),
            @ApiResponse (responseCode = "422", description = "Издатель не создан. Введёные пользователем данные не верные")
    })
    @PostMapping
    ResponseEntity<PublisherDTO> createPublisher(@Valid @RequestBody @Parameter(description = "Данные по которым нужно создать издателя") PublisherCreateRequest publisherCreateRequest);

    @Operation(summary = "Обновить издателя", description = "Обновляет уже существующего издателя по заданному id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Издатель обновлён",
                    content = { @Content(mediaType = "aplication/json",
                            schema = @Schema(implementation = PublisherDTO.class))}),
            @ApiResponse (responseCode = "422", description = "Издатель не обновлен. Введеные пользователем данные не верные")
    })
    @PutMapping("/{id}")
    ResponseEntity<PublisherDTO> updatePublisher(@Valid @RequestBody @Parameter(description = "Данные по которым нужнообновить издателя") PublisherUpdateRequest publisherUpdateRequest, @PathVariable @Parameter(description = "Идентификатор издателя") Integer id);

    @Operation(summary = "Удалить издателя", description = "Удаляет издателя по заданному id")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable @Parameter(description = "Идентификатор издателя") Integer id);
}
