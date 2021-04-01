package com.cg.hbm.service;
import java.util.List;
import com.cg.hbm.entites.Hotel;
/**
 * 
 * @author Harshitha
 *
 */
public interface IHotelService {
	/**
	 * 
	 * @param hotel
	 * @return int
	 * @throws HotelNotFoundException
	 */
		public Hotel addHotel(Hotel hotel);
		public Hotel updateHotel(Hotel hotel);
		public Hotel removeHotel(Hotel hotel);
		public List<Hotel> showAllHotels();
		public Hotel showHotel(Hotel id);
}
	
	
	


