package com.HNM.copy.store_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HNM.copy.store_data.entity.Copy;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Long>{

}
