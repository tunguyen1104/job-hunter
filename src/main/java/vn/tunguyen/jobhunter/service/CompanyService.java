package vn.tunguyen.jobhunter.service;

import org.springframework.stereotype.Service;
import vn.tunguyen.jobhunter.domain.Company;
import vn.tunguyen.jobhunter.repository.CompanyRepository;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company handleCreateCompany(Company c) {
        return this.companyRepository.save(c);
    }
}