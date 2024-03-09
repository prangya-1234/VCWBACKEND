package com.vcwb.repository;

   
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vcwb.entity.UserAccount;
import com.vcwb.entity.VideoConferencingRooms;

	
       @EnableJpaRepositories
		public interface VideoConferencingRoomsRepo extends JpaRepository<VideoConferencingRooms, Long>{
        	UserAccount findByRoomName(String roomNames);
		 
		}

