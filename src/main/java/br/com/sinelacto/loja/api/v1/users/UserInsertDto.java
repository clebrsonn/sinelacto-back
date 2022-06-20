package br.com.sinelacto.loja.api.v1.users;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.server.core.Relation;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(value="user", collectionRelation="users")
public class UserInsertDto extends UserDto {
    private String password;
}
