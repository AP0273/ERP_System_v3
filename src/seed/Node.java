package seed;

import model.Products;

public class Node {

    public Products product;
    public Node pleft,pright;

    public Node(Products product) {
        this.product = product;
        this.pleft = null;
        this.pright = null;
    }
}
