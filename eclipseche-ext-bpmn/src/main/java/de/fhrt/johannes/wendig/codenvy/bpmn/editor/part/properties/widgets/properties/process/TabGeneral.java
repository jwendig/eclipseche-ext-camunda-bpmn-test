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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.properties.process;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.BaseBpmnPropertiesTab;

public class TabGeneral extends BaseBpmnPropertiesTab {

	private final static String TAB_NAME = "General";

	private TextBox tbProcessId;
	private TextBox tbName;
	private CheckBox cbIsExecutable;
	private CellTable<String> ctDataObjects;
	private TextBox tbDocumentation;

	public TabGeneral() {
		super();

		initContentElements();
		initContent();
	}

	// @Override
	public void initContent() {
		getTabContent().resize(5, 2);

		getTabContent().setText(0, 0, "Process Id:");
		getTabContent().setText(1, 0, "Name:");
		getTabContent().setText(2, 0, "Is Executable:");
		getTabContent().setText(3, 0, "Data Objects:");
		getTabContent().setText(4, 0, "Documentation:");

		getTabContent().setWidget(0, 1, tbProcessId);
		getTabContent().setWidget(1, 1, tbName);
		getTabContent().setWidget(2, 1, cbIsExecutable);
		getTabContent().setWidget(3, 1, ctDataObjects);
		getTabContent().setWidget(4, 1, tbDocumentation);
	}

	// @Override
	public void initContentElements() {
		tbProcessId = new TextBox();
		tbName = new TextBox();
		cbIsExecutable = new CheckBox();
		ctDataObjects = new CellTable<String>();
		tbDocumentation = new TextBox();
	}

	@Override
	public String getTabName() {
		return TAB_NAME;
	}
}
