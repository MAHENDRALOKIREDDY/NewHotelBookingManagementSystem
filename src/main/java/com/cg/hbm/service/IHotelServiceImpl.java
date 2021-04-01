package com.cg.hbm.service;

import java.util.List;

import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.repository.IHotelRepository;
import com.cg.hbm.entites.Hotel;
import com.cg.hbm.exceptions.HotelNotFoundException;
/**
 * 
 * @author Harshitha
 *
 */
@Service
@Transactional
public class IHotelServiceImpl implements IHotelService {
	@Autowired
	IHotelRepository hDao;

	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel removeHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> showAllHotels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel showHotel(Hotel id) {
		// TODO Auto-generated method stub
		return null;
	}
		}
	

	
