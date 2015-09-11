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

package de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.FormFieldJso;

public interface StartEventJso extends DefaultJso {
	public boolean getAttr_asyncAfter();

	public void setAttr_asyncAfter(boolean asyncAfter);

	public boolean getAttr_asyncBefore();

	public void setAttr_asyncBefore(boolean asyncBefore);

	public boolean getAttr_exclusive();

	public void setAttr_exclusive(boolean exclusive);

	public String getAttr_formHandlerClass();

	public void setAttr_formHandlerClass(String formHandlerClass);

	public String getAttr_formKey();

	public void setAttr_formKey(String formKey);

	public String getAttr_initiator();

	public void setAttr_initiator(String initiator);
	
	public List<FormFieldJso> getCamundaExt_formField();
	
	public FormFieldJso addCamundaExt_formField(JavaScriptObject moddle);
	
	public boolean removeCamundaExt_formField(FormFieldJso element);
}