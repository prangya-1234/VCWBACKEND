package com.vcwb.bean;

import com.vcwb.entity.VideoConferencingRooms;
import lombok.Data;
@Data
public class VideoConferencingRoomsinfo {
	private String id;
	private String roomName;
	private String isOccupied;
	private String maxOccupancy;
	
	
	public VideoConferencingRooms convertToEntity() {
		
		VideoConferencingRooms room = new VideoConferencingRooms();
			if(id!=null && id!="0")			
			room.setId(Long.valueOf(id));
			room.setRoomName(roomName);
			room.setIsOccupied(isOccupied);
			room.setMaxOccupancy(maxOccupancy);
			
			return room ;
			
			
	}
}
