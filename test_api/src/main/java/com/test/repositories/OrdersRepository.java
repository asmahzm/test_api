package com.test.repositories;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.entities.OrdersTable;

@Transactional
@Repository
public interface OrdersRepository extends JpaRepository<OrdersTable, String> {

	@Query(value = "SELECT * FROM orders", nativeQuery = true)
	List<Map<String, Object>> getAllDataOrders();
	
	@Query(value = "SELECT * FROM orders WHERE id = ?1", nativeQuery = true)
	Map<String, Object> getDataOrderById(String id);
	
	@Modifying
	@Query(value = "INSERT INTO orders(id, customer_id, total_price, create_at) VALUES(?1, ?2, ?3, ?4)", nativeQuery = true)
	int insertDataOrder(String id, String customer_id, String total_price, String create_at);
	
	@Modifying
	@Query(value = "UPDATE orders SET customer_id = ?1, total_price = ?2, create_at = ?3 WHERE id = ?4", nativeQuery = true)
	int updateDataOrder(String customer_id, String total_price, String create_at, String id);
	
	@Modifying
	@Query(value = "DELETE FROM orders WHERE id = ?1", nativeQuery = true)
	int deleteDataOrder(String id);
}
