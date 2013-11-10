public interface Parkable {
    public Ticket parkCar(Car car);
    public Car getCar(Ticket ticket);
    public void printResult();
}
