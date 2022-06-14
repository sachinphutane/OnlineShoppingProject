package com.zensar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.zensar.bean.Order;
import com.zensar.service.OrderService;

public class OrderRestController {
	@Autowired
	OrderService service;
	
	@PostMapping("/order/add")
	public Order f1(@RequestBody Order order) {
		return this.service.addOrder(order);
	}

	@GetMapping("/order/find/{Id}")
	public Order f2(@PathVariable(name = "Id") Integer Id) {
		return this.service.viewByOrderId(Id);
	}

	@PutMapping("/order/update/{Id}")
	public Order f3(@RequestBody Order order, @PathVariable(name = "Id") Integer Id) {
		return this.service.updateOrderById(order, Id);
	}

	@DeleteMapping("/order/delete/{id}")
	public boolean f4(@PathVariable(name = "id") Integer id) {
		return service.removeOrder(id);
	}

	@GetMapping("/order/getall")
	public List<Order> f5() {
		return this.service.viewAllOrders();
	}

}
