package ch16.Interpret;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.lang.reflect.Constructor;

import javax.swing.JTextField;
import javax.swing.TransferHandler;

public class ObjectField extends JTextField {

    private static final long serialVersionUID = 2552391809039249611L;

    private Constructor<?> constructor;

    public ObjectField(int col) {
        super(col);
        
        // ドロップされたとき
        this.setTransferHandler(new TransferHandler(){

            private static final long serialVersionUID = 496673230072108468L;
            
            public final DataFlavor localObjectFlavor = new DataFlavor (
                    Constructor.class, "This is Constructor.");

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

                ConstructorField text = (ConstructorField)support.getComponent();
                try {
                    // ドロップデータ
                    Object obj = support.getTransferable().getTransferData(localObjectFlavor);
                    if (obj instanceof Constructor<?>) {
                        Constructor<?> constructor = (Constructor<?>) obj;
                        text.setText(constructor.toString());
                        text.setConstructor(constructor);
                    }
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
    
    public void setConstructor(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    public Constructor<?> getConstructor() {
        return constructor;
    }
}
