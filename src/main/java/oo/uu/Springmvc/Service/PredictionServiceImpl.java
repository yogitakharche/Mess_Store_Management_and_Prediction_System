package oo.uu.Springmvc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oo.uu.Springmvc.Repository.PredictionRepository;

@Service("predictServ")
public class PredictionServiceImpl implements PredictionService {

	@Autowired
	PredictionRepository predictRepo;
	
	
}
