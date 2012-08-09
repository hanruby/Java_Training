package GUI;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;

public class ObjectField extends JTextField {

    private static final long serialVersionUID = 2552391809039249611L;

    private Object object;

    public ObjectField(int col) {
        super(col);
        
        // ドロップされたとき
        this.setTransferHandler(new TransferHandler(){

            private static final long serialVersionUID = 496673230072108468L;
            
            public final DataFlavor localObjectFlavor = new DataFlavor (
                    DefaultMutableTreeNode.class, "This is tree node.");

            @Override
            public boolean canImport(TransferSupport support) {
                // クリップボード経由のデータ転送は扱わない
                if (!support.isDrop()) {
                    return false;
                }

                // ドロップする位置を常に表示する
                support.setShowDropLocation(true);

                // フレーバの指定
                if (support.isDataFlavorSupported(localObjectFlavor)) {
                    return true;
                }
                
                return false;
            }

            @Override
            public boolean importData(TransferSupport support) {
                // クリップボード経由のデータ転送は扱わない
                if (!support.isDrop()) {
                    return false;
                }

                ObjectField text = (ObjectField) support.getComponent();
                try {
                    // ドロップデータ
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) support.getTransferable().getTransferData(localObjectFlavor);
                    Object obj = node.getUserObject();
                    text.setText(obj.toString());
                    text.setObject(obj);
                    return true;

                } catch (UnsupportedFlavorException ex) {
                    System.out.println(ex);
                } catch (IOException ex) {
                    System.out.println(ex);
                }

                return false;
            }
        });
    }
    
    public void setObject(Object obj) {
        this.object = obj;
    }

    public Object getObject() {
        return object;
    }
}
