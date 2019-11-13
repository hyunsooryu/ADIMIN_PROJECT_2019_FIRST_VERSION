package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
//import jdk.tools.jlink.internal.plugins.OrderResourcesPlugin;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends StudyApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
   //@Transactional
    public void create(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());
        //어떤 상품?
      //  orderDetail.setItemId(3L);
        //어떤 사람?
     //   orderDetail.setUserId(6L);
        System.out.println(orderDetail);
        OrderDetail tmp = orderDetailRepository.save(orderDetail);
        Assertions.assertNotNull(tmp);
    }

}
