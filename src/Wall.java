public class Wall extends Obstacle {
    private int height;

    public Wall(String name, int height) {
        super(name);
        this.height = height;
    }
    public int getHeight() {
        return height;
    }
    @Override
    protected boolean move(Actions actions) {
        System.out.println("Препятствие " + super.getName() + " Стена " + " высота " + this.height);
        actions.jump();
        if (getHeight() <= actions.getJumpHeight()) {
            System.out.println("Удалось перепрыгнуть");
            return true;
        } else {
            System.out.println("Перепрыгнуть не удалось");
            return false;
        }
    }
}
