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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties;

import org.eclipse.che.ide.api.parts.base.BasePresenter;
import org.eclipse.che.ide.util.loging.Log;
import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditorView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.noselection.NoSelectionWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.ProcessPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.servicetask.ServiceTaskPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.startevent.StartEventPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.unknown.UnknownItemWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.usertask.UserTaskPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso.BpmnElementType;

public class BpmnElementPropertiesPresenter extends BasePresenter implements
		BpmnElementPropertiesView.ActionDelegate, BpmnElementPropertiesCallback {

	private BpmnElementPropertiesView view;
	private final static String TITLE = "BPMN Properties";
	private BpmnDiagramElementJso currentElementJso;

	private UnknownItemWidget unknowItemProperties;
	private NoSelectionWidget noselectionProperties;

	private ProcessPropertiesWidget processProperties;
	private ServiceTaskPropertiesWidget serviceTaskProperties;
	private StartEventPropertiesWidget startEventProperties;
	private UserTaskPropertiesWidget userTaskProperties;

	private AbstractBpmnPropertiesWidget currentProperties;

	@Inject
	public BpmnElementPropertiesPresenter(BpmnElementPropertiesView view) {
		Log.info(BpmnElementPropertiesPresenter.class, "constructor");
		this.view = view;
		this.view.setDelegate(this);

		unknowItemProperties = new UnknownItemWidget(this);
		noselectionProperties = new NoSelectionWidget(this);

		processProperties = new ProcessPropertiesWidget(this);
		serviceTaskProperties = new ServiceTaskPropertiesWidget(this);
		startEventProperties = new StartEventPropertiesWidget(this);
		userTaskProperties = new UserTaskPropertiesWidget(this);

		currentProperties = noselectionProperties;
	}

	@Override
	public String getTitle() {
		return TITLE;
	}

	@Override
	public ImageResource getTitleImage() {
		return null;
	}

	@Override
	public IsWidget getTitleWidget() {
		return super.getTitleWidget();
	}

	@Override
	public SVGResource getTitleSVGImage() {
		return super.getTitleSVGImage();
	}

	@Override
	public String getTitleToolTip() {
		return TITLE;
	}

	@Override
	public void go(AcceptsOneWidget container) {
		Log.info(BpmnElementPropertiesPresenter.class, "go");
		container.setWidget(view);
	}

	@Override
	public void bpmnElementSelected(BpmnDiagramElementJso elementJso) {
		Log.info(BpmnElementPropertiesPresenter.class, "bpmnElementSelected");

		currentElementJso = elementJso;
		view.getDockLpCurrentContent().remove(currentProperties);
		if (null == elementJso) {
			currentProperties = noselectionProperties;
		} else {
			switch (BpmnElementType.findByBpmnIoTypeDefinition(elementJso
					.getType())) {
			case DEFAULT:
				currentProperties = unknowItemProperties;
				break;
			case PROCESS:
				currentProperties = processProperties;
				break;
			case SCRIPT_TASK:
				currentProperties = unknowItemProperties;
				break;
			case SERVICE_TASK:
				currentProperties = serviceTaskProperties;
				break;
			case START_EVENT:
				currentProperties = startEventProperties;
				break;
			case TASK:
				currentProperties = unknowItemProperties;
				break;
			case USER_TASK:
				currentProperties = userTaskProperties;
				break;
			default:
				currentProperties = unknowItemProperties;
			}
		}
		view.getDockLpCurrentContent().add(currentProperties);
		currentProperties.setSelectedItem(currentElementJso);
	}

	/*
	 * Callbacks from view
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.
	 * BpmnElementPropertiesView.ActionDelegate#getCurrentElementJso()
	 */
	@Override
	public BpmnDiagramElementJso getCurrentElementJso() {
		return currentElementJso;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.
	 * BpmnElementPropertiesView.ActionDelegate#onContentChange()
	 */
	@Override
	public void onContentChange() {
		Log.info(BpmnElementPropertiesPresenter.class, "onContentChange");
		jsUpdateEditor();
	}

	private native void jsUpdateEditor()/*-{
										$wnd.bpmnIo_fktExportArtifacts();
										}-*/;

}