package br.com.catolicapb.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponseDTO {

    private String apiPath;

    private String errorMessage;

    private Integer errorStatusCode;

    private LocalDateTime localDateTime;
}
