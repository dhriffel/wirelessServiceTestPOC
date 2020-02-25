package me.dhriffel.wirelessservice;

/**
 * Operating System options for a Phone
 */
enum OperatingSystem {IOS,Android};

/**
 * Class for representing a Subscriber's Phone
 */
public class Phone {
    /**
     * int representing the storage size of the phone in gigabytes
     */
    private int StorageGigabytes = 0;
    /**
     *  int representing the screen size of the phone in inches
     */
    private int ScreenSize = 0;
    /**
     * base field holding the OperatingSystem of the phone
     */
    private OperatingSystem OS = OperatingSystem.IOS;

    /**
     * Base Phone constructor
     */
    public Phone(){}

    /**
     * Phone Constructor
     * @param storage storage size of the phone in gigabytes
     * @param screen screen size of the phone in inches
     * @param os operating system of the phone
     */
    public Phone(int storage, int screen, OperatingSystem os){
        this.StorageGigabytes = storage;
        this.ScreenSize = screen;
        this.OS = os;
    }

    /**
     * Getter for the Storage Size field
      * @return int representing the storage size of the phone in gigabytes
     */
    public int getStorageGigabytes() {
        return StorageGigabytes;
    }

    /**
     * Getter for the Screen Size field
     * @return in representing the screen size of the phone in inches
     */
    public int getScreenSize() {
        return ScreenSize;
    }

    /**
     * Getter for the Operating System field
     * @return OperatingSystem of the phone
     */
    public OperatingSystem getOS() {
        return OS;
    }

    /**
     * Equality check override, compares all fields for equality
     * @param phone the Phone to compare against this Phone
     * @return boolean, True if all fields are equal and false otherwise
     */
    public boolean equals(Phone phone){
        return (this.StorageGigabytes == phone.getStorageGigabytes()) && (this.ScreenSize == phone.getScreenSize()) && (this.OS == phone.getOS());
    }
}
