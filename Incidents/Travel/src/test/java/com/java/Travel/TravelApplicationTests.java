package com.java.Travel;

import com.java.Travel.controller.dto.CompanyDTO;
import com.java.Travel.controller.dto.IncidentDTO;
import com.java.Travel.controller.dto.TestDTO;
import com.java.Travel.model.AppRating;
import com.java.Travel.model.CompanyEntity;
import com.java.Travel.model.DetachmentEntity;
import com.java.Travel.model.EmployeeEntity;
import com.java.Travel.model.FixedDetachmentsEntity;
import com.java.Travel.model.IncidentsEntity;
import com.java.Travel.model.UserEntity;
import com.java.Travel.repository.AppRatingRepository;
import com.java.Travel.repository.CompanyEntityRepository;
import com.java.Travel.repository.DetachmentRepository;
import com.java.Travel.repository.EmployeeRepository;
import com.java.Travel.repository.FixedDetachmentsRepository;
import com.java.Travel.repository.IncidentEntityRepository;
import com.java.Travel.repository.ProblemsRepository;
import com.java.Travel.repository.UserEntityRepository;
import com.java.Travel.service.AppRatingService;
import com.java.Travel.service.CompanyService;
import com.java.Travel.service.DetachmentService;
import com.java.Travel.service.FixedDetachmentsService;
import com.java.Travel.service.IncidentService;
import com.java.Travel.service.ServiceImpl.AppRatingServiceImpl;
import com.java.Travel.service.ServiceImpl.CompanyServiceImpl;
import com.java.Travel.service.ServiceImpl.DetachmentServiceImpl;
import com.java.Travel.service.ServiceImpl.FixedDetachmentsServiceImpl;
import com.java.Travel.service.ServiceImpl.IncidentServiceImpl;
import com.java.Travel.service.ServiceImpl.UserServiceImpl;
import com.java.Travel.service.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TravelApplicationTests {


    @Autowired
    private FixedDetachmentsRepository fixedDetachmentsRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AppRatingRepository appRatingRepository;
    @Autowired
    private ProblemsRepository problemsRepository;
    
    @Autowired
    private UserEntityRepository userRepo;

    @Autowired
    private CompanyEntityRepository companyRepo;

    @Autowired
    private DetachmentRepository detachmentRepo;
    
    @Autowired
    private IncidentEntityRepository incidentRepo;


    private CompanyService companyServ;

    private AppRatingService appRatingServiceImpl;

    private DetachmentService detachmentServ;

    private FixedDetachmentsService fixedDetachmentServiceImpl;

    private IncidentService incidentServ;

    private UserService userServ;
    
 
    @BeforeEach
    public void init() {
        userServ = new UserServiceImpl(userRepo);
        companyServ = new CompanyServiceImpl(companyRepo);
        detachmentServ = new DetachmentServiceImpl(detachmentRepo);
        incidentServ = new IncidentServiceImpl(incidentRepo);
        appRatingServiceImpl = new AppRatingServiceImpl(appRatingRepository);
        fixedDetachmentServiceImpl = new FixedDetachmentsServiceImpl(fixedDetachmentsRepository);

        userRepo.save(new UserEntity("1", "1", "1", "1"));
        userRepo.save(new UserEntity("2", "2", "2", "2"));
        userRepo.save(new UserEntity("3", "3", "3", "2"));

        companyRepo.save(new CompanyEntity(1L, "1", "1", "1"));
        companyRepo.save(new CompanyEntity(2L, "2", "2", "2"));
        companyRepo.save(new CompanyEntity(3L, "3", "3", "3"));

        detachmentRepo.save(new DetachmentEntity("1", "1"));
        detachmentRepo.save(new DetachmentEntity("2", "2"));
        detachmentRepo.save(new DetachmentEntity("3", "3"));
        
        incidentRepo.save(new IncidentsEntity("1", "1"));
        incidentRepo.save(new IncidentsEntity("2", "2"));
        incidentRepo.save(new IncidentsEntity("3", "3"));
    }
    

   @Test
    public void findAllUsers() {
        List<UserEntity> expacted = new ArrayList<>();
        expacted.add(new UserEntity());
        expacted.add(new UserEntity());
        expacted.add(new UserEntity());

        List<UserEntity> actual = userServ.findAll();

        assertEquals(expacted.size(), actual.size());
    }
    
    @Test
    public void findUserById() {
        UserEntity expacted = new UserEntity("1", "1", "1", "1");
        UserEntity actual = userServ.findUserById1(1L);

        assertEquals(expacted, actual);
    }
    
    @Test
    public void saveUserSuccess() {
        UserEntity obj = new UserEntity("4", "4", "4", "4");
        boolean actual = userServ.save(obj);

        assertEquals(true, actual);
    }
    
    @Test
    public void saveUserUnsuccess() {
        UserEntity obj = new UserEntity("1", "1", "1", "1");
        boolean actual = userServ.save(obj);

        assertEquals(false, actual);
    }

    @Test
    public void findAllCompanies() {
        List<CompanyEntity> expacted = new ArrayList<>();
        expacted.add(new CompanyEntity());
        expacted.add(new CompanyEntity());
        expacted.add(new CompanyEntity());

        List<CompanyEntity> actual = companyServ.findAll1();

        assertEquals(expacted.size(), actual.size());
    }
    
    @Test
    public void findCompanyByName() {
        CompanyEntity expacted = new CompanyEntity(1L, "1", "1", "1");
        CompanyEntity actual = companyServ.findCompanyByName1("1");

        assertEquals(expacted, actual);
    }
    
    @Test
    public void saveCompanySuccess() {
        CompanyEntity obj = new CompanyEntity(4L, "4", "4", "4");
        boolean actual = companyServ.save1(obj);

        assertEquals(true, actual);
    }
    
    @Test
    public void saveCompanyUnsuccess() {
        CompanyEntity obj = new CompanyEntity(1L, "1", "1", "1");
        boolean actual = companyServ.save1(obj);

        assertEquals(false, actual);
    }
    
    @Test
    public void findAllDetachments() {
        List<DetachmentEntity> expacted = new ArrayList<>();
        expacted.add(new DetachmentEntity());
        expacted.add(new DetachmentEntity());
        expacted.add(new DetachmentEntity());

        List<DetachmentEntity> actual = detachmentServ.findAll();

        assertEquals(expacted.size(), actual.size());
    }
    
    @Test
    public void findDetachmentById() {
        DetachmentEntity expacted = new DetachmentEntity("1", "1");
        DetachmentEntity actual = detachmentServ.findById(1L);
        assertEquals(expacted, actual);
    }
    
    @Test
    public void saveDetachmentSuccess() {
        DetachmentEntity obj = new DetachmentEntity("4", "4");
        boolean actual = detachmentServ.save(obj);

        assertEquals(true, actual);
    }
    
    @Test
    public void saveDetachmentUnsuccess() {
        DetachmentEntity obj = new DetachmentEntity("1", "1");
        boolean actual = detachmentServ.save(obj);

        assertEquals(false, actual);
    }
    
    @Test
    public void findAllIncidents() {
        List<IncidentsEntity> expacted = new ArrayList<>();
        expacted.add(new IncidentsEntity());
        expacted.add(new IncidentsEntity());
        expacted.add(new IncidentsEntity());

        List<IncidentsEntity> actual = incidentServ.findALL();

        assertEquals(expacted.size(), actual.size());
    }
    
    @Test
    public void findIncidentById() {
        IncidentsEntity expacted = new IncidentsEntity("1", "1");
        IncidentsEntity actual = incidentServ.findById(1L);

        assertEquals(expacted, actual);
    }
    
    @Test
    public void saveIncidentSuccess() {
        IncidentsEntity obj = new IncidentsEntity("4", "4");
        boolean actual = incidentServ.save(obj);

        assertEquals(true, actual);
    }
    
    @Test
    public void saveIncidentUnsuccess() {
        IncidentsEntity obj = new IncidentsEntity("1", "1");
        boolean actual = incidentServ.save(obj);

        assertEquals(false, actual);
    }
 

    
    @Test
    public void save() {
        companyServ.save(new CompanyDTO("Fake"));
    }

    @Test
    public void findAll() {
        List<CompanyEntity> list = new ArrayList<>();
        CompanyEntity companyEntity1 = new CompanyEntity();
        CompanyEntity companyEntity2 = new CompanyEntity();
        list.add(companyEntity1);
        list.add(companyEntity2);

        list = companyRepo.findAllByCompanyName("IT");

        List<CompanyDTO> empList = companyServ.findAll();

        assertEquals(2, empList.size());
    }

    @Test
    public void findAllPageable() {
        Pageable pageable = (Pageable) PageRequest.of(0, 4, Sort.by("companyName").ascending());
        Page<CompanyEntity> companyEntities = new PageImpl<>(Arrays.asList(
                new CompanyEntity("IT")));

        companyEntities = companyRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        Page<CompanyEntity> expectedCompanyEntitiesList = companyServ.findAll((org.springframework.data.domain.Pageable) pageable);

        assertEquals(expectedCompanyEntitiesList.get().count(), 4);
    }

    @Test
    public void findAllIsEmpty() {
        Pageable pageable = (Pageable) PageRequest.of(0, 4, Sort.by("companyName").ascending());
        Page<CompanyEntity> companyEntities = new PageImpl<>(new ArrayList<>());

        companyEntities = companyRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        Page<CompanyEntity> expectedCompanyEntitiesList = companyServ.findAll((org.springframework.data.domain.Pageable) pageable);

        assertThat(expectedCompanyEntitiesList).isEmpty();
    }

    @Test
    public void findAllIsNull() {
        Pageable pageable = (Pageable) PageRequest.of(0, 4, Sort.by("companyName").ascending());

        companyRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        Page<CompanyEntity> expectedCompanyEntitiesList = companyServ.findAll((org.springframework.data.domain.Pageable) pageable);

        assertThat(expectedCompanyEntitiesList).isNull();
    }

    @Test
    public void findOneById() {
        Long id = 1L;
        Optional<CompanyEntity> companyEntity = Optional.of(new CompanyEntity(id, "Fake"));
        companyEntity = companyRepo.findById(id);
        CompanyDTO actualCompany = companyServ.findOne(id);
        assertEquals(id, actualCompany.getId());
    }

    @Test
    public void findOneByIdNotFound() {
        Long id = 2L;
        companyRepo.findById(id);
        Optional.empty();
        CompanyDTO actualCompany = companyServ.findOne(id);
        assertNull(actualCompany);
    }

    @Test
    public void getCompanyIdByName() {
        Long id = 1L;
        CompanyEntity companyEntity = new CompanyEntity(id, "Fake");
        id = companyRepo.getCompanyIdByName(companyEntity.getCompanyName());
        Long actualId = companyServ.getCompanyIdByName(companyEntity.getCompanyName());
        assertEquals(id, actualId);
    }

    @Test
    public void getCompanyIdByNameNotFound() {

        Long actualId = companyServ.getCompanyIdByName("IT");
        assertNull(actualId);

    }
    @Test
    public void getIncidentFalse() {
        String name = "False";
        List<IncidentsEntity> list = new ArrayList<>();
        IncidentsEntity incidentEntity1 = new IncidentsEntity();
        IncidentsEntity incidentEntity2 = new IncidentsEntity();
        list = incidentRepo.getIncidentsFalse(name);
        List<IncidentsEntity> actualIncident = incidentServ.getIncidentsFalse("False");
    }
    @Test
    public void getIncidentFalse2() {
        List<IncidentsEntity> a = null;
        List<IncidentsEntity> b  =  incidentRepo.getIncidentsFalse("False");
        assertEquals(a, b);
    }
    @Test
    public void getIncidentTrue() {
        String name = "True";
        List<IncidentsEntity> list = new ArrayList<>();
        IncidentsEntity incidentEntity1 = new IncidentsEntity();
        list = incidentRepo.getIncidentsTrue(name);
        List<IncidentsEntity> actualIncident = incidentServ.getIncidentsTrue("True");
        assertEquals(1, actualIncident.size());
    }
    @Test
    public void getIncidentTrue2() {
        List<IncidentsEntity> a = null;
        List<IncidentsEntity> b  =  incidentRepo.getIncidentsTrue("True");
        assertEquals(a, b);
    }
    @Test
    public void addFixDetachment() {
        List<CompanyEntity> list = new ArrayList<>();
        list = companyRepo.findAll();
        assertEquals(list, null);
    }
    @Test
    public void addFixDetachment2() {
        List<DetachmentEntity> list = new ArrayList<>();
        list = detachmentRepo.findAll();
        assertEquals(list, null);
    }
    @Test
    public void addDetachment() {
        List<EmployeeEntity> list = new ArrayList<>();
        list = employeeRepository.findAll();
        assertEquals(list, null);
    }
    @Test
    public void addDetachment2() {
        List<DetachmentEntity> list = new ArrayList<>();
        list = detachmentRepo.findAll();
        List<DetachmentEntity> duplicates = list.stream()

                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .map(Map.Entry::getKey)
                //собираем в список
                .collect(Collectors.toList());

        assertEquals(duplicates, null);

    }
    @Test
    public void addReport() {
        List<IncidentsEntity> list = new ArrayList<>();
        list = incidentRepo.findAll();
        assertEquals(list, null);
    }
    @Test
    public void addReport2() {
        Long id = 1L;
        String a = incidentRepo.getIncidentsReactionByID(id);
        assertEquals(a, null);
    }


    @Test
    public void addProblem() {
        List<EmployeeEntity> list = new ArrayList<>();
        list = employeeRepository.findAll();
        assertEquals(list, null);
    }
    @Test
    public void addProblem2() {
        String name = null;

        DetachmentEntity obj = detachmentRepo.findDetachmentEntityByDetachmentName(name);
        assertEquals(obj, null);
    }
    @Test
    public void findIncidents() {
        List<IncidentsEntity> list = new ArrayList<>();
        list = incidentRepo.findAll();
        assertEquals(list, null);
    }
    @Test
    public void findIncidentsByIncidentName() {
        String name = "IT";
        IncidentsEntity obj = new IncidentsEntity();
        obj =incidentRepo.findIncidentEntityByIncidentName(name);
        assertEquals(obj, null);
    }
    @Test
    public void tryFixDetachment() {
        List<DetachmentEntity> list = new ArrayList<>();
        list = detachmentRepo.findAll();
        assertEquals(list, null);
    }
    @Test
    public void tryFixDetachment2() {
        FixedDetachmentsEntity obj = new FixedDetachmentsEntity();
        Boolean a = fixedDetachmentServiceImpl.save(obj);
        assertEquals(true, a);

    }
    @Test
    public void addIncident() {

        IncidentsEntity obj = new IncidentsEntity();
        Boolean a = incidentServ.save(obj);
        assertEquals(true, a);

    }
    @Test
    public void addIncident2() {
        String name = new String();
       IncidentsEntity obj = incidentRepo.findIncidentEntityByIncidentName(name);

        assertEquals(obj, null);
    }
    @Test
    public void addRating() {
        List<AppRating> list = new ArrayList<>();
        list = appRatingRepository.findAll();
        assertEquals(list, null);
    }
    @Test
    public void addRating2() {
        AppRating obj = new  AppRating();
        assertEquals(obj, null);
    }
    @Test
    public void login() {

        UserEntity obj = new UserEntity();
        Boolean a = userServ.save(obj);
        assertEquals(true, a);
    }
    @Test
    public void login2() {
        String name = "Nadja";
        UserEntity a = userRepo.findByLogin(name);
        if (a != null) {
            System.out.println("Пользователь с таким логином уже существует");
        }

    }
    @Test
    public void registration() {
        UserEntity obj = new UserEntity();
        Boolean a = userServ.save(obj);
        assertEquals(true, a);
    }
    @Test
    public void registration2() {
        String name = "Nadja";
        UserEntity a = userRepo.findByLogin(name);
        assertEquals(a, new UserEntity());
    }
    
}
