package ie.version1.bootcamp.securitymanager.ironthrone;

import java.security.BasicPermission;

/**
 * Permission to the Iron Throne.
 * @author flofish
 */
public class IronThronePermission extends BasicPermission {

	private static final long serialVersionUID = 1L;

	public IronThronePermission(String name) {
		super(name);
	}

	public IronThronePermission(String name, String actions) {
		super(name, actions);
	}

}
