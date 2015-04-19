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

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ScrollPanel;

public abstract class AbstractBpmnPropertiesTabView extends Composite {

	private String tabName = "Document";
	private Grid gridTabContent;

	public AbstractBpmnPropertiesTabView(String tabName) {
		super();
		this.tabName = tabName;

		gridTabContent = new Grid();
		gridTabContent.setSize("100%", "100%");

		initContentElements();
		initContent();

		initWidget(gridTabContent);
	}

	/*
	 * abstract functions
	 */
	public void initContentElements() {
	}

	public void initContent() {
	}

	public String getTabName() {
		return tabName;
	}

	/*
	 * getter & setter
	 */

	public Grid getGridTabContent() {
		return gridTabContent;
	}

	public void setGridTabContent(Grid content) {
		this.gridTabContent = content;
	}
}
