package com.ait.assignment.repository;

import com.ait.assignment.entity.MotorbikeShop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotorbikeShopRepository extends CrudRepository<MotorbikeShop, Long> {
    List<MotorbikeShop> findByName(String name);
}
