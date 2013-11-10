public abstract class Component {
    public abstract void add(Parkable parkable);
    public abstract void remove(Parkable parkable);
    public abstract Parkable getChild(int number);
}
