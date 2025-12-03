package com.example.midtermm.mapperTest;


import com.example.midtermm.dto.AnimalsDto;
import com.example.midtermm.dto.CompanyDto;
import com.example.midtermm.dto.SponsorDto;
import com.example.midtermm.entity.Animals;
import com.example.midtermm.entity.Company;
import com.example.midtermm.entity.Sponsor;
import com.example.midtermm.mapper.SponsorMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class SponsorMapperTest {
    @Autowired
    private SponsorMapper sponsorMapper;

    @Test
    void convertEntityToDtoTest() {
        Company company = new Company(4L,"Company",55,87L);
        Sponsor sponsorEntity = Sponsor.builder().id(1L).name("sponsor").bank("Kaspi").company(company)
                .animals(List.of(
                Animals.builder().id(2L).name("Kaspi").age(6).type("home animals")
                        .build()
        )).build();

        SponsorDto sponsorDto = sponsorMapper.toDto(sponsorEntity);

        assertNotNull(sponsorDto);
        assertNotNull(sponsorDto.getIdDto());
        assertNotNull(sponsorDto.getNameDto());
        assertNotNull(sponsorDto.getBankDto());
        assertNotNull(sponsorDto.getCompany());
        assertNotNull(sponsorDto.getAnimals());
        assertNotEquals(0,sponsorDto.getAnimals());

        assertEquals(sponsorDto.getIdDto(),sponsorEntity.getId());
        assertEquals(sponsorDto.getNameDto(),sponsorEntity.getName());
        assertEquals(sponsorDto.getBankDto(),sponsorEntity.getBank());
        assertEquals(sponsorDto.getCompany().getId(),sponsorEntity.getCompany().getId());
        assertEquals(sponsorDto.getCompany().getAge(),sponsorEntity.getCompany().getAge());
        assertEquals(sponsorDto.getCompany().getName(),sponsorEntity.getCompany().getName());
        assertEquals(sponsorDto.getCompany().getQuantityOfAnimals(),sponsorEntity.getCompany().getQuantityOfAnimals());

        for(int i = 0; i<sponsorDto.getAnimals().size();i++){
            Animals animals = sponsorEntity.getAnimals().get(i);
            AnimalsDto animalsDto = sponsorDto.getAnimals().get(i);

            assertEquals(animals.getId(),animalsDto.getId());
            assertEquals(animals.getName(),animalsDto.getName());
            assertEquals(animals.getType(),animalsDto.getType());
        }


    }

    @Test
    void convertDtoToEntityTest() {
        SponsorDto sponsorDto = SponsorDto.builder().idDto(1L).nameDto("sponsor").bankDto("Kaspi").company(CompanyDto.builder().id(1L).name("Company").age(55).quantityOfAnimals(87L).build())
                .animals(List.of(
                        AnimalsDto.builder().id(2L).name("Kaspi").age(6).type("home animals")
                                .build()
                )).build();

        Sponsor sponsorEntity = sponsorMapper.toEntity(sponsorDto);

        assertNotNull(sponsorEntity);
        assertNotNull(sponsorEntity.getId());
        assertNotNull(sponsorEntity.getName());
        assertNotNull(sponsorEntity.getBank());
        assertNotNull(sponsorEntity.getCompany());
        assertNotNull(sponsorEntity.getAnimals());
        assertNotEquals(0,sponsorEntity.getAnimals());

        assertEquals(sponsorDto.getIdDto(),sponsorEntity.getId());
        assertEquals(sponsorDto.getNameDto(),sponsorEntity.getName());
        assertEquals(sponsorDto.getBankDto(),sponsorEntity.getBank());
        assertEquals(sponsorDto.getCompany().getId(),sponsorEntity.getCompany().getId());
        assertEquals(sponsorDto.getCompany().getAge(),sponsorEntity.getCompany().getAge());
        assertEquals(sponsorDto.getCompany().getName(),sponsorEntity.getCompany().getName());
        assertEquals(sponsorDto.getCompany().getQuantityOfAnimals(),sponsorEntity.getCompany().getQuantityOfAnimals());

        for(int i = 0; i<sponsorDto.getAnimals().size();i++){
            Animals animals = sponsorEntity.getAnimals().get(i);
            AnimalsDto animalsDto = sponsorDto.getAnimals().get(i);

            assertEquals(animals.getId(),animalsDto.getId());
            assertEquals(animals.getName(),animalsDto.getName());
            assertEquals(animals.getType(),animalsDto.getType());
        }
    }

    @Test
    void convertListToDtoList(){
        Company company = new Company(4L,"Company",55,87L);
        List<Sponsor> sponsorList = new ArrayList<>();
        List<Animals> entityList = new ArrayList<>();
        sponsorList.add(new Sponsor(1L,"Name","Home",company,entityList));
        sponsorList.add(new Sponsor(1L,"1","Home",company,entityList));
        sponsorList.add(new Sponsor(1L,"2","Home",company,entityList));

        List<SponsorDto> dtoList = sponsorMapper.toDtoList(sponsorList);

        assertNotNull(dtoList);
        assertNotEquals(0,dtoList.size());

        for(int i=0;i<dtoList.size();i++){

            Sponsor entity = sponsorList.get(i);
            SponsorDto dto = dtoList.get(i);

            assertNotNull(entity);
            assertNotNull(dto);

            assertEquals(entity.getId(),dto.getIdDto());
            assertEquals(entity.getName(),dto.getNameDto());
            assertEquals(entity.getBank(),dto.getBankDto());
            assertEquals(entity.getCompany().getAge(),dto.getCompany().getAge());
            assertEquals(entity.getCompany().getName(),dto.getCompany().getName());
            assertEquals(entity.getCompany().getQuantityOfAnimals(),dto.getCompany().getQuantityOfAnimals());

            for(int j = 0; j<dto.getAnimals().size();j++){
                Animals animals = entity.getAnimals().get(j);
                AnimalsDto animalsDto = dto.getAnimals().get(j);

                assertEquals(animals.getId(),animalsDto.getId());
                assertEquals(animals.getName(),animalsDto.getName());
                assertEquals(animals.getType(),animalsDto.getType());
            }
}
}}
