package sem5.ex02_2;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MyProgramState {
    private volatile boolean switcher;
    private volatile boolean finish;
}
