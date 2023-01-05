package com.cropfield.project.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.cropfield.project.Model.Crop;
import com.cropfield.project.Model.CropDto;
import com.cropfield.project.exceptions.CropNotFoundException;
import com.cropfield.project.exceptions.UserNotFoundException;
import com.cropfield.project.repositories.CropRepository;

@Service
public class CropServiceImpl implements CropService {
	
	Logger logger =LoggerFactory.getLogger(CropServiceImpl.class);
	@Autowired
	public CropRepository crp;
	
	@Autowired
	MongoOperations mongoOperations;
	
	@Autowired
	SequenceGeneratorService generatorService;

	@Override
	public Crop addCrop(Crop crop) {
		
		logger.info("you are inside of addCrop service method");
		crop.setCropId(generatorService.generateSequence(Crop.sequence_Name));
		crp.save(crop);
		logger.info("crop added successfully");
		return crop;
	}

	@Override
	public String UpdateCrop(CropDto cropdto) throws CropNotFoundException {
		logger.info("cursor pointor is inside of UpdateCrop service method");
		Crop c = crp.findByCropId(cropdto.getCropId());
		if(c!=null) {
		c.setCropName(cropdto.getCropName());
		c.setCropType(cropdto.getCropType());
		c.setLocationName(cropdto.getLocationName());
		c.setQuanity(cropdto.getQuanity());
		c.setPhoneNumber(cropdto.getPhoneNumber());
		c.setDistrict(cropdto.getDistrict());
		c.setState(cropdto.getState());
		c.setPincode(cropdto.getPincode());
		crp.save(c);
		logger.info("Crop updated successfully");
		return "updated successfully";
		}
		else 
			logger.error("Not find cropid....");
			throw new CropNotFoundException("crop is not found ,create a crop ");
	}

	@Override
	public List<Crop> getAllCropDetails() throws NullPointerException {
		logger.info("cursor pointor is inside of getAllCropDetails service method");
		List<Crop> list = new ArrayList<Crop>();
		list.addAll(crp.findAll());
		if (list.isEmpty()) {
			logger.error("list is empty error....");
			throw new NullPointerException("list is empty");

		} else {
			logger.info("cropDetails list returns successfully ");
			return list;
		}
	}

	@Override
	public Crop getCropbyId(int id) throws CropNotFoundException {
		logger.info("cursor pointor is inside of getCropbyId service method");
		Crop c = crp.findByCropId(id);
		if (c != null) {
			logger.info("crop details returns...");
			return c;
		} else {
			logger.error("crop not found....");
			throw new CropNotFoundException("No such crop is found in the database");
		}

	}

	@Override
	public String deleteCrop(int id) throws CropNotFoundException {
		logger.info("cursor is inside of deleteCrop service method");
		Crop c = crp.findByCropId(id);
		crp.deleteById(c.getCropId());
		
		logger.info("crop deleted...");
		return "deleted sucessfully";

	}

	@Override
	public List<Crop> getCropbyType(String croptype) throws CropNotFoundException {
		logger.info("cursor pointor is inside of getCropbyType service method");
		List<Crop> c = crp.findByCropType(croptype);
		if (c.isEmpty()) {
			logger.error("list is empty....");
			throw new NullPointerException("list is empty");

		} else {
			logger.info("list of crop type deatils is returned...");
			return c;
		}
	}

	@Override
	public List<Crop> getbyCropName(String name) throws CropNotFoundException {
		logger.info("cursor pointor is inside of getbyCropName service method");
		List<Crop> c = crp.findByCropName(name);
		if (c.isEmpty()) {
			logger.error("list is empty....");
			throw new CropNotFoundException("list is empty");

		} else {
			logger.info("list of cropby name is returned ...");
			return c;
		}
	}

	@Override
	public List<Crop> getbyuserId(int id) throws UserNotFoundException {
		logger.info("cursor pointor is inside of getbyuserId service method");
		List<Crop> c = crp.findByUserId(id);

		if (c.isEmpty()) {
			logger.error("user not found....");
			throw new UserNotFoundException("NO such is there with that userId"+id);

		} else {
			logger.info("user crop details list returned ...");
			return c;
		}
	}

}
