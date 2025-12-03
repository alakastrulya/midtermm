package com.example.midtermm.mapperTest;

import com.example.midtermm.dto.CompanyDto;
import com.example.midtermm.entity.Company;
import com.example.midtermm.mapper.CompanyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompanyMapperTest {
    @Autowired
    private CompanyMapper companyMapper;

    @Test
    void convertEntityToDtoTest() {
        Company entityCompany = Company.builder()
                .id(1L)
                .name("Company")
                .age(2)
                .quantityOfAnimals(55L)
                .build();

        CompanyDto dtoItem = companyMapper.toDto(entityCompany);


        assertNotNull(dtoItem);
        assertNotNull(dtoItem.getId());
        assertNotNull(dtoItem.getName());
        assertNotNull(dtoItem.getQuantityOfAnimals());
        assertNotNull(dtoItem.getAge());

        assertEquals(entityCompany.getId(), dtoItem.getId());
        assertEquals(entityCompany.getName(), dtoItem.getName());
        assertEquals(entityCompany.getQuantityOfAnimals(), dtoItem.getQuantityOfAnimals());
        assertEquals(entityCompany.getAge(), dtoItem.getAge());
    }

    @Test
    void convertDtoToEntityTest() {
        CompanyDto dtoItem = CompanyDto.builder()
                .id(1L)
                .name("Company")
                .age(2)
                .quantityOfAnimals(55L)
                .build();

        Company entityCompany = companyMapper.toEntity(dtoItem);


        assertNotNull(entityCompany);
        assertNotNull(entityCompany.getId());
        assertNotNull(entityCompany.getName());
        assertNotNull(entityCompany.getQuantityOfAnimals());
        assertNotNull(entityCompany.getAge());

        assertEquals(entityCompany.getId(), dtoItem.getId());
        assertEquals(entityCompany.getName(), dtoItem.getName());
        assertEquals(entityCompany.getQuantityOfAnimals(), dtoItem.getQuantityOfAnimals());
        assertEquals(entityCompany.getAge(), dtoItem.getAge());
    }

    @Test
    void convertListToDtoList(){
        List<Company> entityList = new ArrayList<>();
        entityList.add(new Company(1L,"Name",5,55L));
        entityList.add(new Company(1L,"1",7,66L));
        entityList.add(new Company(1L,"2",7,800L));

        List<CompanyDto> dtoList = companyMapper.toDtoList(entityList);

        assertNotNull(dtoList);
        assertNotEquals(0,dtoList.size());

        assertEquals(entityList.size(),dtoList.size());

        for(int i=0;i<dtoList.size();i++){

            Company entity = entityList.get(i);
            CompanyDto dto = dtoList.get(i);

            assertNotNull(entity);
            assertNotNull(dto);

            assertEquals(entity.getId(),dto.getId());
            assertEquals(entity.getName(),dto.getName());
            assertEquals(entity.getQuantityOfAnimals(),dto.getQuantityOfAnimals());
            assertEquals(entity.getAge(),dto.getAge());
        }
    }

}
