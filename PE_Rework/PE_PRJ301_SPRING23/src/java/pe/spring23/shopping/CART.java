/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.spring23.shopping;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hd
 */
public class CART {
//    your code here    
    private static List<Product> products;

    public CART() {
    }
    
    public CART(List<Product> products) {
        this.products = products;
    }

    public static List<Product> getProducts() {
        return products;
    }
    
    public void addProduct(Product p){
        if(this.products==null){
            this.products = new ArrayList<Product>();
        }
        boolean checkDup = false;
        for(Product product:products){
            if(product.getProductID().equals(p.getProductID())){
                product.setQuantity(product.getQuantity() + 1);
                checkDup = true;
            }
        }
        if(!checkDup){
            products.add(p);
        }
    }
    
    public static float total(){
        float total = 0;
        for(Product p:products){
            total += p.getTotal();
        }
        return total;
    }
    
    public static void updateQuantity(int quantity, String productID){
        for(Product p:products){
            if(p.getProductID().equals(productID)){
                p.setQuantity(quantity);
            }
        }
    }
}
