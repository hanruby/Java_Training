package Tests;


import javax.swing.text.JTextComponent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.Robot;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.*;

import static org.fest.swing.data.TableCell.row;

import GUI.*;

public class Demo {

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
    
    
    public void addClass(String className) {
        window.textBox("classNameField").setText(className);
        window.button("addClassButton").click();
    }
    
    @Test
    public void demo1() {
        // Object
        addClass("java.lang.Object");
        
        window.tree("classTree").expandPath("Class/java.lang.Object");
        window.tree("classTree").expandPath("Class/java.lang.Object/public java.lang.Object()");

        window.textBox("objectNameField").setText("object");
        window.button("addObjectButton").click();
        
        window.tree("objectTree").expandPath("Object/object");
        window.tree("objectTree").expandRow(2);
     
        // Integer
        addClass("java.lang.Integer");
        window.tree("classTree").expandPath("Class/java.lang.Integer");
        window.tree("classTree").expandPath("Class/java.lang.Integer/public java.lang.Integer(int)");        

        window.textBox("objectNameField").setText("int object");
        //window.table("table").cell(row(0).column(1)).startEditing().enterValue("12");
        //window.button("addObjectButton").click();

        JTableCellFixture cell = window.table("table").cell(row(0).column(1));
        
        cell.startEditing();
        cell.doubleClick();
        try {
            cell.rightClick();
            cell.enterValue("12");            
        } catch (org.fest.swing.exception.ActionFailedException e) {

        }
        cell.stopEditing();
        
        window.textBox("classNameField").enterText("exit!!!!!!!!!!");
    }
    
}
