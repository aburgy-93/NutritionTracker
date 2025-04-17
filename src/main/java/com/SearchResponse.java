package com;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Search response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponse {

    @JsonProperty("products")
    private List<Product> products;

    /**
     * Gets products.
     *
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets products.
     *
     * @param products the products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
