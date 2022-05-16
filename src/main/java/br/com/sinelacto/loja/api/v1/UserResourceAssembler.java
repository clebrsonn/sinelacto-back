package br.com.sinelacto.loja.api.v1;

import br.com.sinelacto.loja.models.Product;
import br.com.sinelacto.loja.models.User;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserResourceAssembler extends RepresentationModelAssemblerSupport<User, UserDto> {

    public UserResourceAssembler() {
        super(UserController.class, UserDto.class);
    }

    @Override
    public UserDto toModel(User entity) {
        return UserDto.builder()
                .username(entity.getUsername())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .roleAuthorities(entity.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet()))
                .build();
    }

    public User fromModel(UserDto productResource){
        return new User();
    }
}
