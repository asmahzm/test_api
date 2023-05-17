package com.test.repositories;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.entities.CustomersTable;

@Transactional
@Repository
public interface CustomersRepository extends JpaRepository<CustomersTable, String> {

	@Query(value = "SELECT * FROM customers", nativeQuery = true)
	List<Map<String, Object>> getAllDataCustomers();
	
	@Query(value = "SELECT * FROM customers WHERE id = ?1", nativeQuery = true)
	Map<String, Object> getDataCustomerById(String id);
	
	@Modifying
	@Query(value = "INSERT INTO customers(id, name, email, phone) VALUES(?1, ?2, ?3, ?4)", nativeQuery = true)
	int insertDataCustomer(String id, String name, String email, String phone);
	
	@Modifying
	@Query(value = "UPDATE customers SET name = ?1, email = ?2, phone = ?3 WHERE id = ?4", nativeQuery = true)
	int updateDataCustomer(String name, String email, String phone, String id);
	
	@Modifying
	@Query(value = "DELETE FROM customers WHERE id = ?1", nativeQuery = true)
	int deleteDataCustomer(String id);
}
