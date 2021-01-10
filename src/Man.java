public class Man implements Actions {
    private String name;
    private int runDist;
    private int heightJump;

    public Man(String name, int distancem, int heightJump) {
        this.name = name;
        this.runDist = distancem;
        this.heightJump = heightJump;
    }

    @Override
    public void run(){
        System.out.println("Человек "+ this.name + "бежит "+ this.runDist);

    }
    @Override
    public void jump(){
        System.out.println("Человек "+ this.name+ "прыгает "+ this.heightJump);
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
