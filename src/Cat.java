public class Cat implements Actions {
    private String name;
    private int runDist;
    private int heightJump;

    public Cat(String name, int distance, int heightJump) {
        this.name = name;
        this.runDist = distance;
        this.heightJump = heightJump;
    }
    @Override
    public void run(){
        System.out.println("Кот "+ this.name + "бежит "+ this.runDist);
    }
    @Override
    public void jump(){
        System.out.println("Кот "+ this.name+ "прыгает "+ this.heightJump);
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
