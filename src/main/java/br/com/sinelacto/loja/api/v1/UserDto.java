package br.com.sinelacto.loja.api.v1;

import br.com.sinelacto.loja.api.v1.ProductResource;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Relation(value="user", collectionRelation="users")
public class UserDto extends RepresentationModel<ProductResource> {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<String> roleAuthorities;
}
