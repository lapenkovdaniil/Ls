import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class Parser {
    @Option(name = "-l", usage = "Long format")
    private static boolean lFlag = false;

    @Option(name = "-h", usage = "Human-readable")
    private static boolean hFlag = false;

    @Option(name = "-r", usage = "Reverse")
    private static boolean rFlag = false;

    @Option(name = "-o", usage = "Output file name")
    private static String outputPath;

    @Argument(metaVar = "InputName", usage = "Input file name")
    private String inputFileName;


    public static void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(args);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("Ls [-l] [-h] [-r] [-o output.file] directory_or_file");
            parser.printUsage(System.err);
        }
        try {
            Ls ls = new Ls(false, false, false, "");
            Ls.main(args);
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
    }
}