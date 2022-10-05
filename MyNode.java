
public class MyNode<Type extends Comparable<Type>>{
    public Type item;
    public MyNode<Type> next;
    MyNode(Type item) {
        this.item=item;
    }
    public String toString(){
        return "{item =>"+item+", next => "+next+" }";
    }

}
