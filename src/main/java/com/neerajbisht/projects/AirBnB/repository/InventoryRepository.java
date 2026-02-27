package com.neerajbisht.projects.AirBnB.repository;

import com.neerajbisht.projects.AirBnB.entity.Inventory;
import com.neerajbisht.projects.AirBnB.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    void deleteByDateAfterAndRoom(LocalDate date, Room room);


}
