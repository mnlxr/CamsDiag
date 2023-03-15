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
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComplexExample extends JFrame implements DragGestureListener {
  public ComplexExample() {
    JPanel left = new JPanel();
    left.setBackground(Color.red);

    JPanel right = new JPanel();
    right.setBackground(Color.white);

    new MyDropTargetListener(right);

    DragSource ds = new DragSource();
    ds.createDefaultDragGestureRecognizer(left, DnDConstants.ACTION_COPY, this);

    setLayout(new FlowLayout());
    add(left);
    add(right);

    setSize(40,50);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public void dragGestureRecognized(DragGestureEvent event) {
    Cursor cursor = null;
    JPanel panel = (JPanel) event.getComponent();

    Color color = panel.getBackground();
    if (event.getDragAction() == DnDConstants.ACTION_COPY) {
      cursor = DragSource.DefaultCopyDrop;
    }
    event.startDrag(cursor, new TransferableColor(color));
  }

  class MyDropTargetListener extends DropTargetAdapter {
    private DropTarget dropTarget;
    private JPanel panel;

    public MyDropTargetListener(JPanel panel) {
      this.panel = panel;
      dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);
    }

    public void drop(DropTargetDropEvent event) {
      try {
        Transferable tr = event.getTransferable();
        Color color = (Color) tr.getTransferData(TransferableColor.colorFlavor);
        if (event.isDataFlavorSupported(TransferableColor.colorFlavor)) {
          event.acceptDrop(DnDConstants.ACTION_COPY);
          this.panel.setBackground(color);
          event.dropComplete(true);
          return;
        }
        event.rejectDrop();
      } catch (Exception e) {
        e.printStackTrace();
        event.rejectDrop();
      }
    }
  }

  public static void main(String[] args) {
    new ComplexExample();
  }
}

class TransferableColor implements Transferable {
  protected static DataFlavor colorFlavor = new DataFlavor(Color.class, "A Color Object");
  protected static DataFlavor[] supportedFlavors = { colorFlavor };
  Color color;
  public TransferableColor(Color color) {
    this.color = color;
  }

  public DataFlavor[] getTransferDataFlavors() {
    return supportedFlavors;
  }

  public boolean isDataFlavorSupported(DataFlavor flavor) {
    if (flavor.equals(colorFlavor) || flavor.equals(DataFlavor.stringFlavor))
      return true;
    return false;
  }

  public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
    if (flavor.equals(colorFlavor))
      return color;
    else if (flavor.equals(DataFlavor.stringFlavor))
      return color.toString();
    else
      throw new UnsupportedFlavorException(flavor);
  }
}

