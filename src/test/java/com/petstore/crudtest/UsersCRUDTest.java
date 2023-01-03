package com.petstore.crudtest;

import com.petstore.steps.UsersSteps;
import com.petstore.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import io.vavr.collection.HashMap;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

public class UsersCRUDTest extends TestBase
{
    static String  id = "12";
    static String userName = "Anya129";
    static String firstName = "Anya";
    static String lastName = "Akk";
    static String email = "Anu@example.com";
    static String password = "test123";
    static String phone = "9876543212";
    static String userStatus = "1";
    static int userID;

    @Steps
    UsersSteps usersSteps;

    @Title("This test will Create a new User")
    @Test
    public void test001(){
        ValidatableResponse response = usersSteps.createNewUser(id, userName,firstName,lastName,email,password,phone,userStatus);
        response.log().all().statusCode(200);

    }
    @Title("Verify user was added")
    @Test
    public void test002() {
        HashMap<String, Object> userMap = usersSteps.getUserByUserName(userName);
        //Assert.assertThat(userMap, hasValue(userName));
    }
    @Title("Update the user information and verify the updated information")
    @Test
    public void test003() {
        userName = userName + "_updated";
        usersSteps.updateUser(id,userName,firstName,lastName,email,password,phone,userStatus);
        HashMap<String, Object> userMap = usersSteps.getUserByUserName(userName);
       // Assert.assertThat(userMap, hasValue(userName));
    }
    @Title("Verify user was deleted")
    @Test
    public void test004() {
        usersSteps.deleteUser(userName).statusCode(200).log().all();

    }


}
