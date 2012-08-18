package Tests;


import static org.junit.Assert.*;

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
                return new InterpretGUI("Test");  
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
