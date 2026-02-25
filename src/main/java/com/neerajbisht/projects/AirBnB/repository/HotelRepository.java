package com.neerajbisht.projects.AirBnB.repository;

import com.neerajbisht.projects.AirBnB.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
