package net.kuleasycode.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.kuleasycode.entity.RoleEntity;
import net.kuleasycode.entity.UserEntity;
import net.kuleasycode.repository.UserRepository;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (!userEntity.isPresent()) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
		return new org.springframework.security.core.userdetails.User(userEntity.get().getUserName(),
				userEntity.get().getPassword(), getAuthority(userEntity));
    }

    private List<SimpleGrantedAuthority> getAuthority(Optional<UserEntity> userEntity) {
    	List<SimpleGrantedAuthority> result = new ArrayList<>();
    	if (userEntity.get().getRoleEntities().isEmpty()) {
    		throw new UsernameNotFoundException("user invalid");
    	}
    	for (RoleEntity role : userEntity.get().getRoleEntities()) {
    		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleId());
    		result.add(authority);
		}	
        return result;
    }

    public List<UserEntity> findAll() {
        List<UserEntity> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void delete(String userName) {
    	userRepository.deleteById(userName);
    }

	public UserEntity save(UserEntity user) {
		return userRepository.save(user);
	}
}
