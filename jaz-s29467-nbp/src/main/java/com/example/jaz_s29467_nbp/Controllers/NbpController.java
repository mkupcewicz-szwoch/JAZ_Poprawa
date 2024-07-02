package com.example.jaz_s29467_nbp.Controllers;

import com.example.jaz_s29467_nbp.ResponseNBP;
import com.example.jaz_s29467_nbp.Service.Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("nbp/")
public class NbpController{
    private final Service service;

    public NbpController(Service service) {this.service = service;}

    @Operation(summary = "Get exchange rate", description = "Get the average exchange rate for gold")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "400", description = "Przekroczony limit", content = @Content),
            @ApiResponse(responseCode = "404", description = "Data not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Application error", content = @Content)
    })
    @GetMapping("/get")
    public ResponseNBP getAverageRate(
            @Parameter(description = "Start date (yyyy-MM-dd)") @RequestParam String start_date,
            @Parameter(description = "End date (yyyy-MM-dd)") @RequestParam String end_date) {
        ResponseNBP response = service.getAvg_total(
                LocalDate.parse(start_date.trim(), DateTimeFormatter.ISO_DATE),
                LocalDate.parse(end_date.trim(), DateTimeFormatter.ISO_DATE));

        return response;
    }
}
