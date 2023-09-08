package com.micro.faceHR.domain.services;

import com.micro.faceHR.constants.Status;
import com.micro.faceHR.domain.models.Company;
import com.micro.faceHR.domain.models.User;
import com.micro.faceHR.domain.repositories.CompanyRepository;
import com.micro.faceHR.domain.repositories.UserRepository;
import com.micro.faceHR.dto.EmployeeInfo;
import com.micro.faceHR.exceptions.CompanyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final CompanyRepository companyRepository;

    public User addUserToCompany(UUID userId, UUID companyId){
        // fetch user by id
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UsernameNotFoundException(" User with ID "+ userId +" not found ")
        );
        // fetch company
        Company company = companyRepository.findById(companyId).orElseThrow(
                ()->new CompanyNotFoundException(String.format("Company with ID %s is not found", companyId))
        );
        user.setCompany(company);
        return userRepository.save(user);
    }

    // Todo fetch user

    public User getEmployeeById(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException(String.format("user with ID %s not found", userId)));
    }

    // Todo edit user

    public User updateEmployeeInfo(EmployeeInfo employeeInfo, UUID userId){
        // fetch user
        User employee = getEmployeeById(userId);
        employee.setFirstName(employeeInfo.getFirstName());
        employee.setLastName(employeeInfo.getLastName());
        employee.setEmail(employeeInfo.getEmail());
        employee.setGender(employeeInfo.getGender());
        employee.setStartDate(employeeInfo.getStartDate());
        employee.setStatus(employeeInfo.getStatus());
        employee.setNationality(employeeInfo.getNationality());
        employee.setJobTitle(employeeInfo.getJobTitle());
        employee.setIDN(employeeInfo.getIDN());
        employee.setDateOfBirth(employeeInfo.getDateOfBirth());
        employee.setMaritalStatus(employeeInfo.getMaritalStatus());
        employee.setContractType(employeeInfo.getContractType());
        employee.setSocialSecurityNumber(employeeInfo.getSocialSecurityNumber());
        employee.setTaxPayerNumber(employeeInfo.getTaxPayerNumber());
        return userRepository.save(employee);
    }

    // Todo deactivate user

    public void deactivateEmployeeAccount(UUID userId) {
        User employee = getEmployeeById(userId);
        employee.setStatus(Status.INACTIVE);
    }

}
