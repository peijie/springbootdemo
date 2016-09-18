package com.mountainwind.sample.productservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chart")
public class ChartController {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ChartData> findAll() {
		List<ChartData> chart = new ArrayList<ChartData>();
		chart.add(new ChartData("2004", 1000, 400));
		chart.add(new ChartData("2005", 1170, 460));
		chart.add(new ChartData("2006", 660, 1120));
		chart.add(new ChartData("2007", 1030, 540));
		
		return chart;
	}

}


