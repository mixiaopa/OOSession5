public interface Parkable {
    public Ticket parkCar(Car car);
    public Car getCar(Ticket ticket);
    public String printResult(String prefix);
    public void add(Parkable parkable);
    public void remove(Parkable parkable);
    public Parkable getChild(int number);
}
