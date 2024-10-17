package com.springApp.controller;

import com.springApp.dto.settlementDto.SettlementDto;
import com.springApp.dto.settlementDto.SettlementHasMetroDto;
import com.springApp.dto.settlementDto.SettlementPopulationDto;
import com.springApp.service.BindingResultHandler;
import com.springApp.service.settlementService.SettlementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/settlements")
@RequiredArgsConstructor
public class SettlementsController {

    private final SettlementService settlementService;
    private final BindingResultHandler bindingResultHandler;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody @Valid SettlementDto settlementDto, BindingResult bindingResult) {
        bindingResultHandler.validate(bindingResult);

        settlementService.add(settlementDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Settlement successfully added");
    }

    @PatchMapping("/{id}/population")
    public ResponseEntity<String> updatePopulation(@PathVariable int id,
                                   @RequestBody @Valid SettlementPopulationDto settlementPopulationDto,
                                   BindingResult bindingResult) {
        bindingResultHandler.validate(bindingResult);

        settlementService.update(id, settlementPopulationDto.getPopulation());
        return ResponseEntity.status(HttpStatus.OK).body("Population successfully updated");
    }

    @PatchMapping("/{id}/metro")
    public ResponseEntity<String> updateMetro(@PathVariable int id,
                              @RequestBody @Valid SettlementHasMetroDto settlementHasMetroDto,
                              BindingResult bindingResult) {
        bindingResultHandler.validate(bindingResult);

        settlementService.updateMetro(id, settlementHasMetroDto.isHasMetro());
        return ResponseEntity.status(HttpStatus.OK).body("Metro successfully updated");
    }
}
