package com.bestbuy.testsuite;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.steps.StoresSteps;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.equalTo;

/**
 * Created By Bhavesh
 */

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StoreTestWithTags extends TestBase {

    static String name = "Testing Store" + TestUtils.getRandomValue();
    static String type = "Testing Tools"+ TestUtils.getRandomValue();
    static String address = "268 Alan Lodge"+ TestUtils.getRandomValue();
    static String address2 = "Nether Street"+ TestUtils.getRandomValue();
    static String city = "London"+ TestUtils.getRandomValue();
    static String state = "North"+ TestUtils.getRandomValue();
    static String zip = "52525ZQ"+ TestUtils.getRandomValue();
    static double lat = 45.958785;
    static double lng = -90.445596;
    static String hours = "Mon: 9-6; Tue: 9-6; Wed: 9-6; Thurs: 9-6; Fri: 9-6; Sat: 9-6; Sun: 9-6";
    static long storeId;


    @Steps
    StoresSteps storesSteps;

    @WithTags({@WithTag("bestbuyfeature:POSITIVE"),
            @WithTag("bestbuyfeature:REGRESSION")
    })
    @Title("This test will Create a new Store")
    @Test
    public void test001() {
        storesSteps.createNewStore(name, type, address, address2, city, state, zip, lat, lng, hours);

    }
    @WithTags({@WithTag("bestbuyfeature:SANITY"),
            @WithTag("bestbuyfeature:REGRESSION")
    })
    @Title("This test will get store information by ID")
    @Test
    public void test002() {
        int storeId = storesSteps.getAllStores().statusCode(200).extract().path("data[0].id");
        storesSteps.getStoreById(storeId).statusCode(200);

    }

    @WithTags({@WithTag("bestbuyfeature:POSITIVE"),
            @WithTag("bestbuyfeature:REGRESSION")
    })
    @Title("This test will update the store information and verify the updated information")
    @Test

    public void test003() {

        name = name+"_changed";
        type = type+"_changed";
        address =address+"_updated";
        address2 = address2 +"_updated";
        hours = "Mon: 8-6; Tue: 8-6; Wed: 8-6; Thurs: 8-6; Fri: 8-6; Sat: 8-6; Sun: 8-6";
        int storeId = storesSteps.getAllStores().statusCode(200).extract().path("data[1].id");
        storesSteps.updateStore(storeId,name, type, address, address2, city, state, zip, lat, lng, hours).statusCode(200);
        storesSteps.getStoreById(storeId).body("name",equalTo(name));

    }

    @WithTags({@WithTag("bestbuyfeature:NEGATIVE"),
            @WithTag("bestbuyfeature:REGRESSION")
    })
    @Title("This test will delete the store and verify the store is deleted ")
    @Test
    public void test004() {
        int storeId = storesSteps.getAllStores().statusCode(200).extract().path("data[1].id");
        storesSteps.deleteStore(storeId).statusCode(200);
        storesSteps.getStoreById(storeId).statusCode(404);
    }

    @WithTags({@WithTag("bestbuyfeature:SMOKE"),
            @WithTag("bestbuyfeature:REGRESSION")
    })
    @Title("This test will get all product information ")
    @Test

    public void test005(){
        storesSteps.getAllStores().statusCode(200);
    }

}
