package com.vcwb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcwb.bean.VideoConferencingRoomsinfo;
import com.vcwb.entity.VideoConferencingRooms;
import com.vcwb.exception.UserNotFoundException;
import com.vcwb.repository.VideoConferencingRoomsRepo;
import com.vcwb.service.VideoConferencingRoomsService;

@RestController
@RequestMapping("/api/v1/user")
public class videoConferencingRoomsController {
	@Autowired
	VideoConferencingRoomsService videoConferecingRoomsService ;
	@Autowired
	VideoConferencingRoomsRepo videoConferencingRoomsRepo;      
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	VideoConferencingRooms register(@RequestBody VideoConferencingRoomsinfo videoConferencingRoomsinfo) {
		return videoConferecingRoomsService .register(videoConferencingRoomsinfo);		
	}
	 @PutMapping("/edit/{id}")
	 VideoConferencingRooms  update(@RequestBody VideoConferencingRooms newUser, @PathVariable Long id) {
	        return videoConferencingRoomsRepo.findById(id)
	                .map(user -> {
	                    user.setRoomName(newUser.getRoomName());
	                    user.setIsOccupied(newUser.getIsOccupied());
	                    user.setMaxOccupancy(newUser.getMaxOccupancy());
	                    return videoConferencingRoomsRepo.save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
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


