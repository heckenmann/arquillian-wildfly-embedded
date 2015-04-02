package de.heckenmann.arquillianTest;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author heckenmann.de
 */
@RunWith(Arquillian.class)
public class ArquillianTest {

	/**
	 * Erstellt ein Archiv mit den Klassen, die getestet werden sollen.
	 */
	@Deployment
	public static JavaArchive deploy() {
		return ShrinkWrap
				.create(JavaArchive.class, "test.jar")
				.addClasses(TestBeanLocal.class, TestBean.class,
						NamedBean.class)
						.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@EJB
	private TestBeanLocal bean;

	@Inject
	private NamedBean namedBean;

	/**
	 * Testet, ob TestBeanLocal null ist.
	 */
	@Test
	public void testEJBInjection() {
		Assert.assertNotNull(this.bean);
	}

	/**
	 * Testet Methodenaufruf auf Bean.
	 */
	@Test
	public void testeGetString() {
		final String s = "test";
		Assert.assertEquals(s, this.bean.getString(s));
	}

	/**
	 * Testet, ob die Named-Bean null ist.
	 */
	@Test
	public void testeCDI() {
		Assert.assertNotNull(this.namedBean);
		this.namedBean.log("test");
	}

	/**
	 * Testet, ob die TestBean in der Bean null ist.
	 */
	@Test
	public void testeEJBinCDI() {
		Assert.assertNotNull(this.namedBean.getBean());
	}
}
