package com.asg.cxiom.repository;

import com.asg.cxiom.entity.MobileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MobileRepository extends CrudRepository<MobileEntity, Long> {

    @SuppressWarnings("JpaQlInspection")
    @Query(value = "select * from MOBILE_PHONES m where m.RELEASEPRICEEUR = :eurPrice", nativeQuery = true)
    List<MobileEntity> findMobileEntityByPrice(String eurPrice);

    @SuppressWarnings("JpaQlInspection")
    @Query(value = "SELECT * FROM MOBILE_PHONES m WHERE m.SIM like %:sim%", nativeQuery = true)
    List<MobileEntity> findMobileEntityBySIM(String sim);

    @SuppressWarnings("JpaQlInspection")
    @Query(value = "SELECT * FROM MOBILE_PHONES m WHERE m.RELEASEANNOUNCEDATE = :announceDate AND m.RELEASEPRICEEUR = :price", nativeQuery = true)
    List<MobileEntity> findMobileEntityByReleaseAnnounceDateByPrice(String announceDate, String price);


}
