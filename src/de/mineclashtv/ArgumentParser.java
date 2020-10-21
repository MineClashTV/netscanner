package de.mineclashtv;

public class ArgumentParser {

    public static void parseArguments(String... args) {
        for(int i = 0; i < args.length; i++) {
            switch(args[i]) {
                case "-n":
                case "--network":
                    String[] values = args[i + 1].split("\\.");
                    Main.network = new byte[] {
                            /* Byte.parseByte doesn't work here for values > 127 because of signedness,
                             * so do this garbage instead. May be fixable by changing radix, but idk how that works */
                            (byte)Integer.parseInt(values[0]),
                            (byte)Integer.parseInt(values[1]),
                            (byte)Integer.parseInt(values[2])
                    };
                    break;
                case "-t":
                case "--timeout":
                    Main.timeout = Integer.parseInt(args[i + 1]);
                    break;
            }
        }
    }
}
