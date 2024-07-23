package id.co.technicaltest.datakendaraan.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.technicaltest.datakendaraan.entities.DataEntity;
import id.co.technicaltest.datakendaraan.globals.GlobalConstant;

@Repository
public interface DataRepo extends JpaRepository<DataEntity, Integer>, JpaSpecificationExecutor<DataEntity>{
    
}