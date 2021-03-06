package com.cg.delightorder.dao;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import com.cg.delightorder.dto.ProductStock;
import com.cg.delightorder.exception.ProductException;
import com.cg.delightorder.util.ProductRepository;


public class ProductDao 
{
     ProductRepository productRepository=new ProductRepository();
     Map<String, ProductStock> productlist=productRepository.getProductlist();
	 public ProductStock trackProductOrder(String orderId)throws ProductException
	 {
		 
		 
   		    return productlist.get(orderId);
		 
		 
	 }
	 public boolean doesProductOrderIdExist(String orderId) throws ProductException
	 {
		 
		 for (Entry<String, ProductStock> mp:productlist.entrySet()) 
		 {
	            if (mp.getValue().getOrderId().contentEquals(orderId))
	            {
	            	return true;
	            }
	            else
	            {
	             throw new ProductException("No OrderId Exist");
	            }
         }
		 return false;
		 
	 }
	 public String updateExitDateinStock(String orderId,Date exitDate) 
	 {
		 for (Entry<String,ProductStock> mp:productlist.entrySet()) 
		 {
			 if (mp.getValue().getOrderId().equals(orderId))
			 {
	           mp.getValue().setExitDate(exitDate);      
             }
			 
		 }
		 return "Data Inserted";
	 }
	 public String updateProductStock(String orderId,Date manufacturing_date,Date expiry_date,String qualityCheck)
	 { 
		 for (Entry<String , ProductStock> mp:productlist.entrySet()) 
		 {
			 if (mp.getValue().getOrderId().contentEquals(orderId))
			 {
	           mp.getValue().setManufacturingDate(manufacturing_date);
	           mp.getValue().setExpiryDate(expiry_date);
	           mp.getValue().setQualityCheck(qualityCheck);
			 }
		 }
		 return "Data Inserted";
	 }
}
