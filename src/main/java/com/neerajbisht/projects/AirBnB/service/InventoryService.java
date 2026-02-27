package com.neerajbisht.projects.AirBnB.service;

import com.neerajbisht.projects.AirBnB.entity.Room;

public interface InventoryService {

    void initializeRoomForYear(Room room);

    void deleteFutureInventories(Room room);

}
