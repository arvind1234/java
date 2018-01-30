import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWrite {

    static class Sample {
        String id;
        String name;
        String payment;

        Sample(String id, String name, String payment) {
            this.id = id;
            this.name = name;
            this.payment = payment;
        }
    }

    public FileWrite() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Sample> samples = new ArrayList<Sample>();
        String homeDirectory = System.getProperty("user.home");
        // /Users/arvindve/Desktop/output.csv
        // construct the desktop path using homeDirectory
        FileWriter fw = new FileWriter(homeDirectory + "/Desktop/output.csv");
        BufferedWriter out = new BufferedWriter(fw);

        for(int i = 0 ; i < 5; i++) {
            samples.add(new Sample("Id_" + i, "Name_" + i, "Payment_" + i));
        }

        // print header line
        out.write("id,name,payment");
        out.newLine();

        for(int i = 0; i <samples.size(); i++) {
            Sample s = samples.get(i);
            out.write( s.id + "," + s.name + "," + s.payment);
            out.newLine();
        }

        out.close();
    }

}
