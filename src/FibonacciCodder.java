
import java.util.ArrayList;

public class FibonacciCodder {

    ArrayList<Integer> fibList = new ArrayList<Integer>();

    private int getFibonacciSequence(int key){

        fibList.add(1);
        fibList.add(2);
        int incrementor = 0;
        for ( incrementor=2;incrementor<=key;++incrementor){
            if(fibList.get(incrementor-1)==key){
                incrementor=incrementor-1;
                break;
            }else if(fibList.get(incrementor-1)>key){
                fibList.remove(incrementor-1);
                incrementor=incrementor-2;
                break;
            }else{
                System.out.println("Here");
                fibList.add(fibList.get(incrementor-1)+fibList.get(incrementor-2));
            }
        }
        System.out.println(fibList);
        System.out.println(incrementor);
        return incrementor;
    }

    public String createFibonacciCode(int key){

        int index = getFibonacciSequence(key);
        int i = index;
        char[] charSequence = new char[index+2];

        while(key>0){
            charSequence[i]='1';

            key = key - fibList.get(i);

            i = i-1;

            while(i>=0 && fibList.get(i)>key){
                charSequence[i] = '0';
                i = i-1;
            }
        }
        charSequence[index+1]='1';
        return new String(charSequence);



    }
    public static void main(String[] args) {
        System.out.println(new FibonacciCodder().createFibonacciCode(13));
    }
}
