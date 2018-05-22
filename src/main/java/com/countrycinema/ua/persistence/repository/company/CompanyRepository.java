package com.countrycinema.ua.persistence.repository.company;

import com.countrycinema.ua.persistence.entity.Company;
import com.countrycinema.ua.persistence.repository._core.OptionalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends OptionalRepository<Company, String> {
    Company findOneByEmail(String email);
}
