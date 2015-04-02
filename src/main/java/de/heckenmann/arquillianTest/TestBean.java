package de.heckenmann.arquillianTest;

import java.io.Serializable;

import javax.ejb.Stateless;

/**
 * @author heckenmann.de
 */
@Stateless
public class TestBean implements TestBeanLocal, Serializable {

	private static final long serialVersionUID = 1L;

	public String getString(final String s) {
		return s;
	}
}
