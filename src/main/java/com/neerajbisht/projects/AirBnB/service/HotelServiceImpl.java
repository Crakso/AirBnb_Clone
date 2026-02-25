package com.neerajbisht.projects.AirBnB.service;

import com.neerajbisht.projects.AirBnB.dto.HotelDTO;
import com.neerajbisht.projects.AirBnB.entity.Hotel;
import com.neerajbisht.projects.AirBnB.exception.ResourceNotFoundException;
import com.neerajbisht.projects.AirBnB.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDTO createNewHotel(HotelDTO hotelDTO) {
        log.info("Creating a new hotel with name: {}", hotelDTO.getName());
        Hotel hotel= modelMapper.map(hotelDTO,Hotel.class);
        hotel.setActive(false);
        hotel = hotelRepository.save(hotel);
        log.info("Created a new hotel with ID: {}", hotelDTO.getId());
        return modelMapper.map(hotel, HotelDTO.class);
    }

    @Override
    public HotelDTO getHotelById(Long id) {
        log.info("Getting the hotel with Id: {}", id);
        Hotel hotel =hotelRepository
                .findById(id)
                .orElseThrow(()->
                new ResourceNotFoundException("Hotel not found with Id: "+ id));
        return modelMapper.map(hotel, HotelDTO.class);
    }

    @Override
    public HotelDTO updateHotelById(Long id, HotelDTO hotelDTO) {
    log.info("Uddating the hotel with Id: {}",id);
    Hotel hotel = hotelRepository
            .findById(id)
            .orElseThrow(()->
                    new ResourceNotFoundException("Hotel not found with Id: "+id));
    modelMapper.map(hotelDTO,hotel);
    hotel.setId(id);
    hotel = hotelRepository.save(hotel);
    return modelMapper.map(hotel, HotelDTO.class);
    }

    @Override
    public Boolean deleteHotelById(Long id) {
        if(!hotelRepository.existsById(id)) throw new ResourceNotFoundException("Hotel not found with id: "+id);
        hotelRepository.deleteById(id);
        return true;
    }
}
