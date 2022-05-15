package br.com.sinelacto.loja.api.v1;

import br.com.sinelacto.loja.models.Category;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Set;


@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Relation(value="product", collectionRelation="products")
public class ProductResource extends RepresentationModel<ProductResource> {
    private Long id;
    @Length(min = 3)
    @NotEmpty(message = "Must need a name")
    private String name;
    @Positive
    private BigDecimal price;
    @URL
    private String image;
    @NotBlank
    @Length(min = 5)
    @NotNull
    private String description;

    private Set<Category> categories;
}
