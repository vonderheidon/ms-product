package br.com.catolicapb.constants;

public class ProductConstants {

    private ProductConstants() { }

    public static final Integer CODE_STATUS_201 = 201;
    public static final Integer CODE_STATUS_200 = 200;
    public static final String CODE_STATUS_404 = "404";

    public static final String PRODUCT_MESSAGE_CREATED_201 = "Produto salvo com sucesso!";
    public static final String PRODUCT_MESSAGE_UPDATED_200 = "Produto atualizado com sucesso!";
    public static final String PRODUCT_MESSAGE_NOT_FOUND_404 = "Produto não encontrado com o ID informado";
    public static final String PRODUCT_MESSAGE_EXISTS_400 = "Produto já cadastrado para este fabricante";
    public static final String PRODUCT_MESSAGE_DELETED_200 = "Produto removido com sucesso!";
}
