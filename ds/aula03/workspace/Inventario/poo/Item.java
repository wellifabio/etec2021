package poo;

class Item{

    int id;
    String name;
    String acquisition;
    float price;

    String getPriceReais(){
        return String.format("R$ %.2f", this.price);
    }
}