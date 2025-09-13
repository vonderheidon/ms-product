package br.com.catolicapb.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ProductDTO {

    @NotBlank(message = "O campo descrição é obrigatório")
    @Size(min = 2, max = 60, message = "O descrição deve possuir entre 2 a 60 caracteres")
    private String description;

    @NotNull(message = "O campo preço é obrigatório")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
    private BigDecimal price;

    @NotBlank(message = "O campo fabricante é obrigatório")
    @Size(min = 2, max = 100, message = "O fabricante deve possuir entre 2 a 100 caracteres")
    private String maker;
}