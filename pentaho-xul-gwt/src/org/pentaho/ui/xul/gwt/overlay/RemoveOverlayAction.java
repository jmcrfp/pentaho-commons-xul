package org.pentaho.ui.xul.gwt.overlay;

import org.pentaho.ui.xul.dom.Element;
import org.pentaho.ui.xul.gwt.AbstractGwtXulComponent;

/**
 * User: nbaker
 * Date: 10/12/11
 */
public class RemoveOverlayAction implements IOverlayAction {

  private Element element;
  private Element parent;
  private int oldPos;

  public RemoveOverlayAction(Element element){
    this.element = element;
    this.parent = element.getParent();
  }
  public void perform() {
    oldPos = parent.getChildNodes().indexOf(element);
    parent.removeChild(element);
    ((AbstractGwtXulComponent) parent).layout();
  }

  public void remove() {
    parent.addChildAt(element, oldPos);
    ((AbstractGwtXulComponent) parent).layout();
  }
}
