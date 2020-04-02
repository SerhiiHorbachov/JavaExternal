package ua.com.computers.models;

public class Part extends Entity {
    private int id;

    private String name;

    private String origin;

    private int price;

    private String currency;


    private boolean critical;

    private int type_id;

    private Type type = new Type();

    public Part() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean getCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public static class Type extends Entity {

        private int id;
        private boolean periphery;
        private int energyConsumption;
        private String units;
        private boolean coolerIncluded;
        private String group;
        private String port;

        public Type() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isPeriphery() {
            return periphery;
        }

        public void setPeriphery(boolean periphery) {
            this.periphery = periphery;
        }

        public int getEnergyConsumption() {
            return energyConsumption;
        }

        public void setEnergyConsumption(int energyConsumption) {
            this.energyConsumption = energyConsumption;
        }

        public String getUnits() {
            return units;
        }

        public void setUnits(String units) {
            this.units = units;
        }

        public boolean isCoolerIncluded() {
            return coolerIncluded;
        }

        public void setCoolerIncluded(boolean coolerIncluded) {
            this.coolerIncluded = coolerIncluded;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

        @Override
        public String toString() {
            return "Type{" +
                    "id='" + id + '\'' +
                    "periphery=" + periphery +
                    ", energyConsumption=" + energyConsumption +
                    ", units='" + units + '\'' +
                    ", coolerIncluded=" + coolerIncluded +
                    ", group='" + group + '\'' +
                    ", ports=" + port +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Part{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", price='" + price + '\'' +
                ", currency='" + currency + '\'' +
                ", critical='" + critical + '\'' +
                ", type_id=" + type_id +
                ", type=" + type +
                '}';
    }
}
