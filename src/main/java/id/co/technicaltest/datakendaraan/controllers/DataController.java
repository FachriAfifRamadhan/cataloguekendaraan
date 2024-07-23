package id.co.technicaltest.datakendaraan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.technicaltest.datakendaraan.entities.DataEntity;
import id.co.technicaltest.datakendaraan.exceptions.ClientException;
import id.co.technicaltest.datakendaraan.exceptions.NotFoundException;
import id.co.technicaltest.datakendaraan.models.DataModel;
import id.co.technicaltest.datakendaraan.models.ResponseModel;
import id.co.technicaltest.datakendaraan.services.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/datakendaraan")
public class DataController {
    @Autowired
    private DataService dataService;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseModel> postDataController(
        @RequestBody DataModel dataModel){
            try{
                //request
                DataEntity data = dataService.add(dataModel);
                //response
                ResponseModel response = new ResponseModel();
                response.setData(data);
                return ResponseEntity.ok(response);
            }
            catch (ClientException e){
                ResponseModel response = new ResponseModel();
                response.setMsg(e.getMessage());
                return ResponseEntity.badRequest().body(response);
            }
            catch (Exception e) {
                ResponseModel response = new ResponseModel();
                response.setMsg("Sorry there is a failure on our server");
                e.printStackTrace();
                return ResponseEntity.internalServerError().body(response);
            }
        }
    @GetMapping(value = "/get")
    public ResponseEntity<ResponseModel> getAllDataController(){

        try{
            //request
            List<DataEntity> data = dataService.findAll();

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg("Request Successfully");
            response.setData(data);
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry there is a failure on our server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseModel> getProductByIdController(@PathVariable Integer id){

        try{
            DataEntity data = dataService.findById(id);

            ResponseModel response = new ResponseModel();
            response.setMsg("Request Successfully");
            response.setData(data);
            return ResponseEntity.ok(response);
        }catch (ClientException e){
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }catch(NotFoundException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry there is a failure on our server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PostMapping("/search")
    public ResponseEntity<ResponseModel> searchData(@RequestBody DataModel dataModel) {
        try {
            List<DataEntity> data = dataService.findAllByCriteria(dataModel);
            
            ResponseModel response = new ResponseModel();
            response.setMsg("Request Successful");
            response.setData(data);
            
            return ResponseEntity.ok(response);
        }catch (ClientException e){
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }catch(NotFoundException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry there is a failure on our server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseModel> putDataController(@PathVariable("id") Integer id,@RequestBody DataModel dataModel) {
        try{
            dataModel.setId(id);

            DataEntity updatedData = dataService.edit(id, dataModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Data with ID " + id + " is updated successfully");
            response.setData(updatedData);
        return ResponseEntity.ok(response);
        }catch (ClientException e){
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }catch(NotFoundException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry there is a failure on our server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseModel> deleteDataController(@PathVariable("id") Integer id){
        try{
            DataEntity data = dataService.delete(id);

            ResponseModel response = new ResponseModel();
            response.setMsg("Data Is Deleted Successfully");
            response.setData(data);
            return ResponseEntity.ok(response);
        }catch (ClientException e){
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }catch(NotFoundException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Sorry there is a failure on our server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
