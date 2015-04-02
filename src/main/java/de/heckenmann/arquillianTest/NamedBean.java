package de.heckenmann.arquillianTest;

import javax.ejb.EJB;
import javax.inject.Named;

import org.jboss.logging.Logger;

/**
 * @author heckenmann.de
 */
@Named
public class NamedBean {

	private final Logger LOG = Logger.getLogger(NamedBean.class);

	@EJB
	private TestBeanLocal bean;

	public void log(final String s) {
		this.LOG.info(this.LOG);
	}

	/*
	 * GETTER & SETTER
	 */
	public TestBeanLocal getBean() {
		return this.bean;
	}

	public void setBean(final TestBeanLocal bean) {
		this.bean = bean;
	}
}
