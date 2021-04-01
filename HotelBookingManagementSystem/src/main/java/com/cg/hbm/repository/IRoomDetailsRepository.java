package com.cg.hbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entites.RoomDetails;

@Repository
public interface IRoomDetailsRepository extends JpaRepository<RoomDetails, Integer>{
//	public RoomDetails addRoomDetails(RoomDetails roomDetails);
//	public RoomDetails updateRoomDetails(RoomDetails roomDetails);
//	public RoomDetails removeRoomDetails(RoomDetails roomDetails);
//	public List<RoomDetails> showAllRoomDetails();
//	public RoomDetails showRoomDetails(int roomDetails_id);
}
