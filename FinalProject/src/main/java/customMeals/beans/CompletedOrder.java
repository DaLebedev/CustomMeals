package customMeals.beans;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class CompletedOrder {

    @Id
    @GeneratedValue
    private Long id;

    private String completedOrderName;

    public CompletedOrder() {
    	super();
    }

    public CompletedOrder(String completedOrderName) {
        this.completedOrderName = completedOrderName;
    }
    
    public CompletedOrder(long id, String completedOrderName) {
    	this.id = id;
        this.completedOrderName = completedOrderName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompletedOrderName() {
        return completedOrderName;
    }

    public void setCompletedOrderName(String completedOrderName) {
        this.completedOrderName = completedOrderName;
    }

	@Override
	public String toString() {
		return "Completed Order [ID: " + id + " | Order Name: " + completedOrderName + "]";
	}
}
	
	

