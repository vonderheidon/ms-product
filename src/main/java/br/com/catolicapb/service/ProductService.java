package br.com.catolicapb.service;

import br.com.catolicapb.domain.Product;
import br.com.catolicapb.dto.ProductDTO;
import br.com.catolicapb.exception.AlreadyProductToMakerException;
import br.com.catolicapb.exception.ProductNotFoundException;
import br.com.catolicapb.mapper.ProductMapper;
import br.com.catolicapb.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.catolicapb.constants.ProductConstants.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public void save(ProductDTO productDTO) {
        verifyIfProductExists(productDTO);

        var product = productMapper.dtoToEntity(productDTO);

        productRepository.save(product);
    }

    public void update(Long id, ProductDTO productDTO) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(PRODUCT_MESSAGE_NOT_FOUND_404));

        Optional<Product> existingProduct = productRepository
                .findByDescriptionIgnoreCaseAndMakerIgnoreCase(productDTO.getDescription(), productDTO.getMaker());
        if (existingProduct.isPresent() && !existingProduct.get().getId().equals(id)) {
            throw new AlreadyProductToMakerException(PRODUCT_MESSAGE_EXISTS_400);
        }

        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setMaker(productDTO.getMaker());

        productRepository.save(product);
    }

    public ProductDTO findById(Long id) {
        log.info("Buscando produto com o ID: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(PRODUCT_MESSAGE_NOT_FOUND_404));

        return productMapper.entityToDto(product);
    }

    public Page<ProductDTO> findAll(Pageable pageable) {
        var products = productRepository.findAll(pageable);

        return products.map(productMapper::entityToDto);
    }

    public void delete(Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(PRODUCT_MESSAGE_NOT_FOUND_404));

        productRepository.delete(product);
    }

    private void verifyIfProductExists(ProductDTO productDTO) {
        var product = productRepository
                .findByDescriptionIgnoreCaseAndMakerIgnoreCase(productDTO.getDescription(), productDTO.getMaker());

        if (product.isPresent()) {
            throw new AlreadyProductToMakerException(PRODUCT_MESSAGE_EXISTS_400);
        }
    }
}
