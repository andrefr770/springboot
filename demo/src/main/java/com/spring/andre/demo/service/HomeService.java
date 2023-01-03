package com.spring.andre.demo.service;

import static com.spring.andre.demo.utils.Constants.AWS_MACHINE_ADDRESS;
import static com.spring.andre.demo.utils.Utils.formatterPriceEuro;
import static com.spring.andre.demo.utils.Utils.generateRandomInt;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.spring.andre.demo.dto.HomeDTO;
import com.spring.andre.demo.model.Home;
import com.spring.andre.demo.repository.HomeRepository;;

@Component
public class HomeService {

	private static final Logger log = LoggerFactory.getLogger(HomeService.class);
	
	@Autowired
	HomeRepository homeRepository;
	
	@Autowired
	AmazonService amazonService;

	public Home registerHome(HomeDTO homeDTO, MultipartFile multiPartfile) {
		log.info("Creating a new home");
		Home home = new Home(UUID.randomUUID().toString(), homeDTO);
		home.setParameterValue(generateRandomInt());
		home.setPrice(formatterPriceEuro(homeDTO.getPrice()));
		
		String file = amazonService.uploadFile(multiPartfile);
		String fileName = file.substring(file.indexOf(" ") + 1);
		home.setImagePath(AWS_MACHINE_ADDRESS + fileName);
		home.setImageFileName(fileName);
		
		
		log.info("New home created with this properties: " + home.toString());
		return homeRepository.save(home);
	}

	public void deleteHome(Long id) {
		log.info("Deleting home " + id);
		homeRepository.deleteById(id);
		log.info("Home deleted");
	}

	public Iterable<Home> getAllHomes() {
		log.info("Fetching all homes");
		return homeRepository.findAll();
	}

	public List<Home> getHome(String id) {
		ArrayList<Home> home = new ArrayList<>();
		try {
			log.info("Fetchin a specific home by its id");
			home = homeRepository.findOne(id);
			log.info("Fetched home with following properties " + home.toString());
		} catch (Exception e) {
			log.error("Erro ao aceder ao serviço de procurar da casa", e);
		}
		
		return home;
	}

	public void updateHome(String id, HomeDTO homeDTO) {
		log.info("Updating home with this id: " + id);
		ArrayList<Home> home = homeRepository.findOne(id);
		Home homeUpdated = new Home(home.get(0).getId(), homeDTO);
		log.info("Finished updating home with this id: " + id);
		homeRepository.save(homeUpdated);
	}
}
