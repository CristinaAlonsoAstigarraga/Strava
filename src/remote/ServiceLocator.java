package remote;

import java.rmi.Naming;

import remote.IFachadaRemota;

public class ServiceLocator {
	
	private IFachadaRemota service;
	
	public void setService(String ip, String puerto, String nombreService) {
		if(System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			String URL = "//" + ip + ":" + puerto + "/" + nombreService;
			this.service= (IFachadaRemota) Naming.lookup(URL);
			System.out.println(service);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("# Error localizando fachada remota" + e);
		}
	}
	
	public IFachadaRemota getService() {
		return this.service;
	}

}