package com.vcwb.controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.vcwb.bean.VideoConferencingRoomsinfo;
import com.vcwb.entity.VideoConferencingRooms;
import com.vcwb.exception.UserNotFoundException;
import com.vcwb.repository.VideoConferencingRoomsRepo;
import com.vcwb.service.VideoConferencingRoomsService;

@RestController
@RequestMapping("/api/v1/videoConferencingRooms")
public class VideoConferencingRoomsController {

    private final VideoConferencingRoomsService videoConferecingRoomsService;
    private final VideoConferencingRoomsRepo videoConferencingRoomsRepo;

    public VideoConferencingRoomsController(VideoConferencingRoomsService videoConferecingRoomsService, VideoConferencingRoomsRepo videoConferencingRoomsRepo) {
        this.videoConferecingRoomsService = videoConferecingRoomsService;
        this.videoConferencingRoomsRepo = videoConferencingRoomsRepo;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody VideoConferencingRoomsinfo videoConferencingRoomsinfo) {
        try {
            VideoConferencingRooms room = videoConferecingRoomsService.register(videoConferencingRoomsinfo);
            return ResponseEntity.ok(room);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Error: Room with the same name already exists");
        }
    }

	@GetMapping("/getAll")
	
	public List<VideoConferencingRooms> getAll(){
		
		return videoConferencingRoomsRepo.findAll();
	}
	 
    @GetMapping("/getAll/{id}")
    VideoConferencingRooms getUserById(@PathVariable Long id) {
        return videoConferencingRoomsRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!videoConferencingRoomsRepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        videoConferencingRoomsRepo .deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }

}


