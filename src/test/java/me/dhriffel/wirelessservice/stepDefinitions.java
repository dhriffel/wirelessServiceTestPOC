package me.dhriffel.wirelessservice;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.Map;

public class stepDefinitions {
    private Subscriber subscriber;
    private SubscriberDatabase database;


    @Given("The following Subscribers are in the database")
    public void theFollowingSubscribersAreInTheDatabase(Map<Integer, String> map) {
        database = new SubscriberDatabase();
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            database.addSubscriber(new Subscriber(pair.getKey(), pair.getValue(), new Phone()));
            Assert.assertTrue(database.checkIfSubscriber(pair.getKey()));
        }

    }

    @Given("(.*) subscribes with number (.*)")
    public void name_subscribes_with_number(String name, Integer num) {
        subscriber = new Subscriber(num,name, new Phone());
    }

    @Given("Number (.*) is not already taken")
    public void number_is_not_already_taken(Integer num) {
        Assert.assertFalse(database.checkIfSubscriber(num));
    }

    @When("(.*) is added to the database")
    public void they_are_added_to_the_database(Integer num) {
        Assert.assertTrue(database.addSubscriber(subscriber));
    }

    @Then("(.*) is (.*) in the database")
    public void they_are_present_in_the_database(Integer num, String Presence) {
        if (Presence.equals("present")) {
            Assert.assertTrue(database.checkIfSubscriber(num));
        }
        else{
            Assert.assertFalse(database.checkIfSubscriber(num));
        }
    }

    @When("(.*) is removed from the database")
    public void numIsRemovedFromTheDatabase(Integer num) {
            Assert.assertTrue(database.removeSubscriber(num));
    }

    @When("(.*) (.*) is updated")
    public void theirInfoIsUpdated(Integer num, String infoType) {
        if(database.checkIfSubscriber(num)) {
            if (infoType.equals("number")) {
                Assert.assertTrue(database.updateSubscriber(num,
                        new Subscriber(0, database.getSubscriber(num).getName())));
            }
            else if(infoType.equals("name")) {
                Assert.assertTrue(database.updateSubscriber(num, new Subscriber(num, database.getSubscriber(num).getName().concat("!"))));
            }
            else{
                Assert.assertTrue(database.updateSubscriber(num, new Subscriber(num, database.getSubscriber(num).getName(),new Phone(32,7,OperatingSystem.IOS))));
            }
        }
        else{
            Assert.assertFalse(database.updateSubscriber(num, new Subscriber()));
        }
    }

    @Then("([0-9]+) (.*) has changed")
    public void numSInfoHasChanged(Integer num, String infoType) {
        if(database.checkIfSubscriber(num)) {
            if (infoType.equals("number")) {
                Assert.assertTrue(database.checkIfSubscriber(0));
            }
            else if (infoType.equals("name")) {
                Assert.assertTrue(database.getSubscriber(num).getName().contains("!"));
            }
            else{
                Assert.assertTrue(database.getSubscriber(num).getPhone().equals(new Phone(32, 7, OperatingSystem.IOS)));
            }
        }
        else
            Assert.assertFalse(database.checkIfSubscriber(num));
    }
}
