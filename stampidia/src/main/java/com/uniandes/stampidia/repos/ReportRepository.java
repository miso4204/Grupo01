package com.uniandes.stampidia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uniandes.stampidia.model.StmpShirt;

public interface ReportRepository extends JpaRepository<StmpShirt, Integer>{
	
    @Query(value="select to_char(o.date,'Mon'), extract(year from o.date), SUM(o.totalAmount) from StmpOrder o, StmpUser u where o.orderStatus = false and o.idUser = u.id and u.username = :username group by 1,2 order by to_date(to_char(o.date,'Mon'),'Mon') ASC")
    List<Object[]> reportSalesByPeriod(@Param("username") String username);
    
    @Query(value="select to_char(o.date,'Mon'), extract(year from o.date), SUM(o.totalAmount) from StmpOrder o, StmpUser u where o.orderStatus = false and o.idUser = u.id and u.username = :username group by 1,2 order by to_date(to_char(o.date,'Mon'),'Mon') ASC")
    List<Object[]> reportSalesByArtist(@Param("username") String username);
    
    @Query(value="select avg(d.valoration) as rating, d.id_stamp from stmp_stamp_rating d,stmp_stamp s,stmp_user u where d.id_stamp = s.id and s.id_artist_user = u.id group by d.id_stamp",nativeQuery=true)
    List<Object[]> reportRatingDesigns();
    
    @Query(value="select avg(d.valoration) as rating, d.id_stamp from stmp_stamp_rating d,stmp_stamp s,stmp_user u where d.id_stamp = s.id and s.id_artist_user = u.id and u.username = :username group by d.id_stamp",nativeQuery=true)
    List<Object[]> reportRatingDesignsByArtist(@Param("username") String username);
}
