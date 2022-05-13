package com.java.Travel.service.impl;


import com.java.Travel.controller.dto.AppRatingDTO;
import com.java.Travel.controller.dto.CompanyDTO;
import com.java.Travel.controller.dto.IncidentDTO;
import com.java.Travel.controller.dto.TestDTO;
import com.java.Travel.model.*;
import com.java.Travel.repository.*;
import com.java.Travel.service.ServiceImpl.AppRatingServiceImpl;
import com.java.Travel.service.ServiceImpl.CompanyServiceImpl;

import com.java.Travel.service.ServiceImpl.IncidentServiceImpl;
import com.java.Travel.service.ServiceImpl.TestsServiceImpl;
import org.apache.catalina.Store;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.sql.Types.NULL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;


public class CompanyServiceImplTest {

    private UserEntityRepository userEntityRepository;
    private CompanyEntityRepository companyRepository;

    private IncidentEntityRepository incidentEntityRepository;

    private DetachmentRepository detachmentRepository;

    private FixedDetachmentsRepository fixedDetachmentsRepository;

    private EmployeeRepository employeeRepository;

    private TestsRepository testsRepository;

    private AppRatingRepository appRatingRepository;

    private Pageable pageable;


    private CompanyServiceImpl companyService;

    private IncidentServiceImpl incidentService;

    private TestsServiceImpl testService;

    private AppRatingServiceImpl appRatingService;
    @Test
    public void save() {
        companyService.save(new CompanyDTO("Fake"));
        verify(companyRepository).save(isA(CompanyEntity.class));
    }

    @Test
    public void findAll() {
        List<CompanyEntity> list = new ArrayList<>();
        CompanyEntity companyEntity1 = new CompanyEntity();
        CompanyEntity companyEntity2 = new CompanyEntity();
        list.add(companyEntity1);
        list.add(companyEntity2);

        list = companyRepository.findAllByCompanyName("IT");

        List<CompanyDTO> empList = companyService.findAll();

        assertEquals(2, empList.size());
        verify(companyRepository, times(1)).findAllByCompanyName("IT");
    }

    @Test
    public void findAllPageable() {
        pageable = PageRequest.of(0, 4, Sort.by("companyName").ascending());
        Page<CompanyEntity> companyEntities = new PageImpl<>(Arrays.asList(
                new CompanyEntity("IT")));

        companyEntities = companyRepository.findAll(pageable);
        Page<CompanyEntity> expectedCompanyEntitiesList = companyService.findAll(pageable);

        assertEquals(expectedCompanyEntitiesList.get().count(), 4);
        verify(companyRepository, times(1)).findAll(pageable);
    }

    @Test
    public void findAllIsEmpty() {
        pageable = PageRequest.of(0, 4, Sort.by("companyName").ascending());
        Page<CompanyEntity> companyEntities = new PageImpl<>(new ArrayList<>());

        companyEntities = companyRepository.findAll(pageable);
        Page<CompanyEntity> expectedCompanyEntitiesList = companyService.findAll(pageable);

        assertThat(expectedCompanyEntitiesList).isEmpty();
        verify(companyRepository, times(1)).findAll(pageable);
    }

    @Test
    public void findAllIsNull() {
        pageable = PageRequest.of(0, 4, Sort.by("companyName").ascending());

        companyRepository.findAll(pageable);
        Page<CompanyEntity> expectedCompanyEntitiesList = companyService.findAll(pageable);

        assertThat(expectedCompanyEntitiesList).isNull();
        verify(companyRepository, times(1)).findAll(pageable);
    }

    @Test
    public void findOneById() {
        Long id = 1L;
        Optional<CompanyEntity> companyEntity = Optional.of(new CompanyEntity(id, "Fake"));
        companyEntity = companyRepository.findById(id);
        CompanyDTO actualCompany = companyService.findOne(id);
        assertEquals(id, actualCompany.getId());
    }

    @Test
    public void findOneByIdNotFound() {
        Long id = 2L;
        companyRepository.findById(id);
        Optional.empty();
        CompanyDTO actualCompany = companyService.findOne(id);
        assertNull(actualCompany);
    }

    @Test
    public void getCompanyIdByName() {
        Long id = 1L;
        CompanyEntity companyEntity = new CompanyEntity(id, "Fake");
        id = companyRepository.getCompanyIdByName(companyEntity.getCompanyName());
        Long actualId = companyService.getCompanyIdByName(companyEntity.getCompanyName());
        assertEquals(id, actualId);
    }

