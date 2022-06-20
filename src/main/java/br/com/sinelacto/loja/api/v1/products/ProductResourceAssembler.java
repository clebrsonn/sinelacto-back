package br.com.sinelacto.loja.api.v1.products;

import br.com.sinelacto.loja.models.Product;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ProductResourceAssembler extends RepresentationModelAssemblerSupport<Product, ProductResource> {

    public ProductResourceAssembler() {
        super(ProductController.class, ProductResource.class);
    }

    @Override
    public ProductResource toModel(Product entity) {
        return ProductResource.builder()
                .id(entity.getId())
                .image(entity.getImage())
                .description(entity.getDescription())
                .name(entity.getName())
                .price(entity.getPrice())
                .categories(entity.getCategories())
                .build();
    }

    public Product fromModel(ProductResource productResource){
        return null;
    }
}
