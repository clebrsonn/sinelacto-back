package br.com.sinelacto.loja.api.v1;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(value="user", collectionRelation="users")
public class UserInsertDto extends UserDto {
    private String password;
}
