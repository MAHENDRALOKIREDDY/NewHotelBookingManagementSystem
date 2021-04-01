package com.cg.hbm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cg.hbm.entites.Hotel;
import com.cg.hbm.entites.RoomDetails;

@SpringBootTest
class HbmsApplicationTests extends AbstractTest {

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void getRoomDetails() throws Exception{
	String uri="/room/all";
	MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
    int status=mvcResult.getResponse().getStatus();
    assertEquals(200, status);
    String content=mvcResult.getResponse().getContentAsString();
    RoomDetails room[]=super.mapFromJson(content, RoomDetails[].class);
    assertEquals(18,room[5].getRoom_id());
	}
	
	@Test
	public void getRoomById() throws Exception{
	String uri="/room/12";
	MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
    int status=mvcResult.getResponse().getStatus();
    assertEquals(200, status);
    String content=mvcResult.getResponse().getContentAsString();
    RoomDetails room=super.mapFromJson(content, RoomDetails.class);
    assertEquals(12,room.getRoom_id());
	}
	
	@Test
	public void addRoomDetails() throws Exception{
		Hotel hotel=new Hotel("city", "hotel_name", "address", "description",
				200,"email", "phone1", "phone2", "website");
		RoomDetails room=new RoomDetails();
	room.setRate_per_day(1130);
	room.setHotel(hotel);
	room.setRoom_no("12345");
	room.setRoom_type("udx");
	room.setAvailable(true);
	String uri="/room/add";
	String inputJson=super.mapToJson(room);
	MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    int status=mvcResult.getResponse().getStatus();
    assertEquals(200, status);
    String content=mvcResult.getResponse().getContentAsString();
    RoomDetails newRoom=super.mapFromJson(content, RoomDetails.class);
    assertEquals("12345",newRoom.getRoom_no());
	}
	
	@Test
	public void UpdateRoom() throws Exception{
	String uri="/room/18";
	String putUri="/room/update";
	MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
    int status=mvcResult.getResponse().getStatus();
    assertEquals(200, status);
    String content=mvcResult.getResponse().getContentAsString();
    RoomDetails room=super.mapFromJson(content, RoomDetails.class);
    room.setRoom_no("306");
    room.setRoom_type("duplex");
    String inputJson = super.mapToJson(room);
	MvcResult mvcResult1=mvc.perform(MockMvcRequestBuilders.put(putUri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    int status1 = mvcResult1.getResponse().getStatus();
    assertEquals(200,status1);
    String content1 = mvcResult1.getResponse().getContentAsString();
    RoomDetails roomup=super.mapFromJson(content1, RoomDetails.class);
    assertEquals("duplex",roomup.getRoom_type());
	assertEquals("306",roomup.getRoom_no());
	}
	
	@Test
	public void deleteRoom() throws Exception{
		String uri="/room/37";
		MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
	    int status=mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	    String content=mvcResult.getResponse().getContentAsString();
	    RoomDetails room=super.mapFromJson(content, RoomDetails.class);
	    String delUri="/room/remove";
	    String inputJson = super.mapToJson(room);
	    this.mvc.perform(MockMvcRequestBuilders.delete(delUri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
