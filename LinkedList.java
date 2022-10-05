
public class LinkedList<Type extends Comparable<Type>>{
    public MyNode<Type> head;
    public MyNode<Type> tail;
    LinkedList(){
        head=null;
        tail=null;
    }

    public void insertAtBegening(Type item){
        if (isEmpty()) {
            head=tail= new MyNode<Type>(item);
        }
        else{
            MyNode<Type> temp = new MyNode<Type>(item);
            temp.next=head;
            head=temp;
        }
    }
    public boolean isEmpty(){
        if(head==null){
            return true;
        }
        else{
            return false;
        }
    }
    public void append(Type item){
        MyNode<Type> newNode = new MyNode<Type>(item);
        if(isEmpty()){
            head=tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
    }
    public int size(){
        int count=0;
        MyNode<Type> currentNode = head;
        while(currentNode.next!=null){
            count++;
            currentNode=currentNode.next;
        }
        return count;
    }

    public void insertAtGivenPosition(int position, Type item){
        MyNode<Type> newNode = new MyNode<Type>(item);
        if(position==0){
            insertAtBegening(item);
        }
        else if(size()<position){
            append(item);
        }
        else{
            MyNode<Type> currentNode = head;
            for(int i = 0; i < (position - 1 );i++){
                currentNode=currentNode.next;
            }
            newNode.next=currentNode.next;
            currentNode.next=newNode;

        }
    }
    public void removeItem(Type item){
        if(head.item.equals(item)){
            if(head==tail){
                head=tail=null;
            }
            else{
                head=head.next;
            }
        }
    }
    public Type pop(){
        if(isEmpty()){
            return null;
        }
        else if(size()==1){
            Type temp=head.item;
            head=tail=null;
            return temp;
        }
        else{
            Type temp = tail.item;
            MyNode<Type> currentNode = head;
            while(currentNode.next!=null){
                currentNode=currentNode.next;
                tail=currentNode;
                tail.next=null;
            }
            return temp;
        }

    }
    public String toString(){
        if(head!=null){
            return head.toString();
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtBegening(55);
        ll.insertAtBegening(78);
        ll.insertAtGivenPosition(2,46);
        ll.append(63);
        System.out.println(ll);
        ll.removeItem(46);
        ll.pop();
        System.out.println(ll);
    }
}
