package oo.uu.Springmvc.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("prdictRepo")
public class PredictionRepositoryImpl implements PredictionRepository{

	@Autowired
	JdbcTemplate template;
}
