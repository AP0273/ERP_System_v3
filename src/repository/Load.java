package repository;

import model.Products;
import model.StockProduct;
import utilities.FileChooserCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


public class Load {
    static int total_amount = 0;
    protected ArrayList<Products> products;
    private final FileChooserCSV filechooser = new FileChooserCSV();
    public static final String splitcsvregex = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";
    static int daycounter = 0;
    static int monthcounter = 1;
    static int yearcounter = 2021;
    public void load() {

        String csvpath = filechooser.getCsvPath();
        if(csvpath.equals("Error")) {
            System.err.println("Arquivo não selecionado ou incompatível a extensão deve ser CSV");
        System.exit(0);
        }
        BufferedReader br = null;
        String line;

        try {
            ArrayList<Products> loaded = new ArrayList<>();

            br = new BufferedReader(new FileReader(csvpath));
            csvLineSplitter(br.readLine());

            while ((line = br.readLine()) != null) {

                System.out.println("\n\n"+line);

                String[] row = line.split(splitcsvregex);

                loaded.add(new Products(Integer.parseInt(row[0].trim()), row[21],randomstockinsert(),total_amount));
                total_amount=0;
              /* if(loaded.size() == 100) {
                    break;
                }*/
            }

            this.setProducts(loaded);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void csvLineSplitter(String line) {

        String[] SplitedLine = line.split(splitcsvregex);
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }
    public static int randomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
    public Queue<StockProduct> randomstockinsert() {
        Queue<StockProduct> stock = new LinkedList<>();
        int iterations = randomIntBetween(1,20);
        for(int i = 0; i<iterations; i++) {
            int random_amount = randomIntBetween(1, 100);
            stock.add(new StockProduct(random_amount, randomDate(2020, 2021)));
        total_amount += random_amount;
        }
        return stock;
    }
    public static LocalDate randomDate(int startYear, int endYear) {
        daycounter++;
        if(daycounter > 28) {
            daycounter = 1;
            monthcounter++;
        }
        if(monthcounter > 12) {
            monthcounter = 1;
            yearcounter++;
        }
        return LocalDate.of(yearcounter, monthcounter, daycounter);
    }


}
