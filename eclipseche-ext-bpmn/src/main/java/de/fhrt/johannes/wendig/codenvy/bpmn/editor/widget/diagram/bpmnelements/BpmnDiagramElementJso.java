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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements;

import com.google.gwt.core.client.JsArray;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementExtensionJso.BpmnExtensionElementType;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.DefaultJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.ProcessJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.ScriptTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.ServiceTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.StartEventJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.TaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.UserTaskJso;

public class BpmnDiagramElementJso extends BpmnBaseElementJso implements
		DefaultJso, ProcessJso, UserTaskJso, ServiceTaskJso, ScriptTaskJso,
		TaskJso, StartEventJso {

	public enum BpmnElementType {
		DEFAULT("UNDEFINED"), PROCESS("bpmn:Process"), SCRIPT_TASK(
				"bpmn:ScriptTask"), SERVICE_TASK("bpmn:ServiceTask"), START_EVENT(
				"bpmn:StartEvent"), TASK("bpmn:Task"), USER_TASK(
				"bpmn:UserTask");

		private final String bpmnIoTypeDefinition;

		private BpmnElementType(final String bpmnIoTypeDefinition) {
			this.bpmnIoTypeDefinition = bpmnIoTypeDefinition;
		}

		@Override
		public String toString() {
			return bpmnIoTypeDefinition;
		}

		public static BpmnElementType findByBpmnIoTypeDefinition(
				String bpmnIoTypeDefinition) {
			for (BpmnElementType t : values()) {
				if (t.bpmnIoTypeDefinition.equals(bpmnIoTypeDefinition)) {
					return t;
				}
			}
			return DEFAULT;
		}
	}

	protected BpmnDiagramElementJso() {
	}

	/*
	 * functions for extension elements
	 */
	private final native BpmnDiagramElementExtensionJso addExt_elemenemt(
			String bpmnExtensionElementType)/*-{
											console.log("js-native: addExt_elemenemt");
											return $wnd.bpmnIo_fktAddElementExtension(this,
											bpmnExtensionElementType);
											}-*/;

	private final native JsArray<BpmnDiagramElementExtensionJso> getExt_elements(
			String bpmnExtensionElementType) /*-{
												console.log("js-native: getExt_executionListeners");
												if (!this.extensionElements) {
												console
												.log("js-native: getExt_executionListeners: no extensionElementsAvailable");
												return [];
												}

												return this.extensionElements.values.filter(function(e) {
												return e.$instanceOf(bpmnExtensionElementType);
												});
												}-*/;

	public final JsArray<BpmnDiagramElementExtensionJso> getExt_executionListeners() {
		JsArray<BpmnDiagramElementExtensionJso> extElements = getExt_elements(BpmnExtensionElementType.CAMUNDA_EXECUTION_LISTENER
				.toString());
		return extElements;
	}

	public final BpmnDiagramElementExtensionJso addExt_executionListener() {
		BpmnDiagramElementExtensionJso newExtElement = addExt_elemenemt(BpmnExtensionElementType.CAMUNDA_EXECUTION_LISTENER
				.toString());
		return newExtElement;
	}
}