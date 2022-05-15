package com.java.Travel;

import com.java.Travel.controller.dto.CompanyDTO;
import com.java.Travel.model.CompanyEntity;
import com.java.Travel.model.DetachmentEntity;
import com.java.Travel.model.IncidentsEntity;
import com.java.Travel.model.UserEntity;
import com.java.Travel.repository.AppRatingRepository;
import com.java.Travel.repository.CompanyEntityRepository;
import com.java.Travel.repository.DetachmentRepository;
import com.java.Travel.repository.EmployeeRepository;
import com.java.Travel.repository.FixedDetachmentsRepository;
import com.java.Travel.repository.IncidentEntityRepository;
import com.java.Travel.repository.ProblemsRepository;
import com.java.Travel.repository.TestsRepository;
import com.java.Travel.repository.UserEntityRepository;
import com.java.Travel.service.AppRatingService;
import com.java.Travel.service.CompanyService;
import com.java.Travel.service.DetachmentService;
import com.java.Travel.service.FixedDetachmentsService;
import com.java.Travel.service.IncidentService;
import com.java.Travel.service.ProblemService;
import com.java.Travel.service.ServiceImpl.AppRatingServiceImpl;
import com.java.Travel.service.ServiceImpl.CompanyServiceImpl;
import com.java.Travel.service.ServiceImpl.DetachmentServiceImpl;
import com.java.Travel.service.ServiceImpl.FixedDetachmentsServiceImpl;
import com.java.Travel.service.ServiceImpl.IncidentServiceImpl;
import com.java.Travel.service.ServiceImpl.ProblemServiceImpl;
import com.java.Travel.service.ServiceImpl.TestsServiceImpl;
import com.java.Travel.service.ServiceImpl.UserServiceImpl;
import com.java.Travel.service.TestsService;
import com.java.Travel.service.UserService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TravelApplicationTests {


    @Autowired
    private FixedDetachmentsRepository fixedDetachmentsRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TestsRepository testsRepository;
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

    private TestsService testServiceImpl;

    private AppRatingService appRatingServiceImpl;

    private DetachmentService detachmentServ;

    private FixedDetachmentsService fixedDetachmentServiceImpl;

    private IncidentService incidentServ;

    private UserService userServ;
    
    private ProblemService problemServiceImpl;
    
  

    @BeforeEach
    public void init() {
        userServ = new UserServiceImpl(userRepo);
        companyServ = new CompanyServiceImpl(companyRepo);
        detachmentServ = new DetachmentServiceImpl(detachmentRepo);
        incidentServ = new IncidentServiceImpl(incidentRepo);
        testServiceImpl = new TestsServiceImpl(testsRepository);
        appRatingServiceImpl = new AppRatingServiceImpl(appRatingRepository);
        fixedDetachmentServiceImpl = new FixedDetachmentsServiceImpl(fixedDetachmentsRepository);
        problemServiceImpl = new ProblemServiceImpl(problemsRepository);

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
        pageable = (Pageable) PageRequest.of(0, 4, Sort.by("companyName").ascending());
        Page<CompanyEntity> companyEntities = new PageImpl<>(Arrays.asList(
                new CompanyEntity("IT")));

        companyEntities = companyRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        Page<CompanyEntity> expectedCompanyEntitiesList = companyService.findAll((org.springframework.data.domain.Pageable) pageable);

        assertEquals(expectedCompanyEntitiesList.get().count(), 4);
        verify(companyRepo, times(1)).findAll(pageable);
    }

    @Test
    public void findAllIsEmpty() {
        pageable = (Pageable) PageRequest.of(0, 4, Sort.by("companyName").ascending());
        Page<CompanyEntity> companyEntities = new PageImpl<>(new ArrayList<>());

        companyEntities = companyRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        Page<CompanyEntity> expectedCompanyEntitiesList = companyService.findAll((org.springframework.data.domain.Pageable) pageable);

        assertThat(expectedCompanyEntitiesList).isEmpty();
    }

    @Test
    public void findAllIsNull() {
        pageable = (Pageable) PageRequest.of(0, 4, Sort.by("companyName").ascending());

        companyRepo.findAll1((org.springframework.data.domain.Pageable) pageable);
        Page<CompanyEntity> expectedCompanyEntitiesList = companyService.findAll((org.springframework.data.domain.Pageable) pageable);

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
        List<IncidentDTO> actualIncident = incidentServ.getIncidentsFalse("False");
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
        List<IncidentDTO> actualIncident = incidentServ.getIncidentsTrue("True");
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
        if(list.isEmpty()){
            System.out.println("База данный о компаниях пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void addFixDetachment2() {
        List<DetachmentEntity> list = new ArrayList<>();
        list = detachmentRepo.findAll();
        if(list.isEmpty()){
            System.out.println("База данный о командах пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void addDetachment() {
        List<EmployeeEntity> list = new ArrayList<>();
        list = employeeRepository.findAll();
        if(list.isEmpty()){
            System.out.println("База данный о сотрудниках пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
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
        if(duplicates.isEmpty()){
            System.out.println("В базе данных есть дубликаты имён компаний, пожалуйста, исправьте");
        } else {
            System.out.println("В базе данных нет дубликатов");
        }
    }
    @Test
    public void addReport() {
        List<IncidentsEntity> list = new ArrayList<>();
        list = incidentRepo.findAll();
        if(list.isEmpty()){
            System.out.println("База данный о сотрудниках пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void addReport2() {
        Long id = 1L;
        String a = incidentRepo.getIncidentsReactionByID(id);
        if (a == null){
            System.out.println("Данные о реакции на данный инцидент ещё не поступили ");
        } else {
            System.out.println("Всё отлично. Получите отчёт");
        }
    }
    @Test
    public void TestDiffIncident() {
        Integer number = 3;
        if(number == 3){
            System.out.println("Вы идеальный знаток");
        } else {
            System.out.println("Вы набрали меньше, чем нужно, попробуйте снова");
        }
    }
    @Test
    public void TestDiffIncident2() {
        TestDTO tests = new  TestDTO();
        if (testServiceImpl.save(tests)) {
            System.out.println("Сохранение в бд произошло успешно");
        }
        else
        {
            System.out.println("Произошла ошибка при сохранении данных в бд, попробуйте снова");
        }
    }
    @Test
    public void TestMoment() {
        Integer number = 3;
        if(number == 3){
            System.out.println("Вы идеальный знаток");
        } else {
            System.out.println("Вы набрали меньше, чем нужно, попробуйте снова");
        }
    }
    @Test
    public void TestMoment2() {
        TestDTO testsDTO = new TestDTO();
        if (testServiceImpl.save(testsDTO)) {
            System.out.println("Сохранение в бд произошло успешно");
        }
        else
        {
            System.out.println("Произошла ошибка при сохранении данных в бд, попробуйте снова");
        }
    }
    @Test
    public void addProblem() {
        List<EmployeeEntity> list = new ArrayList<>();
        list = employeeRepository.findAll();
        if(list.isEmpty()){
            System.out.println("База данный о сотрудниках пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void addProblem2() {
        String name = null;

        DetachmentEntity obj = detachmentRepo.findDetachmentEntityByDetachmentName(name);
        if(!(obj == null)){
            System.out.println("Данных есть, выполнение действия возможно");
        } else {
            System.out.println("Информации о такой команде помощи нет в бд, проверьте правильность введённого названия");
        }
    }
    @Test
    public void findIncidents() {
        List<IncidentsEntity> list = new ArrayList<>();
        list = incidentRepo.findAll();
        if(list.isEmpty()){
            System.out.println("База данный о инцидентах пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void findIncidentsByIncidentName() {
        String name = "IT";
        IncidentsEntity obj = new IncidentsEntity();
        obj =incidentRepo.findIncidentEntityByIncidentName(name);
        if(obj == null){
            System.out.println("Информации о такой команде помощи нет в бд, проверьте правильность введённого названия");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void tryFixDetachment() {
        List<DetachmentEntity> list = new ArrayList<>();
        list = detachmentRepo.findAll();
        if(list.isEmpty()){
            System.out.println("База данный о командах пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
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
        IncidentsEntity Null = null;
        if (obj != Null) {
            System.out.println("Инцидент с таким именем уже есть, посмотрите, пожалуйста, первую помощь при возникновении данного инцидента");
        }
        else
        {
            System.out.println("Ваш инцидент уникален. Заявка принята. Пожалуйста, ожидайте помощи");
        }
    }
    @Test
    public void addRating() {
        List<AppRating> list = new ArrayList<>();
        list = appRatingRepository.findAll();
        if(list.isEmpty()){
            System.out.println("Данное приложение ещё никто не оценивал, Вы будете первым");
        } else {
            System.out.println("Вы можете посмотреть, как оценили данное приложение другие пользователи");
        }
    }
    @Test
    public void addRating2() {
        AppRating obj = new  AppRating();
        if (appRatingServiceImpl.save(obj)) {
            System.out.println("Запись в бд произошла успешно");
        }
        else
        {
            System.out.println("Произошла ошибка при сохранении данных в бд, попробуйте снова");
        }
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
        if (a != null) {
            System.out.println("Пользователь с таким логином уже существует");
        }
    }
    
    @Test
    public void test1() {
          ProblemService problemservice1 = new ProblemServiceImpl(problemsRepository);
    }

    
}
