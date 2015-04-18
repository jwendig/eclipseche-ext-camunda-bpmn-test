/*******************************************************************************
 * Copyright (c) 2012-2015 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;

public abstract class AbstractBpmnPropertiesTabController {
	private BpmnElementPropertiesView.ActionDelegate actionDelegate;

	public AbstractBpmnPropertiesTabController(
			BpmnElementPropertiesView.ActionDelegate actionDelegate) {
		this.actionDelegate = actionDelegate;
	}

	public BpmnElementPropertiesView.ActionDelegate getActionDelegate() {
		return actionDelegate;
	}

}
