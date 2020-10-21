package de.mineclashtv;

import java.io.IOException;
import java.net.InetAddress;

public class Main {

    /** Time until an address gets declared as unreachable, in milliseconds */
    public static int timeout = 500;
    /** Network to scan. Only include the first three indices! */
    public static byte[] network = new byte[] {
            (byte)192, (byte)168, 0
    };

    public static void main(String[] args) throws IOException {
        ArgumentParser.parseArguments(args);

        System.out.printf("Scanning addresses of network %s with a timeout of %dms\n",
                getStringFromByteArray(network), timeout);

        for(int i = 0; i < 256; i++) {
           byte[] address = new byte[] {
                  network[0], network[1], network[2], (byte)i
           };
           Result result = getResult(address, timeout);

           if(result == null) {
               System.out.printf("Unreachable: %s\n", getStringFromByteArray(address));
           } else {
               System.out.println(result.toString());
           }
        }
    }

    private static Result getResult(byte[] address, int timeout) throws IOException {
        InetAddress addr = InetAddress.getByAddress(address);
        long timeA = System.currentTimeMillis();

        if(addr.isReachable(timeout)) {
            long timeB = System.currentTimeMillis();
            return new Result(addr, addr.getHostName(), (int)(timeB - timeA));
        } else {
            return null;
        }
    }

    public static String getStringFromByteArray(byte[] a) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < a.length; i++) {
            byte value = a[i];
            int unsigned = Byte.toUnsignedInt(value);

            builder.append(i == a.length - 1 ? unsigned : unsigned + ".");
        }

        return builder.toString();
    }

}
