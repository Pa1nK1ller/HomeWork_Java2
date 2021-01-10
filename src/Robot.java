public class Robot implements Actions {
    private String name;
    private int runDist;
    private int heightJump;

    public Robot(String name, int distance, int heightJump) {
        this.name = name;
        this.runDist = distance;
        this.heightJump = heightJump;
    }
    public void run(){
        System.out.println("Робот "+ this.name + "бежит "+ this.runDist);
    }
    public void jump(){
        System.out.println("Робот "+ this.name+ "прыгает "+ this.heightJump);
    }

    @Override
    public int getRinDist() {
        return runDist;
    }

    @Override
    public int getJumpHeight() {
        return heightJump;
    }
}
