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
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnDataTableWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.InputParameterJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.ListValueJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.MapEntryJso;

public class EditInputParameterTableMapWidget extends
		AbstractBpmnDataTableWidget<MapEntryJso> {

	private Column<MapEntryJso, String> tcKey;
	private Column<MapEntryJso, String> tcValue;
	private Column<MapEntryJso, String> tcBtnRemove;
	private Button btnAdd;

	private InputParameterJso currentInputParameterJso;

	public EditInputParameterTableMapWidget(
			BpmnElementPropertiesView.ActionDelegate delegate,
			InputParameterJso currentInputParameterJso) {
		super(delegate);
		Log.info(EditInputParameterTableMapWidget.class, "constructor");
		this.currentInputParameterJso = currentInputParameterJso;

		tcKey = new Column<MapEntryJso, String>(new EditTextCell()) {

			@Override
			public String getValue(MapEntryJso object) {
				if (null == object.getAttr_key()) {
					return "";
				}
				return object.getAttr_value();
			}
		};

		tcKey.setFieldUpdater(new FieldUpdater<MapEntryJso, String>() {

			public void update(int index, final MapEntryJso object,
					final String value) {
				object.setAttr_key(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcValue = new Column<MapEntryJso, String>(new EditTextCell()) {

			@Override
			public String getValue(MapEntryJso object) {
				if (null == object.getAttr_value()) {
					return "";
				}
				return object.getAttr_value();
			}
		};

		tcValue.setFieldUpdater(new FieldUpdater<MapEntryJso, String>() {

			public void update(int index, final MapEntryJso object,
					final String value) {
				object.setAttr_value(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcBtnRemove = new Column<MapEntryJso, String>(new ButtonCell()) {
			@Override
			public String getValue(MapEntryJso object) {
				return "x";
			}
		};

		tcBtnRemove.setFieldUpdater(new FieldUpdater<MapEntryJso, String>() {

			@Override
			public void update(int index, MapEntryJso object, String value) {
				if (EditInputParameterTableMapWidget.this.currentInputParameterJso
						.removeMapEntry(object)) {
					getDataProvider().getList().remove(object);
					getDataProvider().refresh();
					getTable().redraw();
					getDelegate().onContentChange();
				} else {

				}
			}
		});

		getTable().addColumn(tcKey, "Key");
		getTable().addColumn(tcValue, "Value");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MapEntryJso newDataObject = EditInputParameterTableMapWidget.this.currentInputParameterJso
						.addMapEntry(getDelegate().getCurrentBpmnIoModelerJso()
								.nativeGetModdle());

				getDataProvider().getList().add(newDataObject);
				getDataProvider().refresh();
				getTable().redraw();
				getDelegate().onContentChange();
			}
		});

		getButtonPanel().add(btnAdd);

		update();
	}

	@Override
	public void update() {
		getDataProvider().getList().clear();
		getDataProvider().getList().addAll(
				currentInputParameterJso.getMapEntries());
	}

	public void setCurrentListJso(InputParameterJso currentInputParameterJso) {
		this.currentInputParameterJso = currentInputParameterJso;
	}

}
