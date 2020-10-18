package com.elevenst.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement(name = "ProductSearchResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSearchResponse {
	
	private List<Product> Products;

	public ProductSearchResponse() {
	}
	public ProductSearchResponse(List<Product> Products) {
		this.Products = Products;
	}
	@XmlElementWrapper(name="Products")
	@XmlElement(name="Product")
	public List<Product> getProducts() {
		return Products;
	}
	public void setProducts(List<Product> Products) {
		this.Products = Products;
	}
	
	
	@XmlRootElement(name="Product")
	public static class Product {
		@XmlElement(name = "ProductName")
		private String ProductName;
		@XmlElement(name = "ProductImage")
		private String ProductImage;
		@XmlElement(name = "ProductPrice")
		private String ProductPrice;
		
		public Product() {
		}
		public Product(String ProductName, String ProductImage, String ProductPrice) {
			this.ProductName = ProductName;
			this.ProductImage = ProductImage;
			this.ProductPrice = ProductPrice;
		}
		public String getProductName() {
			return ProductName;
		}
		public void setProductName(String ProductName) {
			this.ProductName = ProductName;
		}
		public String getProductImage() {
			return ProductImage;
		}
		public void setProductImage(String ProductImage) {
			this.ProductImage = ProductImage;
		}
		public String getProductPrice() {
			return ProductPrice;
		}
		public void setProductPrice(String ProductPrice) {
			this.ProductPrice = ProductPrice;
		}
		@Override
		public String toString() {
			return "Product [ProductName=" + ProductName + ", ProductImage=" + ProductImage + ", ProductPrice="
					+ ProductPrice + "]";
		}
	}

}
