package com.restaurant.microservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.google.gson.Gson;
import com.restaurant.config.RestaurantConfig;
import com.restaurant.controller.RestaurantController;
import com.restaurant.model.Item;
import com.restaurant.model.Menu;
import com.restaurant.model.Restaurant;
import com.restaurant.model.Table;


@SpringBootApplication
@ImportAutoConfiguration(classes= {RestaurantConfig.class})
@EnableEurekaClient
public class RestaurantMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantMicroServiceApplication.class, args);
//		Item item=new Item();
//		item.setItemName("manchuria");
//		item.setPrice(100D);
//		item.setItemCategory("starters");
//		Item item2=new Item();
//		item2.setItemName("manchuria2");
//		item2.setPrice(200D);
//		item2.setItemCategory("starters");
//		Item item3=new Item();
//		item3.setItemName("manchuria3");
//		item3.setPrice(300D);
//		item3.setItemCategory("starters");
//		Item item4=new Item();
//		item4.setItemName("manchuria4");
//		item4.setPrice(400D);
//		item4.setItemCategory("starters");
//		Item item5=new Item();
//		item5.setItemName("manchuria4");
//		item5.setPrice(500D);
//		item5.setItemCategory("starters");
//		Item item6=new Item();
//		item6.setItemName("manchuria5");
//		item6.setPrice(600D);
//		item6.setItemCategory("starters");
//		Item item7=new Item();
//		item7.setItemName("manchuria6");
//		item7.setPrice(600D);
//		item7.setItemCategory("starters");
//		Item item8=new Item();
//		item8.setItemName("manchuria7");
//		item8.setPrice(600D);
//		item8.setItemCategory("starters");
//		Item item9=new Item();
//		item9.setItemName("manchuria8");
//		item9.setPrice(600D);
//		item9.setItemCategory("starters");
//		Item item10=new Item();
//		item10.setItemName("manchuria9");
//		item10.setPrice(600D);
//		item10.setItemCategory("starters");
//		List<Item> items=new ArrayList<>();
//		items.add(item);
//		items.add(item2);
//		items.add(item3);
//		items.add(item4);
//		items.add(item5);
//		items.add(item6);
//		items.add(item7);
//		items.add(item8);
//		items.add(item9);
//		items.add(item10);
//		Menu menu=new Menu();
//		menu.setItems(items);
//		Table table=new Table();
//		table.setBooked(false);
//		table.setCategory("special");
//		List<Table> tables=new ArrayList<>();
//		tables.add(table);
//		Restaurant restaurant=new Restaurant();
//		restaurant.setRestaurantName("parivaar");
//		restaurant.setRestaurantAddress("hyderabad");
//		restaurant.setTableFleet(200);
//		restaurant.setTables(tables);
//		restaurant.setMenu(menu);
//		Gson gson=new Gson();
//		String json = gson.toJson(restaurant);
//		System.out.println(json);
//		
	}
}
