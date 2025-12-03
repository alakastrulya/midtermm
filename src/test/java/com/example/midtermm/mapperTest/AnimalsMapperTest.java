package com.example.midtermm.mapperTest;


import com.example.midtermm.dto.AnimalsDto;
import com.example.midtermm.entity.Animals;
import com.example.midtermm.entity.Sponsor;
import com.example.midtermm.mapper.AnimalsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

    @SpringBootTest
    public class AnimalsMapperTest {

        @Autowired
        private AnimalsMapper itemMapper;

        @Test
        void convertEntityToDtoTest() {
            Animals entityAnimals = Animals.builder()
                    .id(1L)
                    .name("Cat")
                    .type("meow")
                    .age(2)
                    .build();

            AnimalsDto dtoItem = itemMapper.toDto(entityAnimals);


            assertNotNull(dtoItem);
            assertNotNull(dtoItem.getId());
            assertNotNull(dtoItem.getName());
            assertNotNull(dtoItem.getType());
            assertNotNull(dtoItem.getAge());
            assertNotNull(dtoItem);


            assertEquals(entityAnimals.getId(),dtoItem.getId());
            assertEquals(entityAnimals.getName(),dtoItem.getName());
            assertEquals(entityAnimals.getType(),dtoItem.getType());
            assertEquals(entityAnimals.getAge(),dtoItem.getAge());


        }

    @Test
    void convertDtoToEntityTest() {
        AnimalsDto dtoAnimals = AnimalsDto.builder()
                .id(1L)
                .name("Cat")
                .type("meow")
                .age(2)
                .build();

        Animals entityItem = itemMapper.toEntity(dtoAnimals);

        assertNotNull(entityItem);
        assertNotNull(entityItem.getId());
        assertNotNull(entityItem.getName());
        assertNotNull(entityItem.getType());
        assertNotNull(entityItem.getAge());
        assertNotNull(entityItem);

        assertEquals(entityItem.getId(),dtoAnimals.getId());
        assertEquals(entityItem.getName(),dtoAnimals.getName());
        assertEquals(entityItem.getType(),dtoAnimals.getType());
        assertEquals(entityItem.getAge(),dtoAnimals.getAge());

    }

    @Test
    void convertListToDtoList(){
        List<Sponsor> sponsorList = new ArrayList<>();
        List<Animals> entityList = new ArrayList<>();
        entityList.add(new Animals(1L,"Name","Home",5));
        entityList.add(new Animals(1L,"1","Home",7));
        entityList.add(new Animals(1L,"2","Home",15));

        List<AnimalsDto> dtoList = itemMapper.toDtoList(entityList);

        assertNotNull(dtoList);
        assertNotEquals(0,dtoList.size());

        assertEquals(entityList.size(),dtoList.size());
        for(int i=0;i<dtoList.size();i++){

            Animals entity = entityList.get(i);
            AnimalsDto dto = dtoList.get(i);

            assertNotNull(entity);
            assertNotNull(dto);

            assertEquals(entity.getId(),dto.getId());
            assertEquals(entity.getName(),dto.getName());
            assertEquals(entity.getType(),dto.getType());
            assertEquals(entity.getAge(),dto.getAge());
        }
    }
    }
