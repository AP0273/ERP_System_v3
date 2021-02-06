package seed;

import app.Application;
import model.Products;

import java.util.ArrayList;
import java.util.Stack;


public class Tree {
    public Node root;

    public Node germinateSeed(ArrayList<Products> productslist, Node root, int i) {

            if (i < productslist.size()) {
                Node temp = new Node(productslist.get(i));
                root = temp;

               root.pleft = germinateSeed(productslist, root.pleft,
                        2 * i + 1);

                root.pright = germinateSeed(productslist, root.pright,
                        2 * i + 2);
            }
            return root;
        }

    public static int getParent(int childIndex)
    {
        int parentIndex = (int) Math.floor((double)(childIndex)/2);
        return parentIndex;
    }

        public static Stack getTrace (int id) {
            Stack trace = new Stack();
            trace.add(id);
            while (id !=1) {
            id = getParent(id);
            if(id!=1) {
                trace.add(id);
            }
            }
            return trace;
               }

        public void FindTree(int id,Node root, Stack trace) {
            if (root.product.getId() == id) {
                System.out.println(root.product.getName() + " Quantidade em estoque " + root.product.getNumber_stock());
                Application.menu();
            } else {
                try {
                if (trace.peek().equals(root.pleft.product.getId())) {
                    trace.pop();
                    root = root.pleft;
                    System.out.println("Going down on Right");
                    FindTree(id, root,trace);
                }
                if (trace.peek().equals(root.pright.product.getId())) {
                    trace.pop();
                    root = root.pright;
                    System.out.println("Going down on Left");
                    FindTree(id, root, trace);
                }
                }catch(NullPointerException e){
                    System.err.println("Not Found");
                    Application.menu();
                    }
                }
    }
            }




