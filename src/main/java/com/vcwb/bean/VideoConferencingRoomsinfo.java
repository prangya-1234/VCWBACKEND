package com.vcwb.bean;

import com.vcwb.entity.VideoConferencingRooms;
import lombok.Data;
@Data
public class VideoConferencingRoomsinfo {
	private String id;
	private String roomName;
	private String roomAdminName;
	
	
	public VideoConferencingRooms convertToEntity() {
		
		VideoConferencingRooms room = new VideoConferencingRooms();
			if(id!=null && id!="0")			
			room.setId(Long.valueOf(id));
			room.setRoomName(roomName);
			room.setRoomAdminName(roomAdminName);
			
			return room ;
			
			
	}
}
