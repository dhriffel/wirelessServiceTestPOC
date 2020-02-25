package me.dhriffel.wirelessservice;


/**
 * Class for representing the functionality of a Subscriber to a wireless phone service
 */
public class Subscriber {
    private int Number = 0;
    private String Name = "";
    private Phone Phone = null;

    /**
     * Base Subscriber constructor
     */
    public Subscriber(){
    }

    /**
     * Subscriber constructor
     * @param num the phone number for the subscriber
     * @param name the name of the subscriber
     */
    public Subscriber(int num, String name){
        this();
        this.Number = num;
        this.Name = name;
    }

    /**
     * Subscriber constructor
     * @param num the phone number for the subscriber
     * @param name the name of the subscriber
     * @param phone the Phone for the subscriber
     */
    public Subscriber(int num, String name, Phone phone){
        this(num,name);
        this.Phone = phone;
    }
    //
    /**
     * Getter function for the Number field
     * @return this.Number
     */
    public int getNumber(){
        return Number;
    }
    /**
     * Getter function for the Name field
     * @return this.Name
     */
    public String getName(){
        return Name;
    }

    /**
     * Getter function for the Phone field
     * @return this.Phone
     */
    public Phone getPhone(){
        return Phone;
    }
}
