/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.tests;

/**
 *
 * @author MManolas
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class PanelDropTarget implements DropTargetListener {
  public PanelDropTarget(JPanel pane) {
    this.pane = pane;

    // Create the DropTarget and register
    // it with the JPanel.
    dropTarget = new DropTarget(pane, DnDConstants.ACTION_COPY_OR_MOVE,
        this, true, null);
  }

  // Implementation of the DropTargetListener interface
  public void dragEnter(DropTargetDragEvent dtde) {
    DnDUtils.debugPrintln("dragEnter, drop action = "
        + DnDUtils.showActions(dtde.getDropAction()));

    // Get the type of object being transferred and determine
    // whether it is appropriate.
    checkTransferType(dtde);

    // Accept or reject the drag.
    acceptOrRejectDrag(dtde);
  }

  public void dragExit(DropTargetEvent dte) {
    DnDUtils.debugPrintln("DropTarget dragExit");
  }

  public void dragOver(DropTargetDragEvent dtde) {
    DnDUtils.debugPrintln("DropTarget dragOver, drop action = "
        + DnDUtils.showActions(dtde.getDropAction()));

    // Accept or reject the drag
    acceptOrRejectDrag(dtde);
  }

  public void dropActionChanged(DropTargetDragEvent dtde) {
    DnDUtils.debugPrintln("DropTarget dropActionChanged, drop action = "
        + DnDUtils.showActions(dtde.getDropAction()));

    // Accept or reject the drag
    acceptOrRejectDrag(dtde);
  }

  public void drop(DropTargetDropEvent dtde) {
    DnDUtils.debugPrintln("DropTarget drop, drop action = "
        + DnDUtils.showActions(dtde.getDropAction()));

    // Check the drop action
    if ((dtde.getDropAction() & DnDConstants.ACTION_COPY_OR_MOVE) != 0) {
      // Accept the drop and get the transfer data
      dtde.acceptDrop(dtde.getDropAction());
      Transferable transferable = dtde.getTransferable();

      try {
        boolean result = dropComponent(transferable);

        dtde.dropComplete(result);
        DnDUtils.debugPrintln("Drop completed, success: " + result);
      } catch (Exception e) {
        DnDUtils.debugPrintln("Exception while handling drop " + e);
        dtde.dropComplete(false);
      }
    } else {
      DnDUtils.debugPrintln("Drop target rejected drop");
      dtde.rejectDrop();
    }
  }

  // Internal methods start here

  protected boolean acceptOrRejectDrag(DropTargetDragEvent dtde) {
    int dropAction = dtde.getDropAction();
    int sourceActions = dtde.getSourceActions();
    boolean acceptedDrag = false;

    DnDUtils.debugPrintln("\tSource actions are "
        + DnDUtils.showActions(sourceActions) + ", drop action is "
        + DnDUtils.showActions(dropAction));

    // Reject if the object being transferred
    // or the operations available are not acceptable.
    if (!acceptableType
        || (sourceActions & DnDConstants.ACTION_COPY_OR_MOVE) == 0) {
      DnDUtils.debugPrintln("Drop target rejecting drag");
      dtde.rejectDrag();
    } else if ((dropAction & DnDConstants.ACTION_COPY_OR_MOVE) == 0) {
      // Not offering copy or move - suggest a copy
      DnDUtils.debugPrintln("Drop target offering COPY");
      dtde.acceptDrag(DnDConstants.ACTION_COPY);
      acceptedDrag = true;
    } else {
      // Offering an acceptable operation: accept
      DnDUtils.debugPrintln("Drop target accepting drag");
      dtde.acceptDrag(dropAction);
      acceptedDrag = true;
    }

    return acceptedDrag;
  }

  protected void checkTransferType(DropTargetDragEvent dtde) {
    // Only accept a flavor that returns a Component
    acceptableType = false;
    DataFlavor[] fl = dtde.getCurrentDataFlavors();
    for (int i = 0; i < fl.length; i++) {
      Class dataClass = fl[i].getRepresentationClass();

      if (Component.class.isAssignableFrom(dataClass)) {
        // This flavor returns a Component - accept it.
        targetFlavor = fl[i];
        acceptableType = true;
        break;
      }
    }

    DnDUtils.debugPrintln("File type acceptable - " + acceptableType);
  }

  protected boolean dropComponent(Transferable transferable)
      throws IOException, UnsupportedFlavorException {
    Object o = transferable.getTransferData(targetFlavor);
    if (o instanceof Component) {
      DnDUtils.debugPrintln("Dragged component class is "
          + o.getClass().getName());
      pane.add((Component) o);
      pane.validate();
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception evt) {}
  
    final JFrame f = new JFrame("Component drop target example");

    JPanel pane = new JPanel();

    // Add a drop target to the JPanel
    PanelDropTarget target = new PanelDropTarget(pane);

    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        System.exit(0);
      }
    });

    f.getContentPane().add(new JScrollPane(pane), BorderLayout.CENTER);
    f.setSize(500, 400);
    f.setVisible(true);
  }

  protected JPanel pane;

  protected DropTarget dropTarget;

  protected boolean acceptableType; // Indicates whether data is acceptable

  protected DataFlavor targetFlavor; // Flavor to use for transfer
}

class DnDUtils {
  public static String showActions(int action) {
    String actions = "";
    if ((action & (DnDConstants.ACTION_LINK | DnDConstants.ACTION_COPY_OR_MOVE)) == 0) {
      return "None";
    }

    if ((action & DnDConstants.ACTION_COPY) != 0) {
      actions += "Copy ";
    }

    if ((action & DnDConstants.ACTION_MOVE) != 0) {
      actions += "Move ";
    }

    if ((action & DnDConstants.ACTION_LINK) != 0) {
      actions += "Link";
    }

    return actions;
  }

  public static boolean isDebugEnabled() {
    return debugEnabled;
  }

  public static void debugPrintln(String s) {
    if (debugEnabled) {
      System.out.println(s);
    }
  }

  private static boolean debugEnabled = (System
      .getProperty("DnDExamples.debug") != null);
}

