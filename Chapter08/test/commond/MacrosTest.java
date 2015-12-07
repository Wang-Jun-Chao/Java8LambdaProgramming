package commond;

import com.java.lambda.comand.Close;
import com.java.lambda.comand.Macro;
import com.java.lambda.comand.Open;
import com.java.lambda.comand.Save;
import org.junit.Test;

/**
 * Author: 王俊超
 * Date: 2015/12/7 16:41
 * All Rights Reserved !!!
 */
public class MacrosTest {
    @Test
    public void classBasedCommand() {
        MockEditor editor = new MockEditor();

        Macro macro = new Macro();
        macro.record(new Open(editor));
        macro.record(new Save(editor));
        macro.record(new Close(editor));
        macro.run();
    }

    @Test
    public void lambdaBasedCommand() {
        MockEditor editor = new MockEditor();

        Macro macro = new Macro();
        macro.record(() -> editor.open());
        macro.record(() -> editor.save());
        macro.record(() -> editor.close());
        macro.run();

        editor.check();
    }

    @Test
    public void referenceBasedCommand() {
        MockEditor editor = new MockEditor();

        Macro macro = new Macro();
        macro.record(editor::open);
        macro.record(editor::save);
        macro.record(editor::close);
        macro.run();

        editor.check();
    }
}
