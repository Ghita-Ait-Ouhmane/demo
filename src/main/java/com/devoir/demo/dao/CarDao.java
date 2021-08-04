package com.devoir.demo.dao;

import com.devoir.demo.bo.CarBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends JpaRepository<CarBO,Long> {
}
