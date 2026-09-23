package Modelo;

import java.util.ArrayList;

public class ResultadoDrop {
    private ArrayList<Item> items;
    private int oro;

    public ResultadoDrop() {
        this.items = new ArrayList<>();
        this.oro = 0;
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    public void agregarOro(int cantidad) {
        this.oro += cantidad;
    }

    public ArrayList<Item> getItems() { return items; }
    public int getOro() { return oro; }

    @Override
    public String toString() {
        return "Items: " + items + " | Oro: " + oro;
    }
}