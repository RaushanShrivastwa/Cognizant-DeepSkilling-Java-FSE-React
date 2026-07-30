package com.cognizant.ex03_builder;

class Computer {
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final boolean isGraphicsCardEnabled;
    private final boolean isBluetoothEnabled;

    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public boolean isGraphicsCardEnabled() { return isGraphicsCardEnabled; }
    public boolean isBluetoothEnabled() { return isBluetoothEnabled; }

    @Override
    public String toString() {
        return "Computer Configuration [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage +
                ", Graphics Card=" + (isGraphicsCardEnabled ? "Yes" : "No") +
                ", Bluetooth=" + (isBluetoothEnabled ? "Yes" : "No") + "]";
    }


    public static class ComputerBuilder {
        private final String CPU;
        private final String RAM;
        private String storage = "256GB SSD";
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }


        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }


        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Testing Builder Pattern ===");

        Computer gamingComputer = new Computer.ComputerBuilder("Intel i9", "32GB")
                .setStorage("1TB NVMe SSD")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        System.out.println("Gaming Configuration:");
        System.out.println(gamingComputer);

        System.out.println("------------------------------------");

        Computer officeComputer = new Computer.ComputerBuilder("Intel i3", "8GB")
                .build();

        System.out.println("Office Configuration:");
        System.out.println(officeComputer);
    }
}