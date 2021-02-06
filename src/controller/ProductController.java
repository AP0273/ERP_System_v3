package controller;

import model.Products;

import java.util.ArrayList;
import java.util.Locale;

public class ProductController {

    protected ArrayList<Products> products;

    public ProductController(ArrayList<Products> products){
        this.products = products;
    }

    public Products findById(int id){
        for (Products product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }
    public Products binaryFindById(int id,int begin, int end){

        if(begin <= end) {
            int m = (begin+end)/2;
            Products product = products.get(m);
            if(product.getId() == id) {
                return product;
            }
            if(id < product.getId()) {
                return binaryFindById(id,begin,m-1);
            }else{
                return binaryFindById(id,m+1,end);
            }
        }else{
            return null;
        }
    }
    public int getLenghtList() {
        int lenght = products.size()-1;
        return lenght;
    }
    public void saveProduct(Products product){
     products.set(product.getId(),product);
    }

    public ArrayList<Products> findByNameRootsWay(String targetName) {

        ArrayList<Products> found = new ArrayList();

        for (Products p : products) {
            if (targetName.equals(p.getName())) {
                System.out.println("\n\n\n YES \n\n\n");
            }
        }

        return null;
    }

    public ArrayList<Products> findByName(String name){

        ArrayList<Products> found = new ArrayList();

        for (Products p : products){
            if (p.getName().toLowerCase().contains(name.toLowerCase())){
                found.add(p);
            }
        }

        return found;
    }


    public ArrayList<Products> get() {

        for (Products p : products) {

            System.out.println("\t id : "+p.getId()+"\t name : "+p.getName());

        }

        return null;
    }
}


