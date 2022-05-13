package com.java.Travel.service.impl;


import com.java.Travel.controller.dto.CompanyDTO;
import com.java.Travel.controller.dto.IncidentDTO;
import com.java.Travel.model.*;
import com.java.Travel.repository.*;
import com.java.Travel.service.ServiceImpl.CompanyServiceImpl;

import com.java.Travel.service.ServiceImpl.IncidentServiceImpl;
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

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceImplTest {


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

        when(companyRepository.findAllByCompanyName("jhf")).thenReturn(list);

        List<CompanyDTO> empList = companyService.findAll();

        assertEquals(2, empList.size());
        verify(companyRepository, times(1)).findAllByCompanyName("djf");
    }

    @Test
    public void findAllPageable() {
        pageable = PageRequest.of(0, 4, Sort.by("name").ascending());
        Page<CompanyEntity> companyEntities = new PageImpl<>(Arrays.asList(
                new CompanyEntity(1L, "Fake1"),
                new CompanyEntity(2L, "Fake2"),
                new CompanyEntity(3L, "Fake3"),
                new CompanyEntity(5L, "Fake7")));

        when(companyRepository.findAll(pageable)).thenReturn(companyEntities);
        Page<CompanyEntity> expectedCompanyEntitiesList = companyService.findAll(pageable);

        assertEquals(expectedCompanyEntitiesList.get().count(), 4);
        verify(companyRepository, times(1)).findAll(pageable);
    }

    @Test
    public void findAllIsEmpty() {
        pageable = PageRequest.of(0, 4, Sort.by("name").ascending());
        Page<CompanyEntity> companyEntities = new PageImpl<>(new ArrayList<>());

        when(companyRepository.findAll(pageable)).thenReturn(companyEntities);
        Page<CompanyEntity> expectedCompanyEntitiesList = companyService.findAll(pageable);

        assertThat(expectedCompanyEntitiesList).isEmpty();
        verify(companyRepository, times(1)).findAll(pageable);
    }

    @Test
    public void findAllIsNull() {
        pageable = PageRequest.of(0, 4, Sort.by("name").ascending());

        when(companyRepository.findAll(pageable)).thenReturn(null);
        Page<CompanyEntity> expectedCompanyEntitiesList = companyService.findAll(pageable);

        assertThat(expectedCompanyEntitiesList).isNull();
        verify(companyRepository, times(1)).findAll(pageable);
    }

    @Test
    public void findOneById() {
        Long id = 1L;
        Optional<CompanyEntity> companyEntity = Optional.of(new CompanyEntity(id, "Fake"));
        when(companyRepository.findById(id)).thenReturn(companyEntity);
        CompanyDTO actualCompany = companyService.findOne(id);
        assertEquals(id, actualCompany.getId());
    }

    @Test
    public void findOneByIdNotFound() {
        Long id = 2L;
        when(companyRepository.findById(id)).thenReturn(Optional.empty());
        CompanyDTO actualCompany = companyService.findOne(id);
        assertNull(actualCompany);
    }

    @Test
    public void getCompanyIdByName() {
        Long id = 1L;
        CompanyEntity companyEntity = new CompanyEntity(id, "Fake");
        when(companyRepository.getCompanyIdByName(companyEntity.getCompanyName())).thenReturn(id);
        Long actualId = companyService.getCompanyIdByName(companyEntity.getCompanyName());
        assertEquals(id, actualId);
    }

    @Test
    public void getCompanyIdByNameNotFound() {
        when(companyRepository.getCompanyIdByName("F")).thenReturn(null);
        Long actualId = companyService.getCompanyIdByName("F");
        assertNull(actualId);
    }
    @Test
    public void getIncidentFalse() {
        String name = "False";
        List<IncidentsEntity> list = new ArrayList<>();
        IncidentsEntity incidentEntity1 = new IncidentsEntity();
        IncidentsEntity incidentEntity2 = new IncidentsEntity();
        when(incidentEntityRepository.getIncidentsFalse(name)).thenReturn(list);
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
        when(incidentEntityRepository.getIncidentsTrue(name)).thenReturn(list);
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
        when(companyRepository.findAll()).thenReturn(list);
        if(list.isEmpty()){
            System.out.println("База данный о компаниях пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void addFixDetachment2() {
        List<DetachmentEntity> list = new ArrayList<>();
        when(detachmentRepository.findAll()).thenReturn(list);
        if(list.isEmpty()){
            System.out.println("База данный о командах пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void addDetachment() {
        List<EmployeeEntity> list = new ArrayList<>();
        when(employeeRepository.findAll()).thenReturn(list);
        if(list.isEmpty()){
            System.out.println("База данный о сотрудниках пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void addDetachment2() {
        List<DetachmentEntity> list = new ArrayList<>();
        when(detachmentRepository.findAll()).thenReturn(list);
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
        when(incidentEntityRepository.findAll()).thenReturn(list);
        if(list.isEmpty()){
            System.out.println("База данный о сотрудниках пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void addReport2(Long id) {
        IncidentsEntity obj = new IncidentsEntity();
        when(incidentEntityRepository.getIncidentsReactionByID(id)).thenReturn(String.valueOf(obj));
        if (obj.getReaction().isEmpty()){
            System.out.println("Данные о реакции на данный инцидент ещё не поступили ");
        } else {
            System.out.println("Всё отлично. Получите отчёт");
        }
    }
    @Test
    public void TestDiffIncident(Integer number) {
        if(number == 3){
            System.out.println("Вы идеальный знаток");
        } else {
            System.out.println("Вы набрали меньше, чем нужно, попробуйте снова");
        }
    }
    @Test
    public void TestDiffIncident2() {
        TestsEntity tests = new TestsEntity();
        if (testsRepository.add(tests)) {

        }
        else
        {
            System.out.println("Произошла ошибка при сохранении данных в бд, попробуйте снова");
        }
    }
    @Test
    public void TestMoment(Integer number) {
        if(number == 3){
            System.out.println("Вы идеальный знаток");
        } else {
            System.out.println("Вы набрали меньше, чем нужно, попробуйте снова");
        }
    }
    @Test
    public void TestMoment2(TestsEntity tests) {
        if (testsRepository.add(tests)) {

        }
        else
        {
            System.out.println("Произошла ошибка при сохранении данных в бд, попробуйте снова");
        }
    }
    @Test
    public void addProblem() {
        List<EmployeeEntity> list = new ArrayList<>();
        when(employeeRepository.findAll()).thenReturn(list);
        if(list.isEmpty()){
            System.out.println("База данный о сотрудниках пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void addProblem2() {
        DetachmentEntity obj = new DetachmentEntity();
        when(detachmentRepository.findDetachmentEntityByDetachmentName()).thenReturn(obj);
        if(obj.equals(NULL)){
            System.out.println("Информации о такой команде помощи нет в бд, проверьте правильность введённого названия");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void findIncidents() {
        List<IncidentsEntity> list = new ArrayList<>();
        when(incidentEntityRepository.findAll()).thenReturn(list);
        if(list.isEmpty()){
            System.out.println("База данный о инцидентах пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void findIncidentsByIncidentName(String name) {
        IncidentsEntity obj = new IncidentsEntity();
        when(incidentEntityRepository.findIncidentEntityByIncidentName(name)).thenReturn(obj);
        if(obj.equals(NULL)){
            System.out.println("Информации о такой команде помощи нет в бд, проверьте правильность введённого названия");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void tryFixDetachment() {
        List<DetachmentEntity> list = new ArrayList<>();
        when(detachmentRepository.findAll()).thenReturn(list);
        if(list.isEmpty()){
            System.out.println("База данный о командах пуста. Данных для выбора нет, введите, пожалуйста, данные");
        } else {
            System.out.println("Данных есть, выполнение действия возможно");
        }
    }
    @Test
    public void tryFixDetachment2(FixedDetachmentsEntity obj) {
        if (fixedDetachmentsRepository.safe(obj)) {
            System.out.println("Запись в бд произошла успешно");
        }
        else
        {
            System.out.println("Произошла ошибка при сохранении данных в бд, попробуйте снова");
        }
    }
    @Test
    public void addIncident(IncidentsEntity obj) {
        if (incidentEntityRepository.add(obj)) {
            System.out.println("Запись в бд произошла успешно");
        }
        else
        {
            System.out.println("Произошла ошибка при сохранении данных в бд, попробуйте снова");
        }
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
        when(appRatingRepository.findAll()).thenReturn(list);
        if(list.isEmpty()){
            System.out.println("Данное приложение ещё никто не оценивал, Вы будете первым");
        } else {
            System.out.println("Вы можете посмотреть, как оценили данное приложение другие пользователи");
        }
    }
    @Test
    public void addRating2() {
        AppRating obj = new  AppRating();
        if (appRatingRepository.add(obj)) {
            System.out.println("Запись в бд произошла успешно");
        }
        else
        {
            System.out.println("Произошла ошибка при сохранении данных в бд, попробуйте снова");
        }
    }
    @Test
    public void login() {
    }
    @Test
    public void login2() {

    }
    @Test
    public void registration() {
    }
    @Test
    public void registration2() {
    }
    @Test
    public void enterContactData() {
    }
    @Test
    public void enterContactData2() {
    }
    @Test
    public void enterLogin() {
    }
    @Test
    public void enterLogin2() {
    }
    @Test
    public void enterPassword() {
    }
    @Test
    public void enterPassword2() {
    }















}
