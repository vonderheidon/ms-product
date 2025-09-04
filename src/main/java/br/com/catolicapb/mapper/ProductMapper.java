package br.com.catolicapb.mapper;

import br.com.catolicapb.domain.Product;
import br.com.catolicapb.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    public Product dtoToEntity(ProductDTO productDTO) {
        var product = new Product();
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setMaker(productDTO.getMaker());
        return product;
    }

    public ProductDTO entityToDto(Product product) {
        return ProductDTO.builder()
                .description(product.getDescription())
                .price(product.getPrice())
                .maker(product.getMaker())
                .build();
    }
}
