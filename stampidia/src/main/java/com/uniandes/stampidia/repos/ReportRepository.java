package com.uniandes.stampidia.repos;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniandes.stampidia.model.StmpShirt;

public interface ReportRepository extends CrudRepository<StmpShirt, Integer>{

	
//	@Query(value="select s.idStamp,count(1) from StmpOrder o, StmpOrderDetail d, StmpShirt s where o.id = d.idOrder and d.idShirt = s.id and o.orderStatus = false group by s.idStamp")
	@Query(value="select s.id_stamp,count(1) from stmp_order o, stmp_order_detail d, stmp_shirt s where o.id = d.id_order and d.id_shirt = s.id and o.order_status = false group by s.id_stamp",nativeQuery=true)
    List<Object[]> reportBySales();
    
    @Query(value="select to_char(o.date,'Mon'), extract(year from o.date), SUM(o.totalAmount) from StmpOrder o where o.orderStatus = false group by 1,2")
    List<Object[]> reportByPeriod();
}
