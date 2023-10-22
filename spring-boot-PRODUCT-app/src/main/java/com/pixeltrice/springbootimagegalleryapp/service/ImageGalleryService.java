package com.pixeltrice.springbootimagegalleryapp.service;

import java.util.List;
import java.util.Optional;

import com.pixeltrice.springbootimagegalleryapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixeltrice.springbootimagegalleryapp.repository.ProductRepository;



@Service
public class ImageGalleryService {

	@Autowired
	private ProductRepository productRepository;
	
	public void saveImage(Product product) {
		productRepository.save(product);
	}

	public List<Product> getAllActiveImages() {
		return productRepository.findAll();
	}

	public Optional<Product> getImageById(Long id) {
		return productRepository.findById(id);
	}

	public void deleteById(Long id){
		productRepository.deleteById(id);
	}
}

