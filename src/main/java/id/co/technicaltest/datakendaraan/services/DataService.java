package id.co.technicaltest.datakendaraan.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.technicaltest.datakendaraan.entities.DataEntity;
import id.co.technicaltest.datakendaraan.exceptions.ClientException;
import id.co.technicaltest.datakendaraan.exceptions.NotFoundException;
import id.co.technicaltest.datakendaraan.globals.GlobalConstant;
import id.co.technicaltest.datakendaraan.models.DataModel;
import id.co.technicaltest.datakendaraan.repos.DataRepo;
import id.co.technicaltest.datakendaraan.repos.specs.DataSpec;
import id.co.technicaltest.datakendaraan.services.DataService;
import id.co.technicaltest.datakendaraan.validators.DataValidator;


@Service
public class DataService implements Serializable{
    @Autowired
    private DataRepo dataRepo;

    DataValidator dataValidator = new DataValidator();

    public DataEntity add(DataModel dataModel) throws ClientException{

        DataEntity data = new DataEntity();
        data.setNomorRegistrasiKendaraan(dataModel.getNomorRegistrasiKendaraan());
        data.setNamaPemilik(dataModel.getNamaPemilik());
        data.setAlamat(dataModel.getAlamat());
        data.setMerkKendaraan(dataModel.getMerkKendaraan());
        data.setTahunPembuatan(dataModel.getTahunPembuatan());
        data.setKapasitasSilinder(dataModel.getKapasitasSilinder());
        data.setWarnaKendaraan(dataModel.getWarnaKendaraan());
        data.setBahanBakar(dataModel.getBahanBakar()); 
        
        return dataRepo.save(data);  
    }

    public List<DataEntity> findAll(){
            List<DataEntity> data = new ArrayList<>();
            dataRepo.findAll().forEach(data::add);
            return data;
        }
        
    public List<DataEntity> findAllByCriteria(DataModel dataModel) throws ClientException, NotFoundException{
        DataSpec specs = new DataSpec(dataModel); // Assuming DataSpec is your custom Specification class
        return dataRepo.findAll(specs);
    }
        
    public DataEntity findById(Integer id) throws ClientException, NotFoundException{
            DataEntity data = dataRepo.findById(id).orElse(null);
            return data;
        }

    
    public DataEntity edit(Integer id, DataModel dataModel)throws ClientException, NotFoundException {
        
        if (!dataRepo.existsById(id)){
            throw new NotFoundException(
                "Cannot find data with id " + id);
            }

            DataEntity data = dataRepo.findById(id).orElse(null);
            if (data == null) {
            throw new NotFoundException("Data with id " + id + " not found");
            }

            if(dataModel.getNomorRegistrasiKendaraan() != null){
                data.setNomorRegistrasiKendaraan(dataModel.getNomorRegistrasiKendaraan());
            }

            return dataRepo.save(data);
        }

    public DataEntity delete(Integer id)throws ClientException, NotFoundException{

        DataEntity dataEntity = dataRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Data with ID " + id + " not found"));
        dataRepo.delete(dataEntity);
        

        return dataEntity;
        }
}



