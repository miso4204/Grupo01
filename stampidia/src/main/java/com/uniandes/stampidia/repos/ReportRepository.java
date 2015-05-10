package com.uniandes.stampidia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uniandes.stampidia.model.StmpShirt;

public interface ReportRepository extends JpaRepository<StmpShirt, Integer>{
	
	@Query(value="select s.id_stamp,count(1) from stmp_order o, stmp_order_detail d, stmp_shirt s, stmp_user u where o.id = d.id_order and d.id_shirt = s.id and o.order_status = false and o.id_user = u.id and u.username = :username group by s.id_stamp",nativeQuery=true)
    List<Object[]> reportBySales(@Param("username") String username);
    
    @Query(value="select to_char(o.date,'Mon'), extract(year from o.date), SUM(o.totalAmount) from StmpOrder o, StmpUser u where o.orderStatus = false and o.idUser = u.id and u.username = :username group by 1,2 order by to_date(to_char(o.date,'Mon'),'Mon') ASC")
    List<Object[]> reportByPeriod(@Param("username") String username);
}
