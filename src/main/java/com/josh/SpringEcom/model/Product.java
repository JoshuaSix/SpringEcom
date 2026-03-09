package com.josh.SpringEcom.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private String productDescription;
    private String productBrand;
    private BigDecimal productPrice;
    private String productCategory;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date productReleaseDate;
    private boolean productAvailable;
    private Integer productStock;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

    public void setStockQuantity(int i) {
    }
}
