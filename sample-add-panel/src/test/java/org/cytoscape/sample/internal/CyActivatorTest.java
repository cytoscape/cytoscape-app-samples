package org.cytoscape.sample.internal; 

import static org.junit.Assert.assertNotNull;

import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.service.util.internal.FakeBundleContext;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;

public final class CyActivatorTest {

    private CyActivator cyActivator;
    private BundleContext bundleContext;

    @Before
    public void setUp() {
		// 
		// FakeBundleContext is provided by the service-api test-jar and
		// will create mock services for each Class specified in the
		// constructor.  Other services can be added using the registerService
		// method, like you'd use a normal BundleContext!
		//
		bundleContext = new FakeBundleContext(CySwingApplication.class);
        cyActivator = new CyActivator();
    }

    @Test
    public void testConstructor() {
        assertNotNull(cyActivator);
    }

    @Test(expected=RuntimeException.class)
    public void testStartNullBundleContext() {
        cyActivator.start(null);
    }

    @Test
    public void testStart() {
        cyActivator.start(bundleContext);
    }
}
