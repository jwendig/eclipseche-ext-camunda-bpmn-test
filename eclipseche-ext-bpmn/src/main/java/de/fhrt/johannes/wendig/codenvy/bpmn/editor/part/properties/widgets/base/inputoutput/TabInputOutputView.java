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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.inputoutput;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;

public class TabInputOutputView extends AbstractBpmnPropertiesTabWidget {
	private TableInputParametersWidget tableInputParameters;

	// TODO: ...
	// private TableInputParametersWidget tableOutputParameters;

	public TabInputOutputView(String tabName,
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(tabName, delegate);
		Log.info(TabInputOutputView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabInputOutputView.class, "initContent");
		getGridTabContent().resize(2, 2);

		getGridTabContent().setText(0, 0, "Input Parameters:");
		getGridTabContent().setWidget(0, 1, tableInputParameters);

		getGridTabContent().setText(1, 0, "Output Parameters:");
		// TODO: ...
		// getGridTabContent().setWidget(1, 1, tableOutputParameters);
		getGridTabContent().setText(1, 1, "TODO");

	}

	@Override
	public void initContentElements() {
		Log.info(TabInputOutputView.class, "initContentElements");

		tableInputParameters = new TableInputParametersWidget(getDelegate());
		// TODO: ...
		// tableOutputParameters = new
		// TableInputParametersWidget(getDelegate());
	}

	public TableInputParametersWidget getTableInputParameters() {
		return tableInputParameters;
	}

	// TODO: generate getter for tableOutputP....

}
