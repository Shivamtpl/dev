package com.badcow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badcow.model.DashboardResponseDTO;
import com.badcow.repository.BookingRepository;
import com.badcow.repository.FavoriteRepository;
import com.badcow.repository.RoomRepository;
import com.badcow.repository.UserRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    public DashboardResponseDTO getDashboard() {

        return new DashboardResponseDTO(

                userRepository.count(),

                roomRepository.count(),

                bookingRepository.count(),

                favoriteRepository.count()

        );

    }

}