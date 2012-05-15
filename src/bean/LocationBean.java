package bean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import fr.epsi.location.pojo.Client;
import fr.epsi.location.remote.ILocation;

public class LocationBean {

	private static LocationBean instance;
	private ILocation locationBean;
	public static final String DEFAULT_JNDI_NAME = "LocationBean/remote";
	
	public LocationBean() {
		getBean();
	}

	public static LocationBean getInstance() {
        if (null == instance) 
            instance = new LocationBean();
        
        return instance;
    }
	
	private void getBean() {
		try{
			System.setProperty("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
		    System.setProperty(" java.naming.factory.url.pkgs"," org.jboss.naming.org.jnp.interfaces");
		    System.setProperty("java.naming.provider.url", "localhost:1099");
		    
			Context context;
			context = new InitialContext();
			Object obj= context.lookup(DEFAULT_JNDI_NAME);
			locationBean = (ILocation)PortableRemoteObject.narrow(obj, ILocation.class);
		} catch(ClassCastException cce) {
			cce.printStackTrace();
		} catch(NamingException ne) {
			ne.printStackTrace();
		}
	}
	
	public Client getClientParIdentifiants(String login, String mdp) {
		return locationBean.getClientParIdentifiants(login, mdp);
	}
}
