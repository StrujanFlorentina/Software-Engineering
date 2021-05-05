package com.example.demo;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.model.Bike;
import com.example.demo.model.BikeProfile;
import com.example.demo.model.BikeService;


@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class BikeProfileTests {
	
	@Autowired
	private BikeProfile rep;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testFindBikeByBrand()
	{
		String brand = "Altruiste Bikes";
		Bike bike=rep.findbyBrand(brand);
		
		assertThat(bike).isNotNull();
	}
	
	@Test
	public void testAddBike() {
		Bike bike=new Bike();
		bike.setBrand("Steppenwolf");
		bike.setColor("Black");
		bike.setFullspeed("100km/h");
		bike.setSize("M");
		bike.setLocation("Bucharest");
		bike.setDisponibility("Available");
		
		Bike savedBike= rep.save(bike);
		
		Bike bike1=new Bike();
		bike1.setBrand("Velovie");
		bike1.setColor("Green");
		bike1.setFullspeed("95km/h");
		bike1.setSize("L");
		bike1.setLocation("Cluj-Napoca");
		bike1.setDisponibility("Available");

		
		Bike savedBike1= rep.save(bike1);
		
		Bike bike2=new Bike();
		bike2.setBrand("Altruiste Bikes");
		bike2.setColor("Red");
		bike2.setFullspeed("120km/h");
		bike2.setSize("S");
		bike2.setLocation("Bucharest");
		bike2.setDisponibility("Available");

		
		Bike savedBike2= rep.save(bike2);
		
		Bike bike3=new Bike();
		bike3.setBrand("Thesis");
		bike3.setColor("Black");
		bike3.setFullspeed("60km/h");
		bike3.setSize("XL");
		bike3.setLocation("Cluj-Napoca");
		bike3.setDisponibility("Available");

		
		Bike savedBike3= rep.save(bike3);
		
		Bike bike4=new Bike();
		bike4.setBrand("Stinner Frameworks");
		bike4.setColor("Purple");
		bike4.setFullspeed("45km/h");
		bike4.setSize("M");
		bike4.setLocation("Cluj-Napoca");
		bike4.setDisponibility("Available");

		
		Bike savedBike4= rep.save(bike4);
		
		Bike bike5=new Bike();
		bike5.setBrand("Rotwild");
		bike5.setColor("Black");
		bike5.setFullspeed("55km/h");
		bike5.setSize("L");
		bike5.setLocation("Bucharest");
		bike5.setDisponibility("Available");

		
		Bike savedBike5= rep.save(bike5);
		
		Bike bike6=new Bike();
		bike6.setBrand("Racycles");
		bike6.setColor("Yellow");
		bike6.setFullspeed("100km/h");
		bike6.setSize("XS");
		bike6.setLocation("Bucharest");
		bike6.setDisponibility("Available");

		
		Bike savedBike6= rep.save(bike6);
		
		Bike bike7=new Bike();
		bike7.setBrand("Pashley");
		bike7.setColor("Black");
		bike7.setFullspeed("70km/h");
		bike7.setSize("L");
		bike7.setLocation("Cluj-Napoca");
		bike7.setDisponibility("Available");

		
		Bike savedBike7= rep.save(bike7);
		
		Bike bike8=new Bike();
		bike8.setBrand("Nukeproof");
		bike8.setColor("Brown");
		bike8.setFullspeed("60km/h");
		bike8.setSize("M");
		bike8.setLocation("Bucharest");
		bike8.setDisponibility("Available");

		
		Bike savedBike8= rep.save(bike8);
		
		Bike bike9=new Bike();
		bike9.setBrand("Mondraker");
		bike9.setColor("Black");
		bike9.setFullspeed("100km/h");
		bike9.setSize("XL");
		bike9.setLocation("Cluj-Napoca");
		bike9.setDisponibility("Available");

		
		Bike savedBike9= rep.save(bike9);
		
		Bike bike10=new Bike();
		bike10.setBrand("Fondriest");
		bike10.setColor("Green");
		bike10.setFullspeed("80km/h");
		bike10.setSize("M");
		bike10.setLocation("Cluj-Napoca");
		bike10.setDisponibility("Available");

		
		Bike savedBike10= rep.save(bike10);
		
		Bike bike11=new Bike();
		bike11.setBrand("Davidson");
		bike11.setColor("Blue");
		bike11.setFullspeed("120km/h");
		bike11.setSize("L");
		bike11.setLocation("Bucharest");
		bike11.setDisponibility("Available");

		
		Bike savedBike11= rep.save(bike11);
		
		Bike existBike = entityManager.find(Bike.class, savedBike.getId());
		
		assertThat(existBike.getBrand()).isEqualTo(bike.getBrand());
	}
}
