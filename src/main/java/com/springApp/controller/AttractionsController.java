package com.springApp.controller;

import com.springApp.dto.attractionDto.AboutAttractionDto;
import com.springApp.dto.attractionDto.AttractionDtoToGet;
import com.springApp.dto.attractionDto.AttractionDtoToShow;
import com.springApp.service.BindingResultHandler;
import com.springApp.service.attractionService.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/attractions")
@RequiredArgsConstructor
public class AttractionsController {

    private final AttractionService attractionService;
    private final BindingResultHandler bindingResultHandler;

    @GetMapping("/byType")
    public List<AttractionDtoToShow> getAllAttractionsByType(@RequestParam String type) {
        return attractionService.findByTypeSortByName(type);
    }

    @GetMapping("/bySettlement")
    public List<AttractionDtoToShow> getAllAttractionsBySettlement(@RequestParam String settlementName) {
        return attractionService.findBySettlementName(settlementName);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody @Valid AttractionDtoToGet attractionDto,
                              BindingResult bindingResult) {
        bindingResultHandler.validate(bindingResult);

        attractionService.add(attractionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Attraction successfully added");
    }

    @PatchMapping("/{id}/aboutAttraction")
    public ResponseEntity<String> update(@PathVariable int id,
                                         @RequestBody AboutAttractionDto aboutAttractionDto,
                         BindingResult bindingResult) {
        bindingResultHandler.validate(bindingResult);

        attractionService.update(id, aboutAttractionDto.getAboutAttraction());
        return ResponseEntity.status(HttpStatus.OK).body("Attraction successfully updated");
    }

    @DeleteMapping("/{id}/remove")
    public ResponseEntity<String> delete(@PathVariable int id) {
        attractionService.remove(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Attraction successfully deleted");
    }
}
