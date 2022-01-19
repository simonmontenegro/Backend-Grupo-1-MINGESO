package com.mingeso.backend;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



import com.mingeso.backend.models.Product;
import org.junit.jupiter.api.DisplayName;

import java.sql.Date;


public class ProductTest {

    //Test Data
    String str="2015-03-31";  
    Date date=Date.valueOf(str);
    Product dummy = new Product((long) 4, "dummy", date, false, 100, false);

    String retorno;
    @Test
    @DisplayName("test getName")
    void testGetName() {
        retorno = dummy.getName();
        assertEquals("dummy", retorno);
    }

    @Test
    @DisplayName("test setPrice")
    void testSetPrice() {
        dummy.setPrice(400);
        assertEquals(400, dummy.getPrice());
    }

    @Test
    @DisplayName("test setCategory")
    void testSetCategory() {
        dummy.setCategory(true);
        assertEquals(true, dummy.getCategory());
    }

/*
    @Test
    @DisplayName("test last id")
    void testLastId() {
        Long numero= (long) 4;
        //Query query =  Mockito.mock(Query.class);
        Connection conn = Mockito.mock(Connection.class);
        //Mockito.when(query.executeScalar(long.class)).thenReturn(numero);
        Mockito.when(conn.createQuery(anyString(),anyBoolean()).executeScalar(long.class)).thenReturn(numero);
        Long retorno = ProductRepository.lastCode();
        assertEquals(numero, retorno);
    }
*/
}