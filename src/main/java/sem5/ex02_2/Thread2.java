package sem5.ex02_2;

public class Thread2 extends Thread{

    private MyProgramState state;

    public Thread2(MyProgramState state) {
        this.state = state;
    }

    @Override
    public void run() {
        int i = 100;
        while(!state.isFinish() && i > 0){
            if(state.isSwitcher()){
                System.out.println(i--);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        state.setFinish(true);
    }
}
