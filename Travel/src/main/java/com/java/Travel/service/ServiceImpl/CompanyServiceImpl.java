package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.CompanyDTO;
import com.java.Travel.exception.UserNotFoundException;
import com.java.Travel.model.CompanyEntity;
import com.java.Travel.repository.CompanyEntityRepository;
import com.java.Travel.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyEntityRepository companyRepository;


    @Override
    public Page<CompanyEntity> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public CompanyDTO findOne(Long id) {
        Optional<CompanyEntity> companyEntity = companyRepository.findById(id);
        if (companyEntity.isPresent()) {
            CompanyDTO companyDTO = new CompanyDTO();
            companyDTO.setId(companyEntity.get().getId());
            companyDTO.setName(companyEntity.get().getCompanyName());
            companyDTO.setCompanyAddress(companyEntity.get().getCompanyAddress());
            companyDTO.setCompanyActivity(companyEntity.get().getCompanyActivity());

            /*List<UserDTO> userDTOList = companyEntity
                    .get()
                    .getUsers()
                    .stream()
                    .map(p -> new BusDTO(p.getId(), p.getName(), p.getSideNumber(),
                            new CompanyDTO(p.getCompany().getId(), p.getCompany().getName(), p.getCompany().getRating())))
                    .collect(Collectors.toList());*/

            /*List<UserDTO> userDTOList;
            userDTOList.sort(Comparator.comparing(o -> o.getName()));
            companyDTO.setBusDTOList(userDTOList);*/
            return companyDTO;
        }
        return null;
    }


    @Override
    public Long getCompanyIdByName(String name) {
        return companyRepository.getCompanyIdByName(name);
    }

    @Transactional
    @Override
    public void save(CompanyDTO companyDTO) {
        CompanyEntity companyEntity = new CompanyEntity(companyDTO.getName());
        companyRepository.save(companyEntity);
    }

    @Transactional
    @Override
    public void update(CompanyDTO companyDTO) {
        Optional<CompanyEntity> editCompanyEntity = companyRepository.findById(companyDTO.getId());
        if (editCompanyEntity.isPresent()) {
            editCompanyEntity.get().setCompanyName(companyDTO.getName());
            companyRepository.save(editCompanyEntity.get());
        } else {
            throw new UserNotFoundException("Company with id=" + companyDTO.getId() + " not found");
        }
    }

    @Override
    public CompanyDTO findCompanyByName(String company) {
        /*CompanyEntity companyEntity = companyRepository.findByName(company);*/
        CompanyEntity companyEntity = new CompanyEntity();
        CompanyDTO companyDTO = new CompanyDTO();
        if (companyEntity != null) {
            companyDTO.setId(companyEntity.getId());
            companyDTO.setName(companyEntity.getCompanyName());
        } else {
            throw new EntityNotFoundException("Company with name=" + company + " not found!");
        }
        return companyDTO;
    }

    @Override
    public List<CompanyDTO> findAll() {
//        List<CompanyEntity> companyEntities = companyRepository.findAllAndOrderByName();
        List<CompanyEntity> companyEntities = companyRepository.findAll();
        return companyEntities.stream().map(a -> new CompanyDTO(a.getId(), a.getCompanyName())).collect(Collectors.toList());
    }

    /*@Override
    public Page<CompanyEntity> findAllByCriteria(PageRequest pageRequest, String name) {
        return companyRepository.findAllByNameIgnoreCase(name, pageRequest);
    }*/

    @Override
    public List<CompanyDTO> getCompanyName() {
        List<CompanyEntity> companyEntities = companyRepository.findAllByCompanyName("IT");
        return companyEntities.stream().map(a -> new CompanyDTO(a.getId(), a.getCompanyName())).collect(Collectors.toList());
    }

}
