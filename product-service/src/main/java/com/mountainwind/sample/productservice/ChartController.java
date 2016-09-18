package com.mountainwind.sample.productservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chart")
public class ChartController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String[][] findAll() {
		String[][] chart = new String[6][3];
		chart[0] = new String[] {"2004", "1000", "400"};
		chart[1] = new String[] {"2005", "1170", "460"};
		chart[2] = new String[] {"2006", "660", "1120"};
		chart[3] = new String[] {"2007", "1030", "540"};
		chart[4] = new String[] {"2008", "1400", "700"};
		chart[5] = new String[] {"2009", "800", "1000"};
		
//		List<ChartData> chart = new ArrayList<ChartData>();
//		chart.add(new ChartData("2004", 1000, 400));
//		chart.add(new ChartData("2005", 1170, 460));
//		chart.add(new ChartData("2006", 660, 1120));
//		chart.add(new ChartData("2007", 1030, 540));
		
		return chart;
	}

}


