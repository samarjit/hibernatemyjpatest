import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SequenceGenerator(
	    name="SEQ_CUST",
	    sequenceName="TAB_CUSTOMER_SEQ"
	)

@Entity
@Table(name="TAB_CUSTOMER")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CUST")
    @Column(name="CUSTOMER_ID", precision=0)
    private Long customerId = null;

    @Column(name="CUSTOMER_NAME")
    private String customerName;

    public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String aCustomerName) {
		this.customerName = aCustomerName;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public boolean equals(Object candidate) {
        if (candidate == this) {
            return true;
        }
        if (candidate instanceof Customer) {
            if ((this.getCustomerName() != null && ((Customer)candidate).getCustomerName() != null)) {
            	return (this.getCustomerId()==(((Customer)candidate).getCustomerId())&&
                 this.getCustomerName().equals(((Customer)candidate).getCustomerName()));
            }
        }
        return false;
    }

     public int hashCode() {
    	 return this.getCustomerId().intValue();
    }

}
