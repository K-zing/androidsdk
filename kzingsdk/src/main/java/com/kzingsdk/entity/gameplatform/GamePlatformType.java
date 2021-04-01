package com.kzingsdk.entity.gameplatform;


public enum GamePlatformType {

    LIVE(1234, ""),
    SPORT(2234, ""),
    GAME(3234, ""),
    LOTTERY(4234, ""),
    CHESS(5234, ""),
    ESPORT(6234, ""),
    FISHING(7234, ""),
    DINGDONG(8234, ""),
    POKER(9234, ""),
    ANIMAL(10234, "");

    private final int id;
    private String name;

    GamePlatformType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GamePlatformType origin() {
        return GamePlatformType.valueOfTypeId(id);
    }

    public static GamePlatformType valueOfTypeId(int typeId) {
        for (GamePlatformType type : GamePlatformType.values()) {
            if (type.getId() == typeId) {
                return type;
            }
        }
        return null;
    }
}
