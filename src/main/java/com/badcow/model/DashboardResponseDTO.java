package com.badcow.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardResponseDTO {


	  private long totalUsers;
	    private long totalRooms;
	    private long totalBookings;
	    private long totalFavorites;

	}
