
package com.tecnologico.model;

/**
 *
 * @author ronald.cuello
 */
public class Book {
    private String IsbnCode;
    private String name;
    private String Author;
    private float price;
    private String priceCurrency;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Author
     */
    public String getAuthor() {
        return Author;
    }

    /**
     * @param Author the Author to set
     */
    public void setAuthor(String Author) {
        this.Author = Author;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the priceCurrency
     */
    public String getPriceCurrency() {
        return priceCurrency;
    }

    /**
     * Establece cual es la moneda del precio, ejemplo COP para pesos colombianos, USD para dolares estadosunidenses
     * @param priceCurrency the priceCurrency to set
     */
    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    /**
     * @return the IsbnCode
     */
    public String getIsbnCode() {
        return IsbnCode;
    }

    /**
     * @param IsbnCode the IsbnCode to set
     */
    public void setIsbnCode(String IsbnCode) {
        this.IsbnCode = IsbnCode;
    }
    
    
}
