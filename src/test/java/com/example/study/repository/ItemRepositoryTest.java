package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {

    //DI 의존성 주입
    @Autowired
    private ItemRepository itemRepository;

    @Test
   // @Transactional
    public void create(){
        Item item = new Item();
        item.setContent("3~4개월 지나면 상할 수 있음");
        item.setName("교촌치킨");
        item.setPrice(15000);
        Item addItem = itemRepository.save(item);
        Assertions.assertNotNull(addItem);
        System.out.println("*******************************************");
        System.out.println(addItem);
        System.out.println("*******************************************");
    }
    @Test
    public void read(){
        Optional<Item> item = itemRepository.findById(1L);
        Assertions.assertFalse(item.isPresent());
    }

}
