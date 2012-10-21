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
    st.setName("YouTube Video");
    st.setDescription("Widget for embedding a YouTube video and player in a page.");
    st.setFixed(false);
    st.setStructureType(Structure.STRUCTURE_TYPE_WIDGET);
    StructureFactory.saveStructure(st);
    
    Field field1 = new Field("Video Title", Field.FieldType.TEXT, Field.DataType.TEXT, st, true, true, true, 0, true, false, true);
    field1.setVelocityVarName("widgetTitle");
    FieldFactory.saveField(field1);

    Field field2 = new Field("Widget Usage", Field.FieldType.TEXT_AREA, Field.DataType.TEXT, st, false, false, true, 1, true, false, false);
    field2.setFieldContentlet("constant");
    FieldFactory.saveField(field2);

    Field field3 = new Field("Widget Code", Field.FieldType.HIDDEN, Field.DataType.TEXT, st, false, false, true, 2, true, false, false);
    field3.setFieldContentlet("constant");
    field3.setValues("#set($YTHeight = \"$playerHeight\")\n" +
    "#set($YTWidth = \"$playerWidth\")\n" +
    "#set($YTRelated = \"$showRelatedVideos\")\n" +
    "#set($YTBorder = \"$displayPlayerBorder\")\n" +
    "#set($YTCookies = \"$enableDelayedCookies\")\n" +
    "#set($YTColor1 = \"$gradientColor1\")\n" +
    "#set($YTColor2 = \"$gradientColor2\")\n" +
    "#set($YTClass = \"$divWrapperClass\")\n" +
    "#set($YTQuality = \"$videoQuality\")\n" +
    "#youtube(\"$youtubeVideoId\"");
    FieldFactory.saveField(field3);

    Field field4 = new Field("YouTube Video ID", Field.FieldType.TEXT, Field.DataType.TEXT, st, true, true, true, 3, true, false, false);
    FieldFactory.saveField(field4);

    Field field5 = new Field("Optional Parameters", Field.FieldType.LINE_DIVIDER, Field.DataType.SECTION_DIVIDER, st, false, false, false, 4, true, false, false);
    FieldFactory.saveField(field5);
    
    Field field6 = new Field("Video Quality", Field.FieldType.SELECT, Field.DataType.TEXT, st, true, false, false, 5, "Standard|STD\r\nHigh Quality|HQ\r\nHigh Definition|HD", "STD", "", true, false, false);
    FieldFactory.saveField(field6);

    Field field7 = new Field("Player Height", Field.FieldType.TEXT, Field.DataType.INTEGER, st, true, false, false, 6, "", "344", "[0-9]*", true, false, false);
    FieldFactory.saveField(field7);

    Field field8 = new Field("Player Width", Field.FieldType.TEXT, Field.DataType.INTEGER, st, true, false, false, 7, "", "425", "[0-9]*", true, false, false);
    FieldFactory.saveField(field8);

    Field field9 = new Field("Show Related Videos", Field.FieldType.RADIO, Field.DataType.BOOL, st, true, false, false, 8, "Yes|1\r\nNo|0", "1", "", true, false, false);
    FieldFactory.saveField(field9);

    Field field10 = new Field("Display Player Border", Field.FieldType.RADIO, Field.DataType.BOOL, st, true, false, false, 9, "Yes|1\r\nNo|0", "0", "", true, false, false);
    FieldFactory.saveField(field10);

    Field field11 = new Field("Enable Delayed Cookies", Field.FieldType.RADIO, Field.DataType.BOOL, st, true, false, false, 10, "Yes|1\r\nNo|0", "0", "", true, false, false);
    FieldFactory.saveField(field11);

    Field field12 = new Field("Gradient Color 1", Field.FieldType.TEXT, Field.DataType.TEXT, st, false, false, false, 11, "", "", "[a-fA-F0-9]{6}", true, false, false);
    FieldFactory.saveField(field12);

    Field field13 = new Field("Gradient Color 2", Field.FieldType.TEXT, Field.DataType.TEXT, st, false, false, false, 12, "", "", "[a-fA-F0-9]{6}", true, false, false);
    FieldFactory.saveField(field13);

    Field field14 = new Field("Div Wrapper Class", Field.FieldType.TEXT, Field.DataType.TEXT, st, true, false, false, 13, "", "youtube_video", "", true, false, false);
    FieldFactory.saveField(field14);
    
    return false;
  }

  public boolean redeploy(String version) {
    return false;
  }
}