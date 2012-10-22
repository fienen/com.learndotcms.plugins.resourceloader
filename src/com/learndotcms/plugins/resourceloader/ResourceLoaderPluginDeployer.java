package com.learndotcms.plugins.resourceloader;

import com.dotmarketing.cache.FieldsCache;
import com.dotmarketing.business.DotStateException;
import com.dotmarketing.exception.DotDataException;
import com.dotmarketing.exception.DotRuntimeException;
import com.dotmarketing.plugin.business.PluginAPI;
import com.dotmarketing.plugin.business.PluginAPIImpl;
import com.dotmarketing.plugin.PluginDeployer;
import com.dotmarketing.portlets.structure.model.Field;
import com.dotmarketing.portlets.structure.model.Field.DataType;
import com.dotmarketing.portlets.structure.model.Field.FieldType;
import com.dotmarketing.portlets.structure.model.Structure;
import com.dotmarketing.portlets.structure.factories.FieldFactory;
import com.dotmarketing.portlets.structure.factories.StructureFactory;
import com.dotmarketing.util.Logger;

public class ResourceLoaderPluginDeployer implements PluginDeployer {
  public boolean deploy() {
  	String structureName = pluginAPI.loadProperty("com.learndotcms.plugins.resourceloader", "webResourceName");
  	String structureVarName = pluginAPI.loadProperty("com.learndotcms.plugins.resourceloader", "webResourceVarName");
    Structure st = new Structure();
    st.setName(structureName);
    st.setDescription("Common CSS/JS/VTL Files used for sharing and building templates.");
    st.setFixed(false);
    st.setSystem(false);
    st.setStructureType(Structure.STRUCTURE_TYPE_FILEASSET);
    st.setVelocityVarName(structureVarName);
	try {
		StructureFactory.saveStructure(st);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}
	
	Field field1 = new Field("Host or Folder", Field.FieldType.HOST_OR_FOLDER, Field.DataType.TEXT, st, true, false, true, 1, "", "", "", true, false, true);
	field1.setVelocityVarName("hostFolder");
	try {
		FieldFactory.saveField(field1);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}
	
	Field field2 = new Field("File Asset", Field.FieldType.BINARY, Field.DataType.BINARY, st, true, false, false, 2, "", "", "", true, false, false);
	field2.setVelocityVarName("fileAsset");
	try {
		FieldFactory.saveField(field2);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}
	
	Field field3 = new Field("External Link (CDN)", Field.FieldType.TEXT, Field.DataType.TEXT, st, false, false, false, 3, "", "", "", false, false, false);
	field3.setVelocityVarName("cdn");
    try {
		FieldFactory.saveField(field3);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}
	
	Field field4 = new Field("Title", Field.FieldType.TEXT, Field.DataType.TEXT, st, true, false, true, 4, "", "", "", true, false, true);
	field4.setVelocityVarName("title");
	try {
		FieldFactory.saveField(field4);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}

	Field field5 = new Field("File Name", Field.FieldType.TEXT, Field.DataType.TEXT, st, false, true, true, 5, "", "", "", true, true, true);
	field5.setVelocityVarName("fileName");
	try {
		FieldFactory.saveField(field5);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}
	
	Field field6 = new Field("Resource ID", Field.FieldType.TEXT, Field.DataType.TEXT, st, false, true, true, 6, "", "", "[0-9a-zA-Z-,]*", false, false, true);
	field6.setVelocityVarName("resourceId");
	try {
		FieldFactory.saveField(field6);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}
	
	Field field7 = new Field("Default Source", Field.FieldType.RADIO, Field.DataType.TEXT, st, false, true, true, 7, "Local|local\r\nExternal/CDN|cdn", "local", "", false, false, true);
	field7.setVelocityVarName("source");
 	try {
		FieldFactory.saveField(field7);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}
	
	Field field8 = new Field("Additional Code", Field.FieldType.TEXT_AREA, Field.DataType.TEXT, st, false, false, false, 8, "", "", "", false, false, true);
	field8.setVelocityVarName("code");
    try {
		FieldFactory.saveField(field8);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}

	Field field9 = new Field("Metadata", Field.FieldType.TAB_DIVIDER, Field.DataType.SECTION_DIVIDER, st, false, false, false, 9, "", "", "", false, false, false);
	field9.setVelocityVarName("MetadataTab");
	try {
		FieldFactory.saveField(field9);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}

	Field field10 = new Field("Metadata", Field.FieldType.KEY_VALUE, Field.DataType.LONG_TEXT, st, false, false, false, 10, "", "", "", true, true, true);
	field10.setVelocityVarName("metaData");
	try {
		FieldFactory.saveField(field10);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}

	Field field11 = new Field("Show On Menu", Field.FieldType.CHECKBOX, Field.DataType.TEXT, st, false, false, true, 11, "|true", "false", "", true, false, false);
	field11.setVelocityVarName("showOnMenu");
	try {
		FieldFactory.saveField(field11);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}

	Field field12 = new Field("Sort Order", Field.FieldType.TEXT, Field.DataType.INTEGER, st, false, false, true, 12, "", "0", "", true, false, false);
	field12.setVelocityVarName("sortOrder");
		try {
		FieldFactory.saveField(field12);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}

	Field field13 = new Field("Description", Field.FieldType.TEXT, Field.DataType.TEXT, st, false, false, true, 13, "", "", "", true, false, false);
	field13.setVelocityVarName("Description");
		try {
		FieldFactory.saveField(field13);
	} catch (Exception e) {
		Logger.error(this.getClass(), e.getMessage(), e);
		throw new DotRuntimeException(e.getMessage(), e);
	}

	FieldsCache.clearCache();
    
    return true;
  }

  public boolean redeploy(String version) {
    return true;
  }
}