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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process;

import org.eclipse.che.ide.util.loging.Log;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView.ActionDelegate;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.TabListenerController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.definitions.TabDefinitionsController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.document.TabDocumentController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.extensions.TabExtensionsController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.general.TabGeneralController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.ProcessJso;

public class ProcessPropertiesWidget extends AbstractBpmnPropertiesWidget {

	private final static String LB_ELEMENT_NAME_PREFIX = "Process";

	// private ProcessJso element;

	private TabGeneralController tabGeneralController;
	private TabDocumentController tabDocumentController;
	private TabDefinitionsController tabDefinitionsController;
	private TabListenerController tabListenerController;
	private TabExtensionsController tabExtensionsController;

	public ProcessPropertiesWidget(
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(LB_ELEMENT_NAME_PREFIX, delegate);
		Log.info(ProcessPropertiesWidget.class, "constructor");

		tabListenerController = new TabListenerController(delegate);
		tabDocumentController = new TabDocumentController(delegate);
		tabGeneralController = new TabGeneralController(delegate);
		tabDefinitionsController = new TabDefinitionsController(delegate);
		tabExtensionsController = new TabExtensionsController(delegate);

		getTabLpContent().add(tabGeneralController.getView(),
				tabGeneralController.getView().getTabName());
		getTabLpContent().add(tabDefinitionsController.getView(),
				tabDefinitionsController.getView().getTabName());
		getTabLpContent().add(tabDocumentController.getView(),
				tabDocumentController.getView().getTabName());
		getTabLpContent().add(tabListenerController.getView(),
				tabListenerController.getView().getTabName());
		getTabLpContent().add(tabExtensionsController.getView(),
				tabExtensionsController.getView().getTabName());

		getTabLpContent().selectTab(tabGeneralController.getView());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.
	 * AbstractBpmnProperties
	 * #initSelectedItem(de.fhrt.johannes.wendig.codenvy.bpmn
	 * .editor.widget.diagram.bpmnelements.BpmnDiagramElementJso)
	 */
	@Override
	public void updateTabs() {
		tabGeneralController.updateView();
		tabListenerController.updateView();
		tabDocumentController.updateView();
		tabDefinitionsController.updateView();
		tabExtensionsController.updateView();
	}
}
