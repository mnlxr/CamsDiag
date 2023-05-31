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
import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author MManolas
 */
public class Main extends JFrame implements DropTargetListener {
  DropTarget dt;
  JTextArea ta = new JTextArea();

    /**
     *
     */
    public Main() {
    super("Drop Test");
    setSize(300, 300);
    getContentPane()
        .add(new JLabel("Drop something here:"), BorderLayout.NORTH);
    
    ta.setBackground(Color.white);
    getContentPane().add(ta, BorderLayout.CENTER);
    dt = new DropTarget(ta, this);
    setVisible(true);
  }

    /**
     *
     * @param dtde
     */
    public void dragEnter(DropTargetDragEvent dtde) {
    System.out.println("Drag Enter");
  }

    /**
     *
     * @param dte
     */
    public void dragExit(DropTargetEvent dte) {
    System.out.println("Drag Exit");
  }

    /**
     *
     * @param dtde
     */
    public void dragOver(DropTargetDragEvent dtde) {
    System.out.println("Drag Over");
  }

    /**
     *
     * @param dtde
     */
    public void dropActionChanged(DropTargetDragEvent dtde) {
    System.out.println("Drop Action Changed");
  }

    /**
     *
     * @param dtde
     */
    public void drop(DropTargetDropEvent dtde) {
    try {
      Transferable tr = dtde.getTransferable();
      DataFlavor[] flavors = tr.getTransferDataFlavors();
      for (int i = 0; i < flavors.length; i++) {
        if (flavors[i].isFlavorJavaFileListType()) {
          dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
          List list = (List) tr.getTransferData(flavors[i]);
          for (int j = 0; j < list.size(); j++) {
            ta.append(list.get(j) + "\n");
          }
          dtde.dropComplete(true);
          return;
        } else if (flavors[i].isFlavorSerializedObjectType()) {
          dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
          Object o = tr.getTransferData(flavors[i]);
          ta.append("Object: " + o);
          dtde.dropComplete(true);
          return;
        } else if (flavors[i].isRepresentationClassInputStream()) {
          dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
          ta.read(new InputStreamReader((InputStream) tr.getTransferData(flavors[i])),
              "from system clipboard");
          dtde.dropComplete(true);
          return;
        }
      }
      dtde.rejectDrop();
    } catch (Exception e) {
      e.printStackTrace();
      dtde.rejectDrop();
    }
  }

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
    new Main();
  }
}
