/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_8;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.Order;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestTestConstants1_8;
import org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest;

public class OrderResource1_8Test extends BaseDelegatingResourceTest<OrderResource1_8, Order> {
	
	@Override
	public Order newObject() {
		return Context.getOrderService().getOrderByUuid(getUuidProperty());
	}
	
	@Override
	public String getDisplayProperty() {
		return "(NEW) ASPIRIN: 325.0 mg UNKNOWN 1/day x 7 days/week";
	}
	
	@Override
	public String getUuidProperty() {
		return RestTestConstants1_8.ORDER_UUID;
	}
	
	private void voidOneOrder() {
		Order order = Context.getOrderService().getOrderByUuid(RestTestConstants1_8.ORDER_UUID);
		order.setVoided(true);
		Context.getOrderService().saveOrder(order, null);
	}
	
}
