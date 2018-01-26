public class Sieve {
    public static int[] createSequence(int n){
        int[] sequence = new int[n];
        System.arraycopy(sequence, 2, sequence, 0, n);
        return sequence;
    }
    public static int[] sieve(int[][] sequence)
    {
        int length = (sequence.length - sequence[0][1]);
        int[] temp = new int[length];
        int i = 0;
        int x = 0;
        do{
            if(sequence[0][i] == 0){
                i++;
            }
            else{
                temp[x] = sequence[0][i];
                x++;
                i++;
            }
        }while (x < length);

        return temp;
    }
    public static int[] crossedOutMultiples(int[] sequence, int n)
    {
        int[] newSequence = new int[sequence.length];
        int i = 0;
        do{
            if(sequence[i+1] % n == 0)
            {
                newSequence[i] = 0;
            }
            else {
                newSequence[i] = sequence[i];
                i++;
            }

        }while(i < sequence.length);
        return newSequence;
    }

}
