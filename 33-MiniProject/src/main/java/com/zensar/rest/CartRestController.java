package com.zensar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.bean.Cart;
import com.zensar.bean.CartRequest;
import com.zensar.bean.Product;
import com.zensar.service.CartService;

public class CartRestController {
	@Autowired
	CartService service;

	@PostMapping(value = "/addcart")
	public Cart f1(@RequestBody CartRequest request) {
		Cart cart = request.getCart();
		Product product = request.getProduct();
		int qunatity = request.getQuantity();
		return this.service.addProductToCart(cart, product, qunatity);
	}

	@PutMapping(value = "/removeproductfromcart")
	public Cart f2(@RequestBody CartRequest request) {
		Cart cart = request.getCart();
		Product product = request.getProduct();
		return this.service.removeProductFromCart(cart, product);
	}

	@PutMapping(value = "/updatecartquantity")
	public Cart f3(@RequestBody CartRequest request) {
		Cart cart = request.getCart();
		Product product = request.getProduct();
		int qunatity = request.getQuantity();
		return this.service.updateProductQuantity(product, cart, qunatity);
	}

	@PutMapping(value = "/removeallproductfromcart")
	public Cart f4(@RequestBody Cart cart) {
		return this.service.removeAllProducts(cart);
	}
}