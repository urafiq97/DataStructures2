import java.util.Arrays;
public class HashTroy<key>
{
    private key[] ht;
    private int cap;
    private int logicalSize;
    
    public HashTroy(int capacity){
        this.cap = capacity;
        ht = (key[])new Object[capacity];}
    
    public HashTroy(){
        this(16);}
        
    public int hash(key Key){
        return (Key.hashCode()& 0x7fffffff) % cap;}    
    //Desired load factor is between 1/2 and 1/8 for efficiency
    //Since our code does not have delete functionality, resizing down is not pertinent
    public double loadFactor(){
        return 1.0*logicalSize/cap;}
    
    private void resize(int newCap){
        HashTroy<key> temp;
        temp = new HashTroy<key>(newCap);
        for (int i = 0;i < this.cap;i++){
            if (this.ht[i] != null){
            temp.put(ht[i]);}}
        this.ht = temp.ht;
        this.cap = temp.cap;}
        
    public void put(key Key){
        if (this.loadFactor()>=0.5){
            resize(2*cap);}
        int i;
        for (i = hash(Key); this.ht[i] != null; i = (i + 1) % cap){
            }
        this.ht[i] = Key;
        logicalSize++;}
    
    public int get(key Key){
        for (int i = hash(Key); ht[i] != null; i = (i+1)%cap){
            if (ht[i].equals(Key)){ 
                return i;}}
            return -1;
        
        }
        
    public String toString(){ return Arrays.toString(this.ht); }
    
    public static void main(String[] args){
        HashTroy<Integer> h = new HashTroy<>();
        System.out.println(h);
        h.put(123);
        System.out.println(h.hash(123));
        System.out.println(h);
        System.out.println(h.get(123));
        for (int i = 0; i < 17; i++){
            h.put((int)(Math.random()*300)+500);
            System.out.println(h);}
        System.out.println(h.hash(123));
        System.out.println(h.get(123));}
    
}