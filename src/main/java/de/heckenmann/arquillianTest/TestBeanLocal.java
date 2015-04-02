package de.heckenmann.arquillianTest;

import javax.ejb.Local;

/**
 * @author heckenmann.de
 */
@Local
public interface TestBeanLocal {

	public String getString(String s);
}
