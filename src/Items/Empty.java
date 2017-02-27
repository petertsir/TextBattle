package Items;
/**
 * Created by peter on 2/18/17.
 */
public class Empty extends Item{
    public final static Empty empty = new Empty();
    public Empty() {
        System.out.println("This spot in your inventory is empty.");
    }


}
