package com.example.demo.article;


import com.example.demo.article.service.ArticleServiceImpl;
import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.component.PageRequestVo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequiredArgsConstructor
@RequestMapping(path = "/api/articles")
@Slf4j
public class ArticleController {
    private final ArticleServiceImpl service;

    @PostMapping("")
    public ResponseEntity<MessengerVo> Save(PageRequestVo vo) {
        service.save(null);
        return ResponseEntity.ok(new MessengerVo());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessengerVo> deleteById(@PathVariable long id) {
        service.deleteById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("")
    public ResponseEntity<MessengerVo> findAll(PageRequestVo vo) {
        service.findAll(null);
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessengerVo> findById(@PathVariable long id) {
        service.findById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("/count")
    public ResponseEntity<MessengerVo> count(PageRequestVo vo) {
        service.count();
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<MessengerVo> existsById(@PathVariable long id) {
        service.existsById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }
}