package com.company;

public class Sign {
    private float price, height;
    private String type, language;
    private boolean usable, reserved;


    public static void main(String[] args){
        Sign stop = new Sign(10, 54, "Stop", "English", true, false);
        System.out.println(stop);
    }


    /**
     * @param price price of the sign
     * @param height height of the sign in inches
     * @param type type of the sign
     * @param language language the sign's text is written in
     * @param usable true if the sign is not damaged enough to be unusable
     * @param reserved true if the sign has been reserved for pickup
     */
    public Sign(float price, float height, String type, String language, boolean usable, boolean reserved){
        this.price = price;
        this.height = height;
        this.type = type;
        this.language = language;
        this.usable = usable;
        this.reserved = reserved;
    }

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


    //Accessors


    public boolean isReserved() {
        return reserved;
    }

    public float getHeight() {
        return height;
    }

    public boolean isUsable() {
        return usable;
    }

    public float getPrice() {
        return price;
    }

    public String getLanguage() {
        return language;
    }

    public String getType() {
        return type;
    }


    //Mutators


    public void setHeight(float height) {
        this.height = height;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUsable(boolean usable){
        this.usable = usable;
    }

//    public void getInventory(){
//        Boolean over = false;
//        while(over != true) {
//            //for(int i = signArray.length() -1)
//            for(int i = 0; i < signArray.length(); i++){ //'signArray' is a placeholder variable name
//                int signRes = 0;
//                int signCount = 0;
//                if(signArray.isUsable() == usable) {
//                    signCount++;
//                }
//                else{
//                    signCount = signCount;
//                }
//                if(signArray.isReserved() == reserved) {
//                    signRes++;
//                }
//                else{
//                    signRes = signRes;
//                }
//                //if(i == )
//                //System.out.println("There are currently: " + signCount + "usable signs");
//                System.out.println("Usable Signs: " + signCount);
//                System.out.println("Reserved Signs: " + signRes);
//                System.out.println("Available Signs: " + (signCount - signRes));
//                over = true;
//            }
//        }
//
//    }





}
