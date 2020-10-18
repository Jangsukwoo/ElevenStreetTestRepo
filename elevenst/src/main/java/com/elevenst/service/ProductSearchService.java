package com.elevenst.service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.elevenst.model.ProductSearchResponse;
import com.elevenst.model.ProductSearchResponse.Product;

@Slf4j
@Service
public class ProductSearchService {
    private String apiUrl;
    private String apikey;
    private RestTemplate restTemplate;
    private HttpEntity<?> httpEntity;

    public ProductSearchService(@Value("${elevenst.apiurl}") String apiUrl,
    		@Value("${elevenst.apikey}") String apikey) {
        this.apiUrl = apiUrl;
        this.apikey = apikey;
        this.restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.AUTHORIZATION, "openapikey:" + this.apikey);
        httpHeaders.setContentType(MediaType.APPLICATION_XML);
        this.httpEntity = new HttpEntity<>(httpHeaders);
    }

    public List<Product> getProductList(String searchName) {

    	UriComponents uriComponents = UriComponentsBuilder
    			.fromHttpUrl(apiUrl)
    			.queryParam("key",apikey)
    			.queryParam("apiCode","ProductSearch")
    			.queryParam("keyword",searchName)
    			.build();
    	System.out.println(uriComponents.toString());
    	String url = uriComponents.toUriString();
    	
    	System.out.println("�ּ�!");
    	System.out.println(url);
    	
    
    	ProductSearchResponse productSearchResponse= restTemplate.exchange(url, 
        		HttpMethod.GET, httpEntity,ProductSearchResponse.class).getBody();
    	
    	System.out.println(productSearchResponse.toString());
    	
    	
    	List<Product> products = productSearchResponse.getProducts();
    	//System.out.println(products.size());
        if (!CollectionUtils.isEmpty(products)) {
            for(Product product : products) {
            	System.out.println(product.toString());
            }
        }
        return null;
    }
}