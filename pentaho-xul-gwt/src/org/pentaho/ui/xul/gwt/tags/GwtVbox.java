package org.pentaho.ui.xul.gwt.tags;

import com.google.gwt.user.client.ui.VerticalPanel;
import org.pentaho.ui.xul.XulComponent;
import org.pentaho.ui.xul.containers.XulVbox;
import org.pentaho.ui.xul.dom.Element;
import org.pentaho.ui.xul.gwt.AbstractGwtXulContainer;
import org.pentaho.ui.xul.gwt.GwtXulHandler;
import org.pentaho.ui.xul.gwt.GwtXulParser;
import org.pentaho.ui.xul.gwt.util.GwtUIConst;
import org.pentaho.ui.xul.stereotype.Bindable;
import org.pentaho.ui.xul.util.Orient;

public class GwtVbox extends AbstractGwtXulContainer implements XulVbox {

  static final String ELEMENT_NAME = "vbox"; //$NON-NLS-1$


  private enum Property{
    PADDING
  }


  public static void register() {
    GwtXulParser.registerHandler(ELEMENT_NAME, 
    new GwtXulHandler() {
      public Element newInstance() {
        return new GwtVbox();
      }
    });
  }
  
  public GwtVbox() {
    this(ELEMENT_NAME);
  }

  @Override
  public void setAttribute(String name, String value) {
    super.setAttribute(name, value);
    try{
      Property prop = Property.valueOf(name.replace("pen:", "").toUpperCase());
      switch (prop) {
       case PADDING:
         setPadding(Integer.valueOf(value));
          break;
      }
    } catch(IllegalArgumentException e){
      System.out.println("Could not find Property in Enum for: "+name+" in class"+getClass().getName());
    }
  }
  
  public GwtVbox(String elementName) {
    super(elementName);
    this.orientation = Orient.VERTICAL;
    VerticalPanel vp;
    container = vp = new VerticalPanel();
    setManagedObject(container);
    vp.setSpacing(GwtUIConst.PANEL_SPACING);    // IE_6_FIX, move to CSS
    vp.setStyleName("vbox");  //$NON-NLS-1$
  }

  @Override
  @Bindable
  public void setSpacing(int spacing) {
    super.setSpacing(spacing);
    ((VerticalPanel) container).setSpacing(spacing);
  }

  @Override
  @Bindable
  public void setHeight(int height) {
    super.setHeight(height);
    container.setHeight(height+"px");
  }

  @Override
  @Bindable
  public void setWidth(int width) {
    super.setWidth(width);
    container.setWidth(width+"px");
  }
  @Override  
  public void setBgcolor(String bgcolor) {
    if(container != null) {
      container.getElement().getStyle().setProperty("backgroundColor", bgcolor);
    }
  }

}
