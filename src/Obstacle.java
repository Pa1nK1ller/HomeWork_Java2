public abstract class Obstacle {
    private String name;

    public Obstacle(String name) {
        this.name = name;
    }
    protected abstract boolean move(Actions actions);
    public String getName() {
        return name;
    }
}
