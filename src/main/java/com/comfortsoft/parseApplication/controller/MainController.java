package com.comfortsoft.parseApplication.controller;

import com.comfortsoft.parseApplication.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/file/xlsx")
public class MainController {
    @Autowired
    private FileService fileService;
    @Operation(summary = "Возвращает N-ное максимальное число из файла Xlsx (используется алгоритм QuickSort)")
    @GetMapping("/search")
    public int getNthLargestNumberFromXlsx(@RequestParam String filePath, @RequestParam int N) throws IOException {
        return fileService.findNthLargestNumberFromXlsx(filePath, N);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleMyCustomException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
