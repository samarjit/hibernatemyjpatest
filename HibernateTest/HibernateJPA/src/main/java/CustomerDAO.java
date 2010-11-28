import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CustomerDAO {
	//http://www.myhomepageindia.com/index.php/2009/04/02/jpa-hibernate-with-oracle-on-eclipse.html
	
	private static void setUpDatasource() {
		System.out.println("Setting datasource");
//		PoolingDataSource ds = new PoolingDataSource();
//		ds.setUniqueName("jdbc/processInstanceDS");
//		ds.setClassName("org.h2.jdbcx.JdbcDataSource");
//		ds.setMaxPoolSize(3);
//		ds.setAllowLocalTransactions(true);
//		ds.getDriverProperties().put("user", "sa");
//		ds.getDriverProperties().put("password", "sasa");
//		ds.getDriverProperties().put("URL", "jdbc:h2:file:/NotBackedUp/data/process-instance-db");
//		ds.init();
		
		//http://docs.codehaus.org/display/BTM/JdbcConfiguration
		//http://docs.codehaus.org/display/BTM/Hibernate13
		/*PoolingDataSource myDataSource = new PoolingDataSource();                                        
		myDataSource.setClassName("oracle.jdbc.xa.client.OracleXADataSource");                          
		myDataSource.setUniqueName("jdbc/processInstanceDS");                                                           
		myDataSource.setMaxPoolSize(5);                                                                 
		myDataSource.setAllowLocalTransactions(true);                                                   
		//myDataSource.setTestQuery("SELECT 1 FROM DUAL");                                                
		myDataSource.getDriverProperties().setProperty("user", "timesheet");                               
		myDataSource.getDriverProperties().setProperty("password", "timesheet");                           
		myDataSource.getDriverProperties().setProperty("URL", "jdbc:oracle:thin:@localhost:1521:XE");  
		myDataSource.init();*/
	}

	
	
    public Customer create(Customer newCustomer) {
    	
    	EntityManagerFactory emf =
    		Persistence.createEntityManagerFactory("customerManager");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	em.persist(newCustomer);
    	em.getTransaction().commit();
    	return newCustomer;
    }

    public static void main(String[] args){
    	//setUpDatasource() ;
    	Customer customer = new Customer();
    	customer.setCustomerName("Hibernate JPA Customer");
    	System.out.println("Customer id before creation:"
    			+ customer.getCustomerId());
    	CustomerDAO customerDAO = new CustomerDAO();
    	Customer persistedCustomer = customerDAO.create(customer);
    	System.out.println("Customer id after creation:"
    			+ persistedCustomer.getCustomerId());
    }
} 
