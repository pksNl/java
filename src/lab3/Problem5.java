import java.io.*;

public class Problem5 {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java RemoveText string filename");
            System.exit(1);
        }

        String target = args[0];
        File file = new File(args[1]);

        if (!file.exists()) {
            System.out.println("Error: File " + file + " does not exist.");
            System.exit(1);
        }

        String tempFile = "temp.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        while ((line = reader.readLine()) != null) {
            line = line.replaceAll(target, "");
            writer.write(line);
            writer.newLine();
        }

        reader.close();
        writer.close();

        file.delete();
        new File(tempFile).renameTo(file);

        System.out.println("All occurrences of \"" + target + "\" removed from " + file);
    }
}
