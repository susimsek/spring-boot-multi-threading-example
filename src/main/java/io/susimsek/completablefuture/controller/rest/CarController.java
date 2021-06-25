package io.susimsek.completablefuture.controller.rest;


import io.susimsek.completablefuture.domain.Car;
import io.susimsek.completablefuture.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;


@Log4j2
@Tag(name = "Car", description = "Retrieve and manage cars")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/car")
public class CarController {

    final CarService carService;

    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created",content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

    })
    @Operation(summary = "Upload File")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadFile(@RequestPart(value = "files") @Parameter(description = "File to be uploaded", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE)) MultipartFile[] files){
        try {
            for(final MultipartFile file: files) {
                        carService.saveCars(file.getInputStream());
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok",content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content)

    })
    @Operation(summary = "Get All Cars")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<List<Car>> getAllCars() throws Exception {
        return carService.getAllCars().exceptionally(handleGetCarFailure);
    }

    private static Function<Throwable, ? extends List<Car>> handleGetCarFailure = throwable -> {
        log.error("Failed to read records: {}", throwable);
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
    };

}
