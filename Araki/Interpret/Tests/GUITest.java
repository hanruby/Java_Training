package Tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.*;

import GUI.*;

public class GUITest {

    private FrameFixture window;

    @Before
    public void setUp() throws Exception {
        InterpretGUI frame = GuiActionRunner.execute(new GuiQuery<InterpretGUI>() {
            protected InterpretGUI executeInEDT() {
                return new InterpretGUI("Test");  
            }
        });
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
    }

    @After 
    public void tearDown() {
        window.cleanUp();
    }
    
    
    @Test
    public void addClass() {
        
        window.textBox("classNameField").setText("java.lang.Object");
        
        window.button("addClassButton").click();
        window.textBox("classNameField").requireText("");
        
        window.tree("classTree").expandPath("Class/java.lang.Object");


        // get error message
        window.textBox("classNameField").setText("Object");
        window.button("addClassButton").click();
        //window.textBox("Console").requireText(Pattern.compile("Could not found class.*"));
        
    }
    
}
