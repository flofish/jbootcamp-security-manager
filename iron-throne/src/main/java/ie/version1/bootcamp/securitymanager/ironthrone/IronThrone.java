package ie.version1.bootcamp.securitymanager.ironthrone;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * This class provides read and write access to the Iron Throne's file.
 * @author flofish
 */
public class IronThrone {

	/**
	 * Claims the Iron Throne, replacing previous name or creating the Iron Throne's file if it doesn't exist.
	 * @param name
	 */
	public void claim(String name) {
		Path ironThronePath = Paths.get(System.getProperty("user.home") + File.separator + ".ironThrone");
		AccessController.doPrivileged((PrivilegedAction<Path>)() -> {
			try {
				return Files.write(ironThronePath, name.getBytes());
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		});
	}

	/**
	 * @return Current occupant of the Iron Throne
	 * @throws IOException
	 */
	public String visit() throws IOException {		
		Path ironThronePath = Paths.get(System.getProperty("user.home") + File.separator + ".ironThrone");
		return new String(Files.readAllBytes(ironThronePath));
	}


}
