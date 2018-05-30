package com.countrycinema.ua.service;

import com.countrycinema.ua.dto.user.UserRequestDTO;
import com.countrycinema.ua.dto.user.UserResponseDTO;
import com.countrycinema.ua.persistence.entity.Company;
import com.countrycinema.ua.persistence.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User getCurrentUser();

    Company getCurrentCompany();

    User update(UserRequestDTO requestDTO);

    User create(UserRequestDTO requestDTO);

    List<User> allForCompany(Pageable pageable);

    UserResponseDTO findOne(String id);

    User getOne(String id);

}
