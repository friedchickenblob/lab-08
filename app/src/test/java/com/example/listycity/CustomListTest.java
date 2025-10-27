package com.example.listycity;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class CustomListTest {
    private CustomList mockCityList() {
        ArrayList<City> dataList = new ArrayList<>();
        dataList.add(mockCity());
        CustomList cityList = new CustomList(null,dataList);

        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CustomList cityList = mockCityList();
        assertEquals(1, cityList.getCount());
        City city = new City("Regina", "Saskatchewan");
        cityList.addCity(city);
        assertEquals(2, cityList.getCount());
    }

    @Test
    public void testHasCity() {
        CustomList cityList = mockCityList();

        City mockCity = mockCity();
        assertEquals(true, cityList.hasCity(mockCity));

        assertEquals(false, cityList.hasCity(new City("bruh", "moment")));
    }

    @Test
    public void testDeleteCity() {
        CustomList cityList = mockCityList();

        City mockCity = mockCity();

        try {
            cityList.delete(mockCity);
        } catch (Exception e) {
            System.out.println("error: " + e);
        }

        for (City c : cityList.getCities()) {
            System.out.println(c.getCityName());
        }

        assertEquals(false, cityList.hasCity(mockCity));

        Exception thrown = assertThrows(Exception.class, () -> {
            cityList.delete(mockCity);
        });

        Assertions.assertEquals("city not in list", thrown.getMessage());
    }
}
