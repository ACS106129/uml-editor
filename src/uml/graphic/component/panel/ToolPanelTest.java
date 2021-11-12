package uml.graphic.component.panel;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.awt.event.MouseEvent;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import uml.graphic.component.tool.mode.ToolMode;

public class ToolPanelTest {

    @Test
    public void test_invokeDraw_repeatedCalling_no_throws() {
        final ToolPanel toolPanel = new ToolPanel("/resources/tool_listmap");
        assertDoesNotThrow(() -> toolPanel.invokeDraw(null, null));
        IntStream.range(0, 1000000).forEach(i -> assertDoesNotThrow(() -> toolPanel
                .invokeDraw(new MouseEvent(toolPanel, i, i, 0, i, i, i, i % 2 == 0, 0), new CanvasPanel())));
    }

    @Test
    public void test_setCurrentMode_no_throws() {
        final ToolPanel toolPanel = new ToolPanel("/resources/tool_listmap");
        for (ToolMode mode : ToolMode.values())
            assertDoesNotThrow(() -> toolPanel.setCurrentMode(mode));
    }

    @Test
    public void test_setCurrentMode_nullAsParameter_throws() {
        final ToolPanel toolPanel = new ToolPanel("/resources/tool_listmap");
        assertThrows(NullPointerException.class, () -> toolPanel.setCurrentMode(null));
    }
}
