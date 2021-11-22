package com.company;

import java.util.ArrayList;

public class Sign {
    private float price, height;
    private int id, category, length, width, language, inStock, usable, reserved;
    private String description, number, text;
    private boolean isActive;
    private ArrayList<String> pickupDates;


    /**
     * Constructor for the sign class.
     * @param id the id of the sign
     * @param number
     * @param description description of the sign
     * @param category category of the sign
     * @param length length of the sign
     * @param width width of the sign
     * @param text text of the sign
     * @param language language of the sign
     * @param inStock number of signs in stock
     * @param price price of the sign
     * @param isActive
     * @param height height of the sign
     * @param usable indicates the number of still usable signs
     * @param reserved whether the sign has been reserved
     */
    public Sign(int id, String number, String description, int category, int length, int width, String text,
                int language, int inStock, float price, boolean isActive, int height, int usable, int reserved){
        this.id = id;
        this.number = number;
        this.category = category;
        this.length = length;
        this.width = width;
        this.text = text;
        this.language = language;
        this.inStock = inStock;
        this.price = price;
        this.isActive = isActive;
        this.height = height;
        this.usable = usable;
        this.reserved = reserved;
        this.pickupDates = new ArrayList<>();
    }

    /*
    This method is outdated and likely unnecessary of this program, but might still be useful.

    public String toString(){
        String result = "";
        result += "Type: " + type + "\n";
        result += "Language: " + language + "\n";
        result += "Height: " + height + " inches\n";
        result += "Price: $" + price + "\n";
        result += "Reserved: " ;

        if(reserved){
            result += "yes\n";
        } else {
            result += "no\n";
        }

        result += "Usable: " ;

        if(usable){
            result += "yes\n";
        } else {
            result += "no\n";
        }

        return result;
    }
*/

    //Accessors


    public int getReserved() {
        return reserved;
    }

    public float getHeight() {
        return height;
    }

    public int getUsable() {
        return usable;
    }

    public float getPrice() {
        return price;
    }

    public int getLanguage() {
        return language;
    }

    public ArrayList<String> getPickupDates(){ return pickupDates; }

    public int getId(){
        return id;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public int getCategory() {
        return category;
    }

    public int getInStock() {
        return inStock;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getDescription() {
        return description;
    }

    public String getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }


    //Mutators


    public void setHeight(float height) {
        this.height = height;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setReserved(int reserved) { this.reserved = reserved; }

    public void setUsable(int usable){
        this.usable = usable;
    }

    public void addPickupDate(String date) { pickupDates.add(date); }

    public void removePickupDate(String date) { pickupDates.remove(date); }

    public void setId(int id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setCategory(int catagory) {
        this.category = catagory;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
