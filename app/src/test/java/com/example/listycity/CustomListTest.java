package com.example.listycity;

import org.junit.Test;

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
}
