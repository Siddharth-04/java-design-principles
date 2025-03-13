import java.sql.SQLOutput;
import java.util.ArrayList;

class Order{
    Customer customer;
    ArrayList<Product> products;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void showDetails(){
        System.out.println("Customer Name: "+customer.getName());
        System.out.println("Customer Address " + customer.getAddress());
        double totalCartPrice = 0;

        for( Product p : products){
            totalCartPrice += p.price;
            System.out.println("Product Name: "+p.getName() + ", Price: "+p.price);
        }

        System.out.println("Total Cart Price: "+totalCartPrice + "\n");
    }

}
class Customer{
    String name;
    String address;
    ArrayList<Order> orders;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
    }

    String getName(){
        return this.name;
    }
    String getAddress(){
        return this.address;
    }

    public void placeOrder(Order order){
        this.orders.add(order);
    }

    public void viewOrders(){
        for(Order order : orders){
            //order details call
            order.showDetails();
        }
    }
}
class Product{
    String name;
    double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
}
public class Ecommerce {
    public static void main(String[] args) {
        Product toy = new Product("Monkey Toy", 100.0);
        Product key = new Product("Key Chain", 10.0);

        Customer customer1 = new Customer("Siddharth", "Mayur Vihar, Delhi");
        Customer customer2 = new Customer("Abhiraj", "New Ashok Nagar, Delhi");

        Order order1 = new Order(customer1);
        order1.addProduct(toy);
        order1.addProduct(key);
        customer1.placeOrder(order1);

        Order order2 = new Order(customer2);
        order2.addProduct(key);
        customer2.placeOrder(order2);

        customer1.viewOrders();
        customer2.viewOrders();



    }
}

//Customer Name: Siddharth
//Customer Address Mayur Vihar, Delhi
//Product Name: Monkey Toy, Price: 100.0
//Product Name: Key Chain, Price: 10.0
//Total Cart Price: 110.0
//
//Customer Name: Abhiraj
//Customer Address New Ashok Nagar, Delhi
//Product Name: Key Chain, Price: 10.0
//Total Cart Price: 10.0
