package FEST_practice;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.*;

public class PracticeGUITest {

    private FrameFixture window;

    @Before
    public void setUp() throws Exception {
        PracticeGUI frame = GuiActionRunner.execute(new GuiQuery<PracticeGUI>() {
            protected PracticeGUI executeInEDT() {
                return new PracticeGUI();  
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
    public void shouldCopyTextInLabelWhenClickingButton() {
        window.textBox("textToCopy").enterText("Some random text");
        window.button("copyButton").click();
        window.label("copiedText").requireText("Some random text");
    }
    
}
