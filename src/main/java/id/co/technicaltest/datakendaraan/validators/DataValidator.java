package id.co.technicaltest.datakendaraan.validators;

import id.co.technicaltest.datakendaraan.exceptions.ClientException;
import id.co.technicaltest.datakendaraan.exceptions.NotFoundException;
import id.co.technicaltest.datakendaraan.globals.GlobalConstant;

public class DataValidator {
    
    public void CheckTahunPembuatan(String tahunPembuatan) throws ClientException{
        Integer temp;
        temp = Integer.valueOf(tahunPembuatan);
        if (temp > 4 ){
            throw new ClientException("Karakter tahun pembuatan tidak boleh lebih dari 4 karakter");
        }
    }

    public void notnullCheck(String nomorRegistrasiKendaraan) throws ClientException{
        if (nomorRegistrasiKendaraan!= null){
            throw new ClientException("Product id is auto generated, do not input id");
        }
    }

    public void nullCheckName(String name) throws ClientException{
        if (name == null){
            throw new ClientException("Product name is required");
        }
    }

    public void nullCheckQuantity(Integer quantity) throws ClientException{
        if (quantity == null){
            throw new ClientException("Product quantity is required");
        }
    }

    public void nullCheckCategoryId(String categoryId) throws ClientException{
        if (categoryId == null){
            throw new ClientException("Product category id is required");
        }
    }

    public void nullCheckObject(Object o) throws NotFoundException{
        if (o == null){
            throw new NotFoundException("Product is not found");
        }
    }

    public void validateProductId(Integer id) throws ClientException {
        if (id <= 0){
            throw new ClientException("Product id input is invalid");
        }
    }


    public void validateName(String name) throws ClientException {
        if (name.trim().equalsIgnoreCase("")){
            throw new ClientException("Product name is required");
        }
    }

    public void validateQuantity(Integer quantity) throws ClientException {
        if (quantity < 0){
            throw new ClientException("Product quantity must be positive integer number");
        }
    }

    public void validateCategoryId(String categoryId) throws ClientException{
        if (categoryId.length() != 6 || !categoryId.startsWith("PC")) {
            throw new ClientException(
                    "Product category id contains six digits and starts with 'PC'");
        }
    }


}
