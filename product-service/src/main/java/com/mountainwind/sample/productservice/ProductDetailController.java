package com.mountainwind.sample.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductDetailController {
	
	@Autowired
	private ProductDetailRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<ProductDetail> findAll(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
	                                       @RequestParam(value = "count", defaultValue = "10", required = false) int count,
	                                       @RequestParam(value = "order", defaultValue = "ASC", required = false) Sort.Direction direction,
	                                       @RequestParam(value = "sort", defaultValue = "productName", required = false) String sortProperty) {
	    Page<ProductDetail> result = repository.findAll(new PageRequest(page, count, new Sort(direction, sortProperty)));
	    return result.getContent();
	}
	
	
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductDetail find(@PathVariable String id) {
        ProductDetail detail = repository.findOne(id);
        if (detail == null) {
            try {
				throw new ProductNotFoundException();
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
        
        return detail;
    }
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ProductDetail create(@RequestBody ProductDetail detail) {
		return repository.save(detail);
		
	}
	
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public HttpEntity<ProductDetail> update(@PathVariable String id, HttpServletRequest request) throws IOException {
//        ProductDetail existing = find(id);
//        ProductDetail updated = objectMapper.readerForUpdating(existing).readValue(request.getReader());
//        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.add("productId", updated.getProductId());
//        propertyValues.add("productName", updated.getProductName());
//        propertyValues.add("shortDescription", updated.getShortDescription());
//        propertyValues.add("longDescription", updated.getLongDescription());
//        propertyValues.add("inventoryId", updated.getInventoryId());
//        DataBinder binder = new DataBinder(updated);
////        binder.addValidators(validator);
//        binder.bind(propertyValues);
//        binder.validate();
//        if (binder.getBindingResult().hasErrors()) {
//            return new ResponseEntity<>(binder.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);
//        } else {
//            return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
//        }
//    }

}
