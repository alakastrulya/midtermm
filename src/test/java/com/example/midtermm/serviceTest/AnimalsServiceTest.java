package com.example.midtermm.serviceTest;

import com.example.midtermm.dto.AnimalsDto;
import com.example.midtermm.dto.CompanyDto;
import com.example.midtermm.dto.SponsorDto;
import com.example.midtermm.service.AnimalsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
public class AnimalsServiceTest {

    @Autowired
    private AnimalsService animalsService;

    @Test
    void getAll(){
        List<AnimalsDto> list = animalsService.getAll();

        assertNotNull(list);
        assertNotEquals(0,list.size());

        for(int i=0;i< list.size();i++){
            AnimalsDto animalsDto = list.get(i);
            assertNotNull(animalsDto);
            assertNotNull(animalsDto.getName());
            assertNotNull(animalsDto.getType());
            assertNotNull(animalsDto.getAge());

        }
    }

    @Test
    void getById(){
        Random random = new Random();
        int randomIndex = random.nextInt(animalsService.getAll().size());

        Long someIndex = animalsService.getAll().get(randomIndex).getId();

        AnimalsDto animalsDto = animalsService.getById(someIndex);

        assertNotNull(animalsDto);

        assertNotNull(animalsDto.getId());
        assertNotNull(animalsDto.getName());
        assertNotNull(animalsDto.getAge());
        assertNotNull(animalsDto.getType());

        AnimalsDto checkAnimals = animalsService.getById(-1L);

        assertNull(checkAnimals);

    }

    @Test
    void add(){
        AnimalsDto animalsDto = AnimalsDto.builder()
                .name("Makeba")
                .type("home emes")
                .age(6)
                .build();

        AnimalsDto createdItem = animalsService.addAnimals(animalsDto);

        assertNotNull(createdItem);
        assertNotNull(createdItem.getId());
        assertNotNull(createdItem.getName());
        assertNotNull(createdItem.getType());
        assertNotNull(createdItem.getAge());
        assertEquals(animalsDto.getName(),createdItem.getName() );
        assertEquals(animalsDto.getType(),createdItem.getType() );
        assertEquals(animalsDto.getAge(),createdItem.getAge());


        AnimalsDto getAnimals = animalsService.getById(createdItem.getId());

        assertNotNull(getAnimals);
        assertNotNull(getAnimals.getId());
        assertNotNull(getAnimals.getName());
        assertNotNull(getAnimals.getAge());
        assertNotNull(getAnimals.getType());

        assertEquals(getAnimals.getName(),createdItem.getName() );
        assertEquals(getAnimals.getType(),createdItem.getType() );
        assertEquals(getAnimals.getAge(),createdItem.getAge());

    }

    @Test
    void update(){

        Random random = new Random();
        int randomIndex = random.nextInt(animalsService.getAll().size());
        Long someindex = animalsService.getAll().get(randomIndex).getId();

        AnimalsDto animalsDto = new AnimalsDto();
        animalsDto.setId(someindex);
        animalsDto.setName("tapishke");
        animalsDto.setType("new type");
        animalsDto.setAge(55);

        List<SponsorDto> list = new ArrayList<>();
        SponsorDto sponsorDto = new SponsorDto();
        sponsorDto.setNameDto("nyama nyama");
        sponsorDto.setBankDto("piupiu");
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName("microsoft");
        companyDto.setAge(4888);
        companyDto.setQuantityOfAnimals(666L);
        sponsorDto.setCompany(companyDto);

        AnimalsDto updated = animalsService.updateAnimals(animalsDto.getId(),animalsDto);
        assertNotNull(updated);
        assertNotNull(updated.getId());
        assertNotNull(updated.getName());
        assertNotNull(updated.getType());
        assertNotNull(updated.getAge());


        assertEquals(animalsDto.getName(),updated.getName() );
        assertEquals(animalsDto.getType(),updated.getType() );
        assertEquals(animalsDto.getAge(),updated.getAge());


        AnimalsDto checkAnimals = animalsService.getById(someindex);

        assertNotNull(checkAnimals);
        assertNotNull(checkAnimals.getId());
        assertNotNull(checkAnimals.getName());
        assertNotNull(checkAnimals.getType());
        assertNotNull(checkAnimals.getAge());

        assertEquals(animalsDto.getName(),checkAnimals.getName() );
        assertEquals(animalsDto.getType(),checkAnimals.getType() );
        assertEquals(animalsDto.getAge(),checkAnimals.getAge());

        }

    @Test
    void delete(){
        Random random = new Random();
        int randomIndex = random.nextInt(animalsService.getAll().size());

        Long someindex = animalsService.getAll().get(randomIndex).getId();

        assertTrue(animalsService.deleteAnimals(someindex));

        AnimalsDto checkAnimals = animalsService.getById(someindex);
        assertNull(checkAnimals);

    }

}
