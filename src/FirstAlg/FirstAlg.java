package FirstAlg;

public class FirstAlg {
    public static void main(String[] args) {

        int [] array = {13,5,17,16,4,21};

        int største = array[0];

        for (int i = 1; i < array.length; i++) {
            int nå = array[i];
            if (nå > største) {
                største = nå;
            }
        }
        System.out.println("Dette er det største tallet: " + største);
    }
}
