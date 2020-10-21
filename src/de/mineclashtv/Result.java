package de.mineclashtv;

import java.net.InetAddress;

import static de.mineclashtv.Main.getStringFromByteArray;

public class Result {

    private InetAddress address;
    private String name;
    private int ping;

    public Result(InetAddress address, String name, int ping) {
        this.address = address;
        this.name = name;
        this.ping = ping;
    }

    public InetAddress getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getPing() {
        return ping;
    }

    @Override
    public String toString() {
        return "Result{" +
                "address=" + getStringFromByteArray(address.getAddress()) +
                ", name='" + name + '\'' +
                ", ping=" + ping +
                '}';
    }
}
