package com.countrycinema.ua.service.impl;

import com.countrycinema.ua.dto.user.UserRequestDTO;
import com.countrycinema.ua.dto.user.UserResponseDTO;
import com.countrycinema.ua.exception.NoUserSessionException;
import com.countrycinema.ua.exception.ObjectNotFoundException;
import com.countrycinema.ua.persistence.entity.Company;
import com.countrycinema.ua.persistence.entity.User;
import com.countrycinema.ua.persistence.repository.user.UserRepository;
import com.countrycinema.ua.service.UserService;
import com.countrycinema.ua.service.core.ServiceCoreImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceCoreImpl<User, String> implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper) {
        super(userRepository);
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository
                .findOneByEmail(email)
                .orElseThrow(NoUserSessionException::new);
    }

    @Override
    public Company getCurrentComopany() {
        return getCurrentUser().getCompany();
    }

    @Override
    public User update(UserRequestDTO requestDTO) {
        return null;
    }

    @Override
    public User create(UserRequestDTO requestDTO) {
        return null;
    }

    @Override
    public List<User> allForCompany(Pageable pageable) {
        List<User> users = userRepository.findAllByCompanyId(getCurrentComopany().getId());
        // TODO: 20.05.18 how to map to the DTO
        return null;
    }

    @Override
    public UserResponseDTO findOne(String id) {
        User user = getOne(id);
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public User getOne(String id) {
        return userRepository
                .findOneById(id)
                .orElseThrow(() -> new ObjectNotFoundException("No such user exception"));
    }
}
