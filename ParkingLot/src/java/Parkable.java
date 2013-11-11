public interface Parkable {
    public Ticket parkCar(Car car);
    public Car getCar(Ticket ticket);
    public void printResult();
    public void add(Parkable parkable);
    public void remove(Parkable parkable);
    public Parkable getChild(int number);
}