    @Test
    public void getCompanyIdByNameNotFound() {

        Long actualId = companyService.getCompanyIdByName("IT");
        assertNull(actualId);

    }
    @Test
    public void getIncidentFalse() {
        String name = "False";
        List<IncidentsEntity> list = new ArrayList<>();
        IncidentsEntity incidentEntity1 = new IncidentsEntity();
        IncidentsEntity incidentEntity2 = new IncidentsEntity();
        list = incidentEntityRepository.getIncidentsFalse(name);
        List<IncidentDTO> actualIncident = incidentService.getIncidentsFalse("False");
        verify(incidentEntityRepository, times(1)).getIncidentsFalse(name);
    }
    @Test
    public boolean getIncidentFalse2() {
        List<IncidentDTO> a = incidentService.getIncidentsFalse("False");
        List<IncidentsEntity> b  =  incidentEntityRepository.getIncidentsFalse("False");
        return a.equals(b);
    }
    @Test
    public void getIncidentTrue() {
        String name = "True";
        List<IncidentsEntity> list = new ArrayList<>();
        IncidentsEntity incidentEntity1 = new IncidentsEntity();
        list = incidentEntityRepository.getIncidentsTrue(name);
        List<IncidentDTO> actualIncident = incidentService.getIncidentsTrue("True");
        assertEquals(1, actualIncident.size());
        verify(incidentEntityRepository, times(1)).getIncidentsTrue(name);
    }
    @Test
    public boolean getIncidentTrue2() {
        List<IncidentDTO> a = incidentService.getIncidentsTrue("True");
        List<IncidentsEntity> b  =  incidentEntityRepository.getIncidentsTrue("True");
        return a.equals(b);
    }
    @Test
    public void addFixDetachment() {
        List<CompanyEntity> list = new ArrayList<>();
        list = companyRepository.findAll();
        if(list.isEmpty()){
            System.out.println("База данный о компаниях пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void addFixDetachment2() {
        List<DetachmentEntity> list = new ArrayList<>();
        list = detachmentRepository.findAll();
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
        list = detachmentRepository.findAll();
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
        list = incidentEntityRepository.findAll();
        if(list.isEmpty()){
            System.out.println("База данный о сотрудниках пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void addReport2(Long id) {

        String a = incidentEntityRepository.getIncidentsReactionByID(id);
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
        if (testService.save(tests)) {

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
        if (testService.save(testsDTO)) {

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
       /* DetachmentEntity obj = new DetachmentEntity();
        when(detachmentRepository.findDetachmentEntityByDetachmentName(name)).thenReturn(obj);*/
        DetachmentEntity obj = detachmentRepository.findDetachmentEntityByDetachmentName(name);
        if(obj.equals(NULL)){
            System.out.println("Информации о такой команде помощи нет в бд, проверьте правильность введённого названия");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void findIncidents() {
        List<IncidentsEntity> list = new ArrayList<>();
        list = incidentEntityRepository.findAll();
        if(list.isEmpty()){
            System.out.println("База данный о инцидентах пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void findIncidentsByIncidentName(String name) {
        IncidentsEntity obj = new IncidentsEntity();
        obj =incidentEntityRepository.findIncidentEntityByIncidentName(name);
        if(obj.equals(NULL)){
            System.out.println("Информации о такой команде помощи нет в бд, проверьте правильность введённого названия");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void tryFixDetachment() {
        List<DetachmentEntity> list = new ArrayList<>();
        list = detachmentRepository.findAll();
        if(list.isEmpty()){
            System.out.println("База данный о командах пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void tryFixDetachment2() {
        FixedDetachmentsEntity obj = new FixedDetachmentsEntity();
        Boolean a = fixedDetachmentsRepository.save(obj);
        assertEquals(true, a);

    }
    @Test
    public void addIncident() {

        IncidentsEntity obj = new IncidentsEntity();
        Boolean a = incidentEntityRepository.save(obj);
        assertEquals(true, a);

    }
    @Test
    public void addIncident2() {
        String name = new String();
       IncidentsEntity obj = incidentEntityRepository.findIncidentEntityByIncidentName(name);
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
    public void addRating(IncidentsEntity obj) {
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
        AppRatingDTO obj = new  AppRatingDTO();
        if (appRatingService.save(obj)) {
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
        Boolean a = userEntityRepository.save(obj);
        assertEquals(true, a);
    }
    @Test
    public void login2() {
        String name = "Nadja";
        UserEntity a = userEntityRepository.findByLogin(name);
        if (a != null) {
            System.out.println("Пользователь с таким логином уже существует");
        }

    }
    @Test
    public void registration() {
        UserEntity obj = new UserEntity();
        Boolean a = userEntityRepository.save(obj);
        assertEquals(true, a);
    }
    @Test
    public void registration2() {
        String name = "Nadja";
        UserEntity a = userEntityRepository.findByLogin(name);
        if (a != null) {
            System.out.println("Пользователь с таким логином уже существует");
        }
    }
















}
