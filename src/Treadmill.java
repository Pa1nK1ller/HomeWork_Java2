public class Treadmill extends Obstacle {

    private int length;

    public Treadmill(String name, int length) {
        super(name);
        this.length = length;
    }
    public int getLength() {
        return length;
    }
    @Override
    protected boolean move(Actions actions) {
        System.out.println("Препятствие "+ super.getName() +" Дорожка" +  " длина: " + this.length);
        actions.run();
        if (getLength() <= actions.getRinDist()) {
            System.out.println("Удалось пробежать");
            return true;
        } else {
            System.out.println("Пробежать не удалось");
            return false;
        }
    }
}
