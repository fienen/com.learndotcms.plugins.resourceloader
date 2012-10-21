package com.learndotcms.plugins.resourceloader;

import com.dotmarketing.plugin.PluginDeployer;
import com.dotmarketing.portlets.structure.model.Field;
import com.dotmarketing.portlets.structure.model.Field.DataType;
import com.dotmarketing.portlets.structure.model.Field.FieldType;
import com.dotmarketing.portlets.structure.model.Structure;
import com.dotmarketing.portlets.structure.factories.FieldFactory;
import com.dotmarketing.portlets.structure.factories.StructureFactory;

public class ResourceLoaderPluginDeployer implements PluginDeployer {
  public boolean deploy() {
    Structure st = new Structure();
    st.setName("Web Resource");
    st.setDescription("Common CSS/JS/VTL Files used for sharing and building templates.");
    st.setFixed(false);
    st.setStructureType(Structure.STRUCTURE_TYPE_FILEASSET);
    StructureFactory.saveStructure(st);
	
	Field field1 = new Field(HOST_FOLDER_FIELD_NAME, Field.FieldType.HOST_OR_FOLDER, Field.DataType.TEXT, st, true, false, true, 1, "", "", "", true, false, true);
	field1.setVelocityVarName(HOST_FOLDER_FIELD);
	FieldFactory.saveField(field1);
	
	field2 = new Field(BINARY_FIELD_NAME, Field.FieldType.BINARY, Field.DataType.BINARY, st, true, false, false, 2, "", "", "", true, false, false);
	field2.setVelocityVarName(BINARY_FIELD);
	FieldFactory.saveField(field2);
	
	Field field3 = new Field("External Link (CDN)", Field.FieldType.TEXT, Field.DataType.TEXT, st, false, false, false, 3, "", "", "", false, false, false);
	field3.setVelocityVarName("cdn");
    FieldFactory.saveField(field3);
	
	field4 = new Field(TITLE_FIELD_NAME, Field.FieldType.TEXT, Field.DataType.TEXT, st, true, true, true, 4, "", "", "", true, false, true);
	field4.setVelocityVarName(TITLE_FIELD);
	field4.setListed(false);
	FieldFactory.saveField(field4);

	field5 = new Field(FILE_NAME_FIELD_NAME, Field.FieldType.TEXT, Field.DataType.TEXT, st, false, true, true, 5, "", "", "", true, true, true);
	field5.setVelocityVarName(FILE_NAME_FIELD);
	FieldFactory.saveField(field5);
	
	Field field6 = new Field("Resource ID", Field.FieldType.TEXT, Field.DataType.TEXT, st, false, true, true, 6, "", "", "[0-9a-zA-Z-,]*", false, false, true);
	field6.setVelocityVarName("resourceId");
    FieldFactory.saveField(field6);
	
	Field field7 = new Field("Default Source", Field.FieldType.RADIO, Field.DataType.TEXT, st, false, true, true, 7, "Local|local\r\nExternal/CDN|cdn", "local", "", false, false, true);
	field7.setVelocityVarName("source");
    FieldFactory.saveField(field7);
	
	Field field8 = new Field("Additional Code", Field.FieldType.TEXT_AREA, Field.DataType.TEXT, st, false, false, false, 8, "", "", "", false, false, true);
	field8.setVelocityVarName("code");
    FieldFactory.saveField(field8);

	field9 = new Field(META_DATA_TAB_NAME, Field.FieldType.TAB_DIVIDER, Field.DataType.SECTION_DIVIDER, st, false, false, false, 9, "", "", "", false, false, false);
	field9.setVelocityVarName("MetadataTab");
	FieldFactory.saveField(field9);

	field10 = new Field(META_DATA_FIELD_NAME, Field.FieldType.KEY_VALUE, Field.DataType.LONG_TEXT, st, false, false, false, 10, "", "", "", true, true, true);
	field10.setVelocityVarName(META_DATA_FIELD);
	FieldFactory.saveField(field10);

	field11 = new Field(SHOW_ON_MENU_NAME, Field.FieldType.CHECKBOX, Field.DataType.TEXT, st, false, false, true, 11, "|true", "false", "", true, false, false);
	field11.setVelocityVarName(SHOW_ON_MENU);
	FieldFactory.saveField(field11);

	field12 = new Field(SORT_ORDER_NAME, Field.FieldType.TEXT, Field.DataType.INTEGER, st, false, false, true, 12, "", "0", "", true, false, false);
	field12.setVelocityVarName(SORT_ORDER);
	FieldFactory.saveField(field12);

	field13 = new Field(DESCRIPTION_NAME, Field.FieldType.TEXT, Field.DataType.TEXT, st, false, false, true, 13, "", "", "", true, false, false);
	field13.setVelocityVarName(DESCRIPTION);
	FieldFactory.saveField(field13);

	FieldsCache.clearCache();
    
    return false;
  }

  public boolean redeploy(String version) {
    return false;
  }
}