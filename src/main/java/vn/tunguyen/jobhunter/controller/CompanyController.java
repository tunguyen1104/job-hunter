package vn.tunguyen.jobhunter.controller;

import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkraft.springfilter.boot.Filter;

import vn.tunguyen.jobhunter.domain.Company;
import vn.tunguyen.jobhunter.domain.dto.ResultPaginationDTO;
import vn.tunguyen.jobhunter.service.CompanyService;
import vn.tunguyen.jobhunter.util.annotation.ApiMessage;

@RestController
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/companies")
    public ResponseEntity<?> createCompany(@Valid @RequestBody Company reqCompany) {

        return ResponseEntity.status(HttpStatus.CREATED).body(this.companyService.handleCreateCompany(reqCompany));
    }

    @GetMapping("/companies")
    @ApiMessage("Get all companies")
    public ResponseEntity<ResultPaginationDTO> getAllCompanies(@Filter Specification<Company> spec, Pageable pageable) {
        return ResponseEntity.ok(this.companyService.getAllCompanies(spec, pageable));
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        return companyService.getCompany(id)
                            .map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/companies")
    public ResponseEntity<Company> updateCompany(@Valid @RequestBody Company reqCompany) {
        Company updatedCompany = this.companyService.updateCompany(reqCompany);
        return ResponseEntity.ok(updatedCompany);
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") long id) {
        this.companyService.deleteCompany(id);
        return ResponseEntity.ok(null);
    }
}
