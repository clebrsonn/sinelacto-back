package br.com.sinelacto.loja.services;

import br.com.sinelacto.loja.api.v1.users.UserInsertDto;
import br.com.sinelacto.loja.api.v1.users.UserResourceAssembler;
import br.com.sinelacto.loja.models.Role;
import br.com.sinelacto.loja.models.User;
import br.com.sinelacto.loja.api.v1.users.UserDto;
import br.com.sinelacto.loja.repository.RoleRepository;
import br.com.sinelacto.loja.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository repository;

    private final RoleRepository roleRepository;

    private final UserResourceAssembler userResourceAssembler;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public Page<UserDto> findAllPaged(String name, PageRequest pageRequest ){
        Page<User>  list = repository.find(name, pageRequest);

        return list.map(userResourceAssembler::toModel);

    }

    @Transactional(readOnly = true)
    public UserDto findById(String id) {
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(()-> new RuntimeException("Entity not found"));

        return userResourceAssembler.toModel(entity);
    }

    @Transactional
    public UserDto insert(UserInsertDto dto) {
        User entity = new User();
        copyDtoToEntity(dto, entity);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity = repository.save(entity);
        return userResourceAssembler.toModel(entity);
    }
    private void copyDtoToEntity(UserDto dto, User entity) {

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());


        entity.getRoles().clear();
        for (String roleDTO: dto.getRoleAuthorities()) {
            Role role = roleRepository.findByAuthority(roleDTO);
            entity.getRoles().add(role);
        }

    }


    @Transactional
    public UserDto update(String id, UserDto dto) {
        Optional<User> entity = repository.findById(id);
        copyDtoToEntity(dto, entity.get());
        User user = repository.save(entity.get());
        return userResourceAssembler.toModel(user);
    }

    public void delete(String username) {
        repository.deleteById(username);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username).orElseThrow(() ->  new UsernameNotFoundException("Email not found"));
    }
}
