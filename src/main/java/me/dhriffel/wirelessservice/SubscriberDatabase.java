package me.dhriffel.wirelessservice;

import java.util.HashMap;

/**
 * Class for representing the functionality of a Subscriber database for a wireless phone service provider
 */
public class SubscriberDatabase {

    /**
     * HashMap representing the database, holds Integer (Phone number), Subscriber pairs
     */
    private HashMap<Integer, Subscriber> subscribers = new HashMap<>();

    /**
     * Function for adding a Subscriber to the database
     * @param sub the Subscriber to be added
     * @return boolean, true if successfully added, false if the given Subscriber is null or the addition failed
     */
    public boolean addSubscriber(Subscriber sub){
        if (sub == null){return false;}
        subscribers.put(sub.getNumber(),sub);
        return checkIfSubscriber(sub.getNumber());
    }

    /**
     * Function for removing a Subscriber from the database
     * @param number the phone number of the subscriber to be removed
     * @return boolean, True if the subscriber is successfully removed, False if they are still in the database
     */
    public boolean removeSubscriber(int number){
        if (checkIfSubscriber(number)){
            subscribers.remove(number);}
        return !checkIfSubscriber(number);

    }

    /**
     * Function for updating the information of a Subscriber
     * @param number the phone number of the subscriber to be updated
     * @param sub the Subscriber holding the updated information
     * @return boolean, True if the information has successfully been updated, False if the Subscriber doesn't exist in the database
     */
    public boolean updateSubscriber(int number, Subscriber sub){
            if (checkIfSubscriber(number)){
                if (sub.getNumber() != number){
                    removeSubscriber(number);
                    addSubscriber(sub);
                }
                else{subscribers.replace(number, sub);}
                return true;
            }
            else return false;
    }

    /**
     * Getter function for retrieving a Subscriber from the database
     * @param number the phone number of the Subscriber to be returned
     * @return Subscriber corresponding to the given number
     */
    public Subscriber getSubscriber(int number){
        return subscribers.get(number);
    }

    /**
     * Function to check if a Subscriber is present in the database
     * @param number phone number of the Subscriber to be checked for
     * @return boolean, True if the Subscriber is in the database, False if it is not
     */
    public boolean checkIfSubscriber(int number){
        return subscribers.containsKey(number);
    }
}
