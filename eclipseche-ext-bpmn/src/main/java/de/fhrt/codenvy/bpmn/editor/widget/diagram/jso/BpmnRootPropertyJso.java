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
package de.fhrt.codenvy.bpmn.editor.widget.diagram.jso;

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.DataStoreJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.ErrorJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.MessageJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.SignalJso;

public class BpmnRootPropertyJso extends AbstractBpmnElementJso implements
		ErrorJso, DataStoreJso, SignalJso, MessageJso {

	public enum BpmnRootPropertyType {
		BPMN_ERROR("bpmn:Error"), BPMN_MESSAGE("bpmn:Message"), BPMN_SIGNAL(
				"bpmn:Signal"), BPMN_DATASTORE("bpmn:DataStore");

		private final String bpmnIoTypeDefinition;

		private BpmnRootPropertyType(final String bpmnIoTypeDefinition) {
			this.bpmnIoTypeDefinition = bpmnIoTypeDefinition;
		}

		@Override
		public String toString() {
			return bpmnIoTypeDefinition;
		}

		public static BpmnRootPropertyType findByBpmnIoTypeDefinition(
				String bpmnIoTypeDefinition) {
			for (BpmnRootPropertyType t : values()) {
				if (t.bpmnIoTypeDefinition.equals(bpmnIoTypeDefinition)) {
					return t;
				}
			}
			return null;
		}
	}

	protected BpmnRootPropertyJso() {
	}
}