package br.com.catolicapb.controller;

import br.com.catolicapb.dto.ProductDTO;
import br.com.catolicapb.dto.ResponseDTO;
import br.com.catolicapb.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.catolicapb.constants.ProductConstants.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> save(@Valid @RequestBody ProductDTO productDTO) {
        productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDTO.builder()
                        .statusCode(CODE_STATUS_201)
                        .message(PRODUCT_MESSAGE_CREATED_201)
                        .build());
    }

    @GetMapping("/findAll")
    public Page<ProductDTO> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
        productService.update(id, productDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseDTO.builder()
                        .statusCode(CODE_STATUS_200)
                        .message(PRODUCT_MESSAGE_UPDATED_200)
                        .build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseDTO.builder()
                        .statusCode(CODE_STATUS_200)
                        .message(PRODUCT_MESSAGE_DELETED_200)
                        .build());
    }
}
