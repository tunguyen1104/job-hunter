package vn.tunguyen.jobhunter.service;

import java.util.List;
import java.util.Optional;

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

    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();
    }

    public Optional<Company> getCompany(Long id) {
        return companyRepository.findById(id);
    }

    public Company updateCompany(Company c) {
        Optional<Company> companyOptional = this.companyRepository.findById(c.getId());
        if (companyOptional.isPresent()) {
            Company currentCompany = companyOptional.get();
            currentCompany.setLogo(c.getLogo());
            currentCompany.setName(c.getName());
            currentCompany.setDescription(c.getDescription());
            currentCompany.setAddress(c.getAddress());
            return this.companyRepository.save(currentCompany);
        }
        return null;
    }

    public void deleteCompany(long id) {
        this.companyRepository.deleteById(id);
    }
}