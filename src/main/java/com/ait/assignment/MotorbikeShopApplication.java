package com.ait.assignment;

import com.ait.assignment.entity.MotorbikeShop;
import com.ait.assignment.repository.MotorbikeShopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MotorbikeShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(MotorbikeShopApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(MotorbikeShopRepository repository) {
        return (args) -> {
            repository.save(new MotorbikeShop("Kawasaki ER6N", "For Sale", 2020, 20000));
            repository.save(new MotorbikeShop("Suzuki GXSR", "For Sale", 2003, 1000));
            repository.save(new MotorbikeShop("Suzuki Intruder", "For Sale", 2010, 14000));
        };
    }
}