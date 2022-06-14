package com.zensar.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zensar.bean.Address;
import com.zensar.db.AddressDAO;

@Service
public class AddressService {

	@Autowired
	AddressDAO dao;

	public Address addAddress(Address address) {
		return this.dao.save(address);
	}

	public Address updateAddressById(Address address, int id) {
		return this.dao.save(address);
	}

	public boolean removeAddress(int addressId) {
		this.dao.deleteById(addressId);

		if (dao.findById(addressId) != null) {
			return false;
		}
		return true;
	}

	public List<Address> viewAllAddresses() {
		return this.dao.findAll();
	}
	
	public Address viewByAddressById(int addressId) {
		Optional<Address> optional = this.dao.findById(addressId);
		if (optional.isPresent())
		return optional.get();
		return null;
		}

}