package domain;

import java.math.BigDecimal;
import java.util.UUID;
//TODO NULL HANDLING
public class InvoiceEntry{
    private UUID entryId;
    private String productName;
    
    private BigDecimal quantity;
    private TaxRate taxRate;
    private BigDecimal unitPrice;

    private BigDecimal totalNetAmount;
    private BigDecimal totalGrossAmount;
    private BigDecimal taxAmount;

    //Empty constructor for frameworks
    public InvoiceEntry(){

    }
    //Parameterized constructor for logic
    public InvoiceEntry(String productName, BigDecimal quantity, BigDecimal unitPrice, TaxRate taxRate) {
    this.productName = productName;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
    this.taxRate = taxRate;
    recalculateEverything(); // Instantly calculates Net, Tax, and Gross!
    }

    public BigDecimal calculateTotalNetAmount(){

        totalNetAmount = this.quantity.multiply(this.unitPrice);
        return  totalNetAmount;

    }

    public BigDecimal calculateTaxAmount(BigDecimal totalNetAmount){

        this.taxAmount = totalNetAmount.multiply(this.taxRate.getRate());
        return taxAmount;

    }

    public BigDecimal calculateTotalGrossAmount(BigDecimal totalNetAmount, BigDecimal taxAmount){

        
        this.totalGrossAmount = totalNetAmount.add(taxAmount);
        return  totalGrossAmount;

    }

    

    public void recalculateEverything(){

        this.totalNetAmount = calculateTotalNetAmount();
        this.taxAmount = calculateTaxAmount(totalNetAmount);
        this.totalGrossAmount = calculateTotalGrossAmount(totalNetAmount, taxAmount);
        
    }


    public UUID getEntryId() {
    return entryId;
   }
 
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public TaxRate getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(TaxRate taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalNetAmount() {
        return totalNetAmount;
    }

    public BigDecimal getTotalGrossAmount() {
        return totalGrossAmount;
    }
    
    public BigDecimal getTaxAmount() {
        return taxAmount;
    }


   

}
