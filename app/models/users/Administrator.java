package models.users;

import models.stock.*;

import java.util.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

@Entity
// This is a User of type admin
@DiscriminatorValue("admin")

// Administrator inherits from the User class
public class Administrator extends User{


    @OneToOne(mappedBy = "admin", cascade = CascadeType.ALL)
    private StockBasket stockbasket;

   @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
   private List<StockOrder> orders;
	

	public Administrator() {

	}

	public Administrator(String email, String role, String name, String password)
	{
		super(email, role, name, password);
	}


         public StockBasket getStockBasket() {
        return stockbasket;
    }

    public void setStockBasket(StockBasket stockbasket) {
        this.stockbasket = stockbasket;
    }

    public List<StockOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<StockOrder> orders) {
        this.orders = orders;
    }
	
} 
