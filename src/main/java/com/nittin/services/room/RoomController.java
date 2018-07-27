package com.nittin.services.room;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/rooms")
@Api(value="rooms",description="data service operations",tags=("rooms"))
public class RoomController {
	@Autowired
	private RoomRepository roomRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Get All Rooms", notes="get all rooms from system",nickname="getRooms")
	public List<Room> findAll(@RequestParam(name="roomNumber",required=false)String roomNumber){
		if(!"".equals(roomNumber) && null!=roomNumber){
			return Collections.singletonList(this.roomRepository.findByRoomNumber(roomNumber));
		}
		return (List<Room>)this.roomRepository.findAll();
	}

}
