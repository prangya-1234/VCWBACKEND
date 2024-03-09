package com.vcwb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcwb.bean.VideoConferencingRoomsinfo;
import com.vcwb.entity.VideoConferencingRooms;
import com.vcwb.repository.VideoConferencingRoomsRepo;

@Service
public class VideoConferencingRoomsService {
	
	@Autowired
	VideoConferencingRoomsRepo VideoConferencingRoomsRepo;
	
	public VideoConferencingRooms register( VideoConferencingRoomsinfo VideoConferencingRoomsinfo ) {
		return VideoConferencingRoomsRepo.save(VideoConferencingRoomsinfo.convertToEntity());
	}
	
	public VideoConferencingRooms update(VideoConferencingRooms VideoConferencingRooms) {
		return VideoConferencingRoomsRepo.save(VideoConferencingRooms);
	}
	
	public List<VideoConferencingRooms> getAll() {
		return VideoConferencingRoomsRepo.findAll();
	}
	
	public Optional<VideoConferencingRooms> getById(Long id) {
		return VideoConferencingRoomsRepo.findById(id);
	}
	
	public void delete(Long id) {
		VideoConferencingRoomsRepo .deleteById(id); 
	}
}
