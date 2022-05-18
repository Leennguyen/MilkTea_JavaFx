package com.example.milkteaproject;

import com.example.milkteaproject.models.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Manager {
    private Connection con;
    public Manager() {
        con = new DbConnect().getConnection();
    }

    public ArrayList<Product> getProductList() {
        var list = new ArrayList<Product>();
        try {
            var results = con.prepareStatement("SELECT * FROM products").executeQuery();
            while (results.next()) {
                list.add(new Product(
                        results.getString("proID"),
                        results.getString("productName"),
                        results.getFloat("price"),
                        results.getString("img")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    public boolean createProduct(Product product) {
        try {
            var sql = con.prepareStatement("INSERT INTO products VALUES (?, ?, ? ,?)");
            sql.setString(1, product.getId());
            sql.setString(2, product.getName());
            sql.setFloat(3, product.getPrice());
            sql.setString(4, product.getImg());

            sql.executeQuery();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}
