package br.com.sinelacto.loja.api.v1;

import br.com.sinelacto.loja.models.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.core.Relation;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

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
