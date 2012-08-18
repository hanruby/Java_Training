package Tests;


import static org.junit.Assert.*;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.*;

import GUI.*;

public class GUITest {

    private static FrameFixture window;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        InterpretGUI frame = GuiActionRunner.execute(new GuiQuery<InterpretGUI>() {
            protected InterpretGUI executeInEDT() {
                InterpretGUI gui = new InterpretGUI("Test");

                // set LAF to default 
                String lafClassName = "javax.swing.plaf.metal.MetalLookAndFeel";
                try{
                    UIManager.setLookAndFeel(lafClassName);
                    SwingUtilities.updateComponentTreeUI(gui);
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                return gui;  
            }
        });
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
    }

    @AfterClass
    public static void tearDownAfterClass() {
        window.cleanUp();
    }
    
    @Test
    public void addClass() {
        
        window.textBox("classNameField").setText("java.lang.Object");
        
        window.button("addClassButton").click();
        window.textBox("classNameField").requireText("");
        
        window.tree("classTree").expandPath("Class/java.lang.Object");
    }
    
    @Test
    public void addInvalidClass() throws Exception {
        // get error message
        window.textBox("classNameField").setText("Object");
        window.button("addClassButton").click();
        //window.textBox("Console").requireText(Pattern.compile("Could not found class.*"));
    }
}
