package com.mingeso.backend.repositories;

import com.mingeso.backend.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository{
    @Autowired
    private Sql2o sql2o;

    // List all products
    @Override
    public List<Product> getAllProducts() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from product where delete=false")
                .executeAndFetch(Product.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Get product by code
    @Override
    public List<Product> getProductByCode(Long code){
        if(lastCode() < code){
            System.out.println("El código ingresado no existe.");
            return null;
        }
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from product where code = :code and delete=false")
                    .addParameter("code", code)
                    .executeAndFetch(Product.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Delete product by code
    @Override
    public Boolean deleteProduct(Long code){
        try(Connection con = sql2o.open()) {
            code = (Long) con.createQuery("UPDATE product SET delete = true WHERE code = :code and delete=false",true)
                .addParameter("code",code)
                .executeUpdate().getKey();
            return (code!=null);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return code==null;
        }
    }

    // Create product
    @Override
    public Product createProduct(Product ProductNew){
        Long codeNew=lastCode()+1;
        try(Connection conn=sql2o.open()){
        String sql="INSERT INTO product (code, name, expiration_date, category, price) values (:code, :name, :expiration_date, :category, :price)";
        Long insertedCode=conn.createQuery(sql,true)
        .addParameter("code",codeNew)
        .addParameter("name",ProductNew.getName())
        .addParameter("expiration_date",ProductNew.getExpiration_date())
        .addParameter("category",ProductNew.getCategory())
        .addParameter("price",ProductNew.getPrice())
        .executeUpdate().getKey(Long.class);
        ProductNew.setCode(insertedCode);
        ProductNew.setDelete(false);
        return ProductNew;
        }catch(Exception e){
        System.out.println(e.getMessage());
        return null;
        }
    }
    public Long lastCode(){
        Long lastCode;
        try(Connection conn = sql2o.open()){
            lastCode = Long.parseLong(String.valueOf(conn.createQuery("select max(product.code) from product", true)
            .executeScalar(long.class)));
            return lastCode;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }
}