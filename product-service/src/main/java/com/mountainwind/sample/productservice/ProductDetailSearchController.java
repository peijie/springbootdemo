package com.mountainwind.sample.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/search")
public class ProductDetailSearchController {
	
	@Autowired
    private ProductDetailRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<?> search(@RequestParam("q") String queryTerm) {
        List<?> productDetails = repository.search("%"+queryTerm+"%");
        return productDetails == null ? new ArrayList<>() : productDetails;
    }
}
