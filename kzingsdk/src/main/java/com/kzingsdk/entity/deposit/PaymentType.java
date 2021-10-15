package com.kzingsdk.entity.deposit;

public enum PaymentType {

    THIRD_PARTY("1", "paymentType"),
    ATM("2", "paymentAtmType"),
    PHONE("69", "Phone"),
    EWALLET("73", "Ewallet"),
    PREPAIDCARD("99", "Prepaid Card"),
    CRYPTO("crypto", "cryptoAtmType"),
    MICRO("101", "microAtmPayment"),
    OTHER("-1", "Other"),
    ;


    private final String id;
    private String name;

    PaymentType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaymentType origin() {
        return PaymentType.valueOfTypeId(id);
    }

    public static PaymentType valueOfTypeId(String typeId) {
        for (PaymentType type : PaymentType.values()) {
            if (type.getId().equalsIgnoreCase(typeId)) {
                return type;
            }
        }
        return OTHER;
    }

    public static PaymentType valueOfTypeName(String name) {
        for (PaymentType type : PaymentType.values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return OTHER;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}
