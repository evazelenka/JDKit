package sem5.ex02_2;

public class Thread1 extends Thread{

    private MyProgramState state;

    public Thread1(MyProgramState state) {
        this.state = state;
    }

    @Override
    public void run() {
        while (!state.isFinish()){
            state.setSwitcher(!state.isSwitcher());
            if (!state.isSwitcher()){
                System.out.println("pause");
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
